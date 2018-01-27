import java.util.Random; // Importing utilities as necessary 
import java.util.Scanner;

public class Assn1_20019830 {

	public static Random random = new Random(System.currentTimeMillis()); // Should this be in the diceRoll method?
																		  // it seems weird to instantiate it every time
																		  // that diceRoll is called...
	static Scanner input = new Scanner(System.in); // Scanner to be used to acquire user input in various methods
	// Method generates random integers between 1 and 6 to represent dice rolling
	public static void diceRoll(int dice[]) {
			dice[0] = 1 + random.nextInt(6);
			dice[1] = 1 + random.nextInt(6);
	} // end diceRoll method
	
	// Method called to begin the game.
	public static void startGame() {
		int[] dice = new int[2];
		int playerSum = 0;
		int compSum = 0;
		boolean playerTurn = true;
		System.out.println("Welcome to pig! The first player to 100 or more points wins.\n"
				+ "You go first.");
		while(playerSum < 100 && compSum < 100)
		{
			System.out.println("Player's sum is: " + playerSum + ", Computer's sum is " + compSum);
			if(playerTurn == true)
				playerSum = playerTurn(dice, playerSum);
				
			else
				compSum = compTurn(dice, compSum);
			playerTurn = !playerTurn;
		}
		endGame(playerSum, compSum);
	} // end startGame method
	
	public static void endGame(int playerSum, int compSum) {
		if(playerSum > compSum)
			System.out.println("You win! Your final score is " + playerSum + ". The computer's final score is " + compSum);
		else
			System.out.println("The computer wins! Your final score is " + playerSum + ". The computer's final score is " + compSum);
	}
	
	public static int playerTurn(int dice[], int playerSum) {
		System.out.println("Press Enter to roll.");
		detectEnter();
		diceRoll(dice);
		System.out.println("You rolled a " + dice[0] + " and a " + dice[1]);
		boolean reroll = rules(dice, playerSum, "You");
		int rollSum = 0;
		rollSum = sum(dice, rollSum);
		if(reroll) {
			int extraRoll = playerTurn(dice, rollSum);
			if(extraRoll == 0)
				rollSum = 0;
			else
				rollSum += extraRoll;
		}
		return playerSum + rollSum;
	} // end playerTurn method
	
	public static int compTurn(int dice[], int compSum) {
		diceRoll(dice);
		System.out.println("The computer rolled a " + dice[0] + " and a " + dice[1]);
		boolean reroll = rules(dice, compSum, "The computer");
		int rollSum = 0;
		rollSum = sum(dice, rollSum);
		if(reroll) {
			int extraRoll = compTurn(dice, rollSum);
			if(extraRoll == 0)
				rollSum = 0;
			else
				rollSum += extraRoll;
		}
		return compSum + rollSum;
	} // end compTurn method
	
	public static void detectEnter() {
		String enterKey = input.nextLine();
		if(enterKey.isEmpty()) {
			return;
		}
	} // end detectEnter method
	
	public static boolean rules (int dice[], int sum ,String player) {
		if(dice[0] == 1 && dice[1] == 1) {
			System.out.println("Snake eyes! " + player + " must roll again!");
			return true;
		}
		else if(dice[0] == dice[1]) {
			System.out.println("Doubles! " + player + " must roll again!");
			return true;
		}
		else if(dice[0] == 1 || dice[1] == 1) {
			System.out.println("TURN OVER! Turn sum is zero!");
			return false;
		}
		else {
			if(player.equals("You")) {
				String choice = getString("Roll again? (Enter 'y' or 'n'): ");
				if(choice.equals("y")) {
					return true;
				}
				else
					return false;
			}
			else
				return compChoice(sum);
		}
	}
	
	public static boolean compChoice(int sum) {
		if(sum < 40) {
			System.out.println("The computer chose to play again.");
			return true;
		}
		else {
			System.out.println("The computer chose not to play again.");
			return false;
		}
	}
	
	public static String getString(String prompt)
	{
		System.out.println(prompt);
		String userString = input.nextLine();
		if(userString.equals("y") || userString.equals("n")) {
			return userString;
		}
		else {
			getString("Invalid input; (Enter 'y' or 'n'): ");
			return userString;
		}
	} // end getString method
	
	public static int sum(int dice[], int sum) {
		if(dice[0] == 1 && dice[1] == 1) {
			sum += 25;
		}
		else if(dice[0] == dice[1]) {
			sum += 2*(dice[0] + dice[1]);
		}
		else if(dice[0] == 1 || dice[1] == 1) {
			sum = 0;
		}
		else {
			sum += dice[0] + dice[1];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		startGame();
	} // end main method

}
