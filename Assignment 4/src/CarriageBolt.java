/*
 * A program designed by Max Berkowitz as an example of hierarchy program design
 * Student Number 20019830
 * Max Berkowitz, 2018
 */
import java.io.Serializable;

public class CarriageBolt extends Bolt implements Serializable{
	private static final long serialVersionUID = 1181646945813279233L;

	public CarriageBolt(double length, String diameterThreadSize, String material, String finish, double unitPrice, int numberPerUnit) throws IllegalFastener {
		super(length, diameterThreadSize, material, finish, unitPrice, numberPerUnit);
	} // end CarriageBolt constructor
	
	@Override
	public String toString() {
		return "Carriage Bolt - " + super.toString();
	} // toString method
}
