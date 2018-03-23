/*
 * A program designed by Max Berkowitz as an example of hierarchy program design
 * Student Number 20019830
 * Max Berkowitz, 2018
 */
import java.io.Serializable;

public abstract class Screw extends Fastener implements Serializable{
	private static final long serialVersionUID = -2626148834126185519L;
	private String diameterThreadSize;
	private double length;
	private String head;
	private String drive;
	private String material;
	
	public Screw(double length, String diameterThreadSize, String material, String finish, String head, String drive, double unitPrice, int numberPerUnit) throws IllegalFastener{
		super(material, finish, unitPrice, numberPerUnit);
		if(diameterThreadSize == null || head == null || drive == null || finish.equalsIgnoreCase("Bright") || finish.equalsIgnoreCase("Hot Dipped Galvanized"))
			throw new IllegalFastener("Parameters cannot be null");
		setDiameterThreadSize(diameterThreadSize);
		setLength(length);
		setHead(head);
		setDrive(drive);
	}
	
	private void setDiameterThreadSize(String diameterThreadSize) throws IllegalFastener{
		String [] sizes = {"#8-13", "#8-15", "#8-32", "#10-13", "#10-24", "#10-32", "1/4-20", "5/16-18", "3/8-16", "7/16-14", "1/2-13", "5/8-11", "3/4-10"}; 
		if (isIn(diameterThreadSize, sizes))
			this.diameterThreadSize = diameterThreadSize;
		else
			throw new IllegalFastener("Illegal size");
	} // end setDiameterThreadSize mutator
	
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
	
	private void setHead(String head) throws IllegalFastener{
		if(head.equalsIgnoreCase("Bugle") || head.equalsIgnoreCase("Flat") || head.equalsIgnoreCase("Oval") || head.equalsIgnoreCase("Pan") || head.equalsIgnoreCase("Round"))
			this.head = head;
		else
			throw new IllegalFastener("Illegal head");
	}
	
	private void setDrive(String drive) throws IllegalFastener{
		if(drive.equalsIgnoreCase("6-Lobe") || drive.equalsIgnoreCase("Philips") || drive.equalsIgnoreCase("Slotted") || drive.equalsIgnoreCase("Square"))
			this.drive = drive;
		else
			throw new IllegalFastener("Illegal drive");
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Length: " + String.valueOf(length) + ", Head: " + head + ", Drive: " + drive;
	} // end toString method
}
