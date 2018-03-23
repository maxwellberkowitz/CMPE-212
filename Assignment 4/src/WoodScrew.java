/*
 * A program designed by Max Berkowitz as an example of hierarchy program design
 * NetID 15mab25
 * Max Berkowitz, 2018
 */
import java.io.Serializable;

//This class is at the bottom of the hierarchy, and is a specific type of screw
public class WoodScrew extends Screw implements Serializable {
	private static final long serialVersionUID = 5822653680337943157L;
	private String point;
	
	public WoodScrew(double length, String diameterThreadSize, String material, String finish, String head, String drive, String point, double unitPrice, int numberPerUnit) throws IllegalFastener{
		super(length, diameterThreadSize, material, finish, head, drive, unitPrice, numberPerUnit);
		if(point == null)
			throw new IllegalFastener("Parameters cannot be null");
		setPoint(point);
	} // end WoodScrew constructor
	
	private void setPoint(String point) throws IllegalFastener{
		if(point.equalsIgnoreCase("Double Cut") || point.equalsIgnoreCase("Sharp") || point.equalsIgnoreCase("Type 17"))
			this.point = point;
		else
			throw new IllegalFastener("Illegal point");
	} // end setPoint mutator
	
	@Override
	public String toString() {
		return "Wood Screw, " + point + " point, " + super.toString();
	} // toString method
}
