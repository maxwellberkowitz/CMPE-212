import java.util.Scanner;
import java.util.InputMismatchException;

public class IOHelper {
	
	static Scanner input = new Scanner(System.in);
	public static int getInt(int low, String prompt, int high) 
	{
		int userNum=0;
		boolean inputOK = false;
		String dummy;
		do
		{
			System.out.print(prompt);
			try {
				userNum = input.nextInt();
				inputOK = true;
			}
			catch(InputMismatchException e){
				dummy = input.nextLine();
				System.out.println("\"" + dummy + "\" is not an integer!");
			}
			if(userNum < low || userNum > high) {
				System.out.println("The number is outside the legal limits.");
			}
		} while(!inputOK || userNum < low || userNum > high);
		return userNum;
	}
	
	public static int getInt(int low, String prompt)
	{
		int high = Integer.MAX_VALUE;
		int userNum = getInt(low, prompt, high);
		return userNum;
	}
	
	public static int getInt(String prompt, int high)
	{
		int low = Integer.MIN_VALUE;
		int userNum = getInt(low, prompt, high);
		return userNum;
	}
	
	public static int getInt(String prompt)
	{
		int high = Integer.MAX_VALUE;
		int low = Integer.MIN_VALUE;
		int userNum = getInt(low, prompt, high);
		return userNum;
	}

	public static int getInt()
	{
		String prompt = "Please enter any integer: ";
		int high = Integer.MAX_VALUE;
		int low = Integer.MIN_VALUE;
		int userNum = getInt(low, prompt, high);
		return userNum;
	}
	public static double getDouble(double low, String prompt, double high) 
	{
		double userNum=0;
		boolean inputOK = false;
		String dummy;
		do
		{
			System.out.print(prompt);
			try {
				userNum = input.nextDouble();
				inputOK = true;
			}
			catch(InputMismatchException e){
				dummy = input.nextLine();
				System.out.println("\" + dummy + \" is not a double!");
			}
			if(userNum < low || userNum > high) {
				System.out.println("The number is outside the legal limits.");
			}
		} while(!inputOK || userNum < low || userNum > high);
		System.out.println("Obtained: " + userNum);
		return userNum;
	}
	
	public static double getDouble(double low, String prompt)
	{
		double high = Double.MAX_VALUE;
		double userNum = getDouble(low, prompt, high);
		return userNum;
	}
	
	public static double getDouble(String prompt, double high)
	{
		double low = Double.MIN_VALUE;
		double userNum = getDouble(low, prompt, high);
		return userNum;
	}
	
	public static double getDouble(String prompt)
	{
		double high = Double.MAX_VALUE;
		double low = Double.MIN_VALUE;
		double userNum = getDouble(low, prompt, high);
		return userNum;
	}
	
	public static double getDouble()
	{
		String prompt = "Please enter any double: ";
		double high = Double.MAX_VALUE;
		double low = Double.MIN_VALUE;
		double userNum = getDouble(low, prompt, high);
		return userNum;
	}
	
	public static String getString(String prompt)
	{
		System.out.println(prompt);
		String userString = input.nextLine();
		return userString;
	}

}
