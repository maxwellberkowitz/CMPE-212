import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Assn2_20019830 {
	
	// Method calling all other methods and intended to be of highest level
	// of abstraction besides main(). This method aims to, for a given motor,
	// screen an excel file for surges and surge times, and write all surge
	// instances to a text file. This method must be called individually for
	// every motor being monitored.
	public static void writeSurgeData(String readFileName, String writeFileName, int motorNumber) {
		ArrayList<Integer> surgeTimes = getSurgeTimes(readFileName, motorNumber);
		for (int i = 0; i < surgeTimes.size(); i++){
			System.out.println(surgeTimes.get(i)); // temporary loop. just trying to see if correct values
												   // have been retrieved.
		}
	}
	
	// Method will write a set of surge times and average values for a given
	// array to a text file. The array argument given will be the output of
	// the This method can only write to one file per call.
	public static void textFileWriter(String filename, double[] surgeVals, double[] surgeTimes) {
/*		Path file = Paths.get(filename);
		try (BufferedWriter writer = Files.newBufferedWriter(file)){
			for(double aVal : array)
				writer.write(aVal + "\r\n");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}*/
	}
	
	// Method will take array argument output from getSurgeTimes, calculate
	// average values for each duration, and return them in a cronologically
	// ordered array. The argument array size should be twice that of the
	// returned array size.
/*	public static double [] getAvg(double surgeVals[]) {
		
	}*/
	
	// Method will return an array with the first and last seconds of all surges
	// in a given motor. First second will immediately precede last second of a 
	// given surge. Array size will be an integer multiple of 2.
	public static ArrayList<Integer> getSurgeTimes(String readFileName, int motorNumber) {
		int [] allVals = new int[1000];
		ByteBuffer buff = ByteBuffer.allocate(4 * 1000);
		IntBuffer intBuff = buff.asIntBuffer();
		Path file = Paths.get(readFileName);
		ArrayList<Integer> surgeTimes = new ArrayList<Integer>();
		if (Files.exists(file, LinkOption.NOFOLLOW_LINKS) && Files.isReadable(file)) {
			StandardOpenOption readOpt = StandardOpenOption.READ;
			try (FileChannel fc = (FileChannel.open(file, readOpt))) {
				// As far as I understand, I need to loop through all 1000 values in the given motor
				// column, and put these values in the buffer. But I have no idea how to reference the
				// correct location starting location, or how to increment from there...
/*				fc.position(0);
				fc.read(buff);*/
			} catch (IOException err) {
				System.out.println("I/O Exception: " + err);
			}
			intBuff.get(allVals);
			boolean firstSurgeTimeFound = false;
			for(int i = 0; i < 1000; i++) {
				if(1 < allVals[i] && firstSurgeTimeFound == false) {
					surgeTimes.add(allVals[i]);
					firstSurgeTimeFound = true;
				}
				else if(allVals[i] < 1 && firstSurgeTimeFound == true) {
					surgeTimes.add(allVals[i]);
					firstSurgeTimeFound = false;
				}
			}
		}
		else {
			surgeTimes = null;
		}
		return surgeTimes;
	}
	
	public static void main(String[] args) {
		writeSurgeData("Logger.csv", "Motor1.txt", 1);
		/*writeSurgeData("Logger.csv", "Motor2.txt", 2);
		writeSurgeData("Logger.csv", "Motor3.txt", 3);
		writeSurgeData("Logger.csv", "Motor4.txt", 4);
		writeSurgeData("Logger.csv", "Motor5.txt", 5);
		writeSurgeData("Logger.csv", "Motor6.txt", 6);
		writeSurgeData("Logger.csv", "Motor7.txt", 7);*/
	}

}
