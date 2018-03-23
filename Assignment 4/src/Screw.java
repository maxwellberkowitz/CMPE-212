/*
 * A program designed by Max Berkowitz as an example of hierarchy program design
 * NetID 15mab25
 * Max Berkowitz, 2018
 */
import java.io.Serializable;

//This class is a superclass for all screw-type fasteners
public abstract class Screw extends OuterThreaded implements Serializable{
	private static final long serialVersionUID = -2626148834126185519L;
	private double length;
	private String head;
	private String drive;
	
	public Screw(double length, String diameterThreadSize, String material, String finish, String head, String drive, double unitPrice, int numberPerUnit) throws IllegalFastener{
		super(diameterThreadSize, material, finish, unitPrice, numberPerUnit);
		if(diameterThreadSize == null || head == null || drive == null || finish.equalsIgnoreCase("Bright") || finish.equalsIgnoreCase("Hot Dipped Galvanized"))
			throw new IllegalFastener("Parameters cannot be null");
		setLength(length);
		setHead(head);
		setDrive(drive);
	} // end Screw constructor
	
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
	} // end setLength mutator
	
	private void setHead(String head) throws IllegalFastener{
		if(head.equalsIgnoreCase("Bugle") || head.equalsIgnoreCase("Flat") || head.equalsIgnoreCase("Oval") || head.equalsIgnoreCase("Pan") || head.equalsIgnoreCase("Round"))
			this.head = head;
		else
			throw new IllegalFastener("Illegal head");
	} // end setHead mutator
	
	private void setDrive(String drive) throws IllegalFastener{
		if(drive.equalsIgnoreCase("6-Lobe") || drive.equalsIgnoreCase("Philips") || drive.equalsIgnoreCase("Slotted") || drive.equalsIgnoreCase("Square"))
			this.drive = drive;
		else
			throw new IllegalFastener("Illegal drive");
	} // end setDrive mutator
	
	@Override
	public String toString() {
		return head + " head, " + drive + " drive, " + length + "\" long, " + super.toString();
	} // end toString method
}
