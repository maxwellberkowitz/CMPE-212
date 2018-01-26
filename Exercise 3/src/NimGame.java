public class NimGame {
	
	public static boolean decision() {
		double random = Math.random();
		if (random > 0.5)
			return true;
		else
			return false;
	}
	
	public static int computerRandom(int numMarbles) {
		int selection =  (int)(((numMarbles/2)+1)*Math.random()); // using numMarbles/2 + 1 b.c. just using numMarbles/2 * random would never yield
		  // numMarbles/2, which should be an option
		if(selection<1)
			selection = 1;
		return selection;
	}
	
	public static int gameInstantiation(boolean computerSmarts, boolean playerTurn) {
		int numMarbles = (int)(100*(Math.random()));
		String firstMove;
		String compPlayStyle;
		if(computerSmarts)
			compPlayStyle = "smartly";
		else
			compPlayStyle = "randomly";
		if(playerTurn) {
			firstMove = "You";
		}
		else {
			firstMove = "The computer";
		}
		System.out.println("Welcome to Nim!\nThe computer will be playing " + compPlayStyle + ".\nYou are starting with " + numMarbles + " marbles.\n" + firstMove + " will play first.");
		return numMarbles;
	}
	public static void interfaceOutput(String prompt, int selection) {
		
	}
	
	public static int yourTurn(int numMarbles) {
		System.out.println("Please pick a number between 1 and " + ((int)(numMarbles/2)) + ":");
		int selection = IOHelper.getInt(1,"",((int)(numMarbles/2)));
		System.out.println("You chose " + selection + " marbles. There are " + (numMarbles-selection) + " marbles left.");
		return numMarbles-selection;
	}
	
	public static int compTurn(boolean computerSmarts, int numMarbles) {
		int selection = 0;
		if (computerSmarts) {
			for(int i = 0; i<=5;i++) {
				if((Math.pow(2,i)<=((int)(numMarbles/2))));
					selection = (int)(Math.pow(2,i)-1);
			}
			if (selection == 0) {
				selection = computerRandom(numMarbles);
			}
		}
		else {
			selection = computerRandom(numMarbles);
		}
		System.out.println("The computer chose " + selection + " marbles. There are " + (numMarbles-selection) + " marbles left.");
		return numMarbles - selection;
	}
	
	public static void main(String[] args) {
		boolean computerSmarts = decision();
		boolean playerTurn = decision();
		int numMarbles = gameInstantiation(computerSmarts, playerTurn);
		while(numMarbles > 1) {
			if(playerTurn)
				numMarbles = yourTurn(numMarbles);
			else
				numMarbles = compTurn(computerSmarts,numMarbles);
			playerTurn = !playerTurn;
		}
		if(playerTurn)
			System.out.println("The computer wins!");
		else
			System.out.println("You win!");
	}

}
