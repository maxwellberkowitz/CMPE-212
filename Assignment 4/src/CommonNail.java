/*
 * A program designed by Max Berkowitz as an example of hierarchy program design
 * NetID 15mab25
 * Max Berkowitz, 2018
 */
import java.io.Serializable;

//This class is at the bottom of the hierarchy, and is a specific type of nail
public class CommonNail extends Nail implements Serializable{
	private static final long serialVersionUID = 6970153716533663552L;

	public CommonNail(String size, double length, double gauge, String finish, double unitPrice, int numberPerUnit) throws IllegalFastener{
		super(size, length, gauge, finish, unitPrice, numberPerUnit);
		if(!finish.equalsIgnoreCase("Bright") && !finish.equalsIgnoreCase("Hot Dipped Galvanized"))
			throw new IllegalFastener("Illegal finish");
	} // end CommonNail constructor
	
	@Override
	public String toString() {
		return "Common nail, " + super.toString();
	} // end toString method
}
