/*
 * A program designed by Max Berkowitz as an example of hierarchy program design
 * NetID 15mab25
 * Max Berkowitz, 2018
 */
import java.io.Serializable;

public abstract class Bolt extends OuterThreaded implements Serializable {

	private static final long serialVersionUID = 5249907541088760729L;
	private double length;
	
	public Bolt(double length, String diameterThreadSize, String material, String finish, double unitPrice, int numberPerUnit) throws IllegalFastener {
		super(diameterThreadSize, material, finish, unitPrice, numberPerUnit);
		if(diameterThreadSize == null)
			throw new IllegalFastener("Parameters cannot be null");
		if(finish.equalsIgnoreCase("Bright") || finish.equalsIgnoreCase("Black Phosphate") || finish.equalsIgnoreCase("ACQ 1000 Hour") || finish.equalsIgnoreCase("Lubricated"))
			throw new IllegalFastener("Illegal Finish");
		setLength(length);
	}
	
	private void setLength(double length) throws IllegalFastener {
		boolean validLength = false;
		for(double i = 0.5; i <= 6; i+=0.25) {
			if(i == length)
				validLength = true;
		}
		for(double i = 6; i <= 11; i+=0.5) {
			if(i == length)
				validLength = true;
		}
		for(double i = 11; i <= 20; i++) {
			if(i == length)
				validLength = true;
		}
		if(validLength)
			this.length = length;
		else
			throw new IllegalFastener("Illegal length");
	}
	
	@Override
	public String toString() {
		return String.valueOf(length) + "\" long, " + super.toString();
	} // end toString method
}
