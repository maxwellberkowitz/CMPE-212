/*
 * A program designed by Max Berkowitz as an example of hierarchy program design
 * Student Number 20019830
 * Max Berkowitz, 2018
 */
import java.io.Serializable;

//This class is at the bottom of the hierarchy, and is a specific type of nut
public class WingNut extends Nut implements Serializable{
	private static final long serialVersionUID = -9122403307618676481L;

	public WingNut(String diameterThreadSize, String material, String finish, double unitPrice, int numberPerUnit) throws IllegalFastener{
		super(diameterThreadSize, material, finish, unitPrice, numberPerUnit);
	} // end WingNut constructor
	
	@Override
	public String toString() {
		return "Wing nut " + super.toString();
	} // toString method
}