/*
 * A program to simulate a simple dice game, known as "Pig", between the user and the computer.
 * The program prompts the user for choices regarding whether or not to roll again. The program
 * terminates when the first player (user or computer) reaches a score equal to or greater than
 * 100.
 * 
 * for CMPE212 Assignment 1, by Max Berkowitz
 */

import java.util.Random; // Importing utilities as necessary 
import java.util.Scanner;

public class Assn1_20019830 {

	public static Random random = new Random(System.currentTimeMillis()); // Random utilized in numerous methods
	public static final Scanner input = new Scanner(System.in); // Scanner to be used to acquire user input in numerous methods
	
	// Method generates random integers between 1 and 6 to represent dice rolling
	public static int[] diceRoll(int dice[]) {
			dice[0] = 1 + random.nextInt(6);
			dice[1] = 1 + random.nextInt(6);
			return dice;
	} // end diceRoll method
	
	// Method called from main to begin the game. Will run until game terminates.
	public static void startGame() {
		int[] dice = new int[2]; // 1x2 array to represent the two dice
		int playerSum = 0; // Initial player scores
		int compSum = 0;
		boolean playerTurn = true; // The user goes first
		System.out.println("Welcome to pig! The first player to 100 or more points wins.\n"
				+ "You (player) go first.");
		// Loop runs until end of game, changing player's turns and player's scores on each iteration.
		while(playerSum < 100 && compSum < 100)  
		{
			System.out.println("\nPlayer's sum is: " + playerSum + ", Computer's sum is " + compSum + ".\n");
			// if/else used to decide which player's turn it is
			if(playerTurn == true)
				playerSum += playerTurn(dice, playerSum);
			else
				compSum += compTurn(dice, compSum);
			// alternating which player's turn it is for the next iteration
			playerTurn = !playerTurn;
		}
		endGame(playerSum, compSum);
	} // end startGame method
	
	// Method to decide the winner of the game. Final method run before returning to main and terminating.
	public static void endGame(int playerSum, int compSum) {
		if(playerSum > compSum)
			System.out.println("You win! Your final score is " + playerSum + ". The computer's final score is " + compSum + ".");
		else
			System.out.println("The computer wins! Your final score is " + playerSum + ". The computer's final score is " + compSum + ".");
	} // end endGame method
	
	// Method intended to run until the player rolls a 1, or decides not to roll again.
	// A sum is calculated for the current turn, and returned to startGame() to be added
	// to the player's total score
	public static int playerTurn(int dice[], int playerSum) {
		System.out.println("Press Enter to roll.");
		input.nextLine(); // Waiting for user to press enter
		dice = diceRoll(dice); // Generating new dice values
		int turnSum = sum(dice); // Initial turn sum
		System.out.println("You rolled a " + getWord(dice[0]) + " and a " + getWord(dice[1]) + ". Your total score is " + (turnSum + playerSum) + ".");
		// Loop created to manage the re-roll functionality. Breaks when rules() returns
		// false, either due to rolling a 1 or deciding not to roll again
		while(rules(dice, turnSum, playerSum, "Player")) {
			System.out.println("Press Enter to roll.");
			input.nextLine(); 
			dice = diceRoll(dice); // Generating new dice values
			// If sum() returns zero, this indicates a single 1 has been 
			// rolled, and the turn must end with total sum of zero
			if(sum(dice) == 0)
				turnSum = 0;
			turnSum += sum(dice);
			System.out.println("You rolled a " + getWord(dice[0]) + " and a " + getWord(dice[1]) + ". Your total score is " + (turnSum + playerSum) + ".");
		}
		return turnSum;
	} // end playerTurn method
	
	// Method intended to run until the computer rolls a 1, or decides not to roll again.
	// A sum is calculated for the current turn, and returned to startGame() to be added
	// to the computer's total score.
	public static int compTurn(int dice[], int compSum) {
		dice = diceRoll(dice); // Generating new dice values
		int turnSum = sum(dice);
		System.out.println("The computer rolled a " + getWord(dice[0]) + " and a " + getWord(dice[1]) + ".");
		// Loop created to manage the re-roll functionality. Breaks when rules() returns
		// false, either due to rolling a 1 or deciding not to roll again
		while(rules(dice, turnSum, compSum, "The computer")) {
			dice = diceRoll(dice);  // Generating new dice values
			System.out.println("The computer rolled a " + getWord(dice[0]) + " and a " + getWord(dice[1]) + ".");
			// If sum() returns zero, this indicates a single 1 has been 
			// rolled, and the turn must end with total sum of zero
			if(sum(dice) == 0)
				turnSum = 0;
			else 
				turnSum += sum(dice);
		}
		return turnSum;
	} // end compTurn method
	
	// Method used to account for the various possible die roll combinations, and their
	// implications. Method returns a boolean value indicating whether or not the player
	// will roll again, either by choice or by force.
	public static boolean rules (int dice[], int sum , int totalSum, String player) {
		// Case in which both dice are 1. Player must re-roll.
		if(dice[0] == 1 && dice[1] == 1) {
			System.out.println("Snake eyes! " + player + " must roll again!");
			return true;
		}
		// Case in which dice are equal and not equal to 1. Player must re-roll.
		else if(dice[0] == dice[1]) {
			System.out.println("Doubles! " + player + " must roll again!");
			return true;
		}
		// Case in which only a singular die is equal to 1. Does not catch
		// case of both die being equal to 1, as this is tested earlier in
		// the if-else string.
		else if(dice[0] == 1 || dice[1] == 1) {
			System.out.println("TURN OVER! Turn sum is zero!");
			return false;
		}
		// Case to catch all other possible dice combinations
		else {
			// If the current turn is being played by the user, they are given
			// the choice of deciding whether to play again
			if(player.equals("Player")) {
				String choice = getString("Roll again? (Enter 'y' or 'n'): ");
				if(choice.equals("y")) {
					return true;
				}
				else
					return false;
			}
			else
				return compChoice(sum, totalSum); // Method called if computer has choice regarding re-roll
		}
	} // end rules method
	
	// Method designed to decide whether computer will play again. Boolean is returned
	// to indicate decision.
	public static boolean compChoice(int turnSum, int compSum) {
		// In the case that the computer has not yet reached a score of 100,
		// and it has a turn score of less than 10, it will roll again.
		if(turnSum < 10 && compSum < 100) {
			System.out.println("The computer chose to play again.");
			return true;
		}
		else {
			System.out.println("The computer chose not to play again.");
			return false;
		}
	} // end compChoice method
	
	// Method employed to determine whether the user wishes to re-roll
	public static String getString(String prompt)
	{
		System.out.println(prompt);
		String userString = new String();
		boolean validInput = false;
		// Loop created such that game will pause until the user enters a valid
		// string indicating decision to re-roll
		while(!validInput) {
			userString = input.nextLine();
			if(userString.equals("y") || userString.equals("n"))
				validInput = true;
			else {
				System.out.println("Invalid input! Enter 'y' or 'n':");
			}
		}
		return userString;
	} // end getString method
	
	// Method for calculating the value of a roll, according to game rules.
	public static int sum(int dice[]) {
		int sum;
		// Double 1's
		if(dice[0] == 1 && dice[1] == 1) {
			sum = 25;
		}
		// Dice equal to each other and not equal to 1
		else if(dice[0] == dice[1]) {
			sum = 2*(dice[0] + dice[1]);
		}
		// Singular 1
		else if(dice[0] == 1 || dice[1] == 1) {
			sum = 0;
		}
		// All other rolls
		else {
			sum = dice[0] + dice[1];
		}
		return sum;
	} // end sum method
	
	// Method to translate integers into English word equivalents.
	public static String getWord(int num) {
		String nums [] = {"one", "two", "three", "four", "five", "six"};
		return nums[num-1];
	} // end getWord method
	
	// Main method left empty (aside from calling the beginning of the game).
	// This was done intentionally such that if one wished to further develop
	// this code, they could add content to the main program such as asking the
	// user if they wished to play again, or play a different game.
	public static void main(String[] args) {
		startGame();
	} // end main method
}
