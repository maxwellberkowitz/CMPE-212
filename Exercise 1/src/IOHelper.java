import java.util.Scanner;
import java.util.InputMismatchException;

public class IOHelper {
	
	public static void getInt(int low, String prompt, int high) 
	{
		int userNum=0;
		int result;
		Scanner input = new Scanner(System.in);
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
				System.out.println("\" + dummy + \" is not an integer!");
			}
			if(userNum < low || userNum > high) {
				System.out.println("The number is outside the legal limits.");
			}
		} while(!inputOK || userNum < low || userNum > high);
		
	}

}
