/*
 * A program designed by Max Berkowitz as an example of hierarchy program design
 * Student Number 20019830
 * Max Berkowitz, 2018
 */
import java.io.Serializable;

public class CommonNail extends Nail implements Serializable{
	private static final long serialVersionUID = 6970153716533663552L;

	public CommonNail(String size, double length, double gauge, String finish, double unitPrice, int numberPerUnit) throws IllegalFastener{
		super(size, length, gauge, finish, unitPrice, numberPerUnit);
		if(!finish.equalsIgnoreCase("Bright") && !finish.equalsIgnoreCase("Hot Dipped Galvanized"))
			throw new IllegalFastener("Illegal finish");
	}
	
	@Override
	public String toString() {
		return "Common nail - " + super.toString();
	} // toString method
}
