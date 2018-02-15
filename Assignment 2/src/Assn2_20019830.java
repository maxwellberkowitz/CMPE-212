/*
 * This program was made to read motor current data and analyze it for surges.
 * Results are output into .csv files, with one file created per motor.
 * 
 * for CMPE212 Assignment 2, by Max Berkowitz (15mab25@queensu.ca)
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Assn2_20019830 {

	// Method calling all other methods and intended to be of highest level
	// of abstraction besides main(). This method aims to, for a given motor,
	// screen a .csv file for surges and surge times, and write all surge
	// instances to a text file. This method must be called individually for
	// every motor being monitored.
	public static void writeSurgeData(String readFileName, String writeFileName, int motorNumber) {
		double [] allVals = getCol(readFileName, motorNumber); // Gets all current values for motor
		ArrayList<Integer> surgeTimes = getSurgeTimes(allVals); // Gets the first and last values of all surges
		double [] surgeAvgs = getAvg(allVals , surgeTimes); // Averages the currents during each surge
		textFileWriter(writeFileName, surgeAvgs, surgeTimes); // Outputs surge times and averages to new file
	} // end writeSurgeData method 

	// Method will write a set of surge times and average values for a given
	// array to a text file. This method can only write to one file per call.
	public static void textFileWriter(String writeFileName, double[] surgeAvgs, ArrayList<Integer> surgeTimes) {
		try {
			PrintWriter writer = new PrintWriter(writeFileName, "UTF-8");
			String currentExceeded = "";
			if(surgeAvgs.length < 1)
				writer.println("Not used."); // If no surges occur
			else {
				writer.printf("start (sec), finish (sec), current (amps)");
				for(int i = 0; i < surgeAvgs.length; i++) {
					if(surgeAvgs[i] > 8)
						currentExceeded = ", ***Current Exceeded***";
					writer.printf("%n%d, %d, %.3f%s", surgeTimes.get(i*2), surgeTimes.get((i*2)+1), surgeAvgs[i], currentExceeded);
					currentExceeded = ""; // Reseting current exceeded indicator for next surge
				}
			}
			writer.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			System.err.println(e.getMessage());
		}
	} // end textFileWriter method

	// Method will take ArrayList output from getSurgeTimes, calculate
	// average values for each duration, and return them in a chronologically
	// ordered array. The argument array size should be twice that of the
	// returned array size.
	public static double[] getAvg(double allVals[], ArrayList<Integer> surgeTimes) {
		double [] avgs = new double [surgeTimes.size()/2]; // One surge average expected per first/last second of surge
		for(int i = 0; i < avgs.length; i ++) { // Loop to add all values within the surge time
			for(int j = surgeTimes.get(i*2); j <= surgeTimes.get((i*2)+1); j++) {
				avgs[i] += allVals[j];
			}
			avgs[i] = avgs[i]/(surgeTimes.get((i*2)+1)-(surgeTimes.get(i*2)-1)); // Dividing by the surge duration
		}
		return avgs;
	} // end getAvg method

	// Method will return an ArrayList with the first and last seconds of all surges
	// in a given motor. First second will immediately precede last second of a
	// given surge. ArrayList size will be an integer multiple of 2. ArrayList was
	// used since number of surges (and thus array size) is unknown.
	public static ArrayList<Integer> getSurgeTimes(double[] allVals) {
		ArrayList<Integer> surgeTimes = new ArrayList<Integer>();
		boolean firstSurgeTimeFound = false;
		for (int j = 0; j < 1000; j++) {
			if (1 < allVals[j] && firstSurgeTimeFound == false) {
				surgeTimes.add(j);
				firstSurgeTimeFound = true; // Loop will now continue to add subsequent values until value becomes false
			} else if (allVals[j] < 1 && firstSurgeTimeFound == true) {
				surgeTimes.add((j - 1));
				firstSurgeTimeFound = false; // Loop will no longer add subsequent values to ArrayList
			}
		}
		return surgeTimes;
	} // end getSurgeTimes method
	
	// Method used to get a full column of current values for a given motor
	// and return it as an array
	public static double[] getCol(String readFileName, int motorNumber) {
		double[] allVals = new double[1000];
		String line = null;
		try {
			FileReader fileReader = new FileReader(readFileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			int i = 0;
			while ((line = bufferedReader.readLine()) != null) { // While there are still lines to read
				StringTokenizer st = new StringTokenizer(line); // Tokenizing line of data for all 7 motors
				for (int j = 0; j < motorNumber; j++) // Moving towards desired token
					st.nextToken();
				String str = st.nextToken();
				if (str.charAt(str.length()-1) == ',')
					str = str.substring(0, str.length() - 1); // Removing comma so string can be cast as integer
				allVals[i] = Double.parseDouble(str);
				i++;
			}
			bufferedReader.close();
		} catch (NumberFormatException e) {
			System.out.println("I/O Exception: " + e);
		} catch (IOException e) {
			System.out.println("I/O Exception: " + e);
		}
		return allVals;
	} // end getCol method

	public static void main(String[] args) {
		writeSurgeData("Logger.csv", "Motor1.csv", 1);
		writeSurgeData("Logger.csv", "Motor2.csv", 2);
		writeSurgeData("Logger.csv", "Motor3.csv", 3);
		writeSurgeData("Logger.csv", "Motor4.csv", 4);
		writeSurgeData("Logger.csv", "Motor5.csv", 5); 
		writeSurgeData("Logger.csv", "Motor6.csv", 6); 
		writeSurgeData("Logger.csv", "Motor7.csv", 7);
		System.out.println("All done.");
	} // end main method
}
