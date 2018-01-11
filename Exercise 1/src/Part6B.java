import javax.swing.JOptionPane;

public class Part6B {

	public static void main(String[] args) {
		String userInput;
		userInput = JOptionPane.showInputDialog("Enter a number");
		int userNum = Integer.parseInt(userInput);
		userNum = userNum + 20;
		JOptionPane.showMessageDialog(null, "Your number plus 20 is " + userNum);
	} // end main method
	
} // end Part6 class