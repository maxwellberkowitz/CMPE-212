/*
 * A program designed by Max Berkowitz as an example of hierarchy program design
 * Student Number 20019830
 * Max Berkowitz, 2018
 */
import java.io.Serializable;

public class WoodScrew extends Screw implements Serializable{
	private static final long serialVersionUID = 5822653680337943157L;
	private String point;
	
	public WoodScrew(double length, String diameterThreadSize, String material, String finish, String head, String drive, String point, double unitPrice, int numberPerUnit) throws IllegalFastener{
		super(length, diameterThreadSize, material, finish, head, drive, unitPrice, numberPerUnit);
		if(point == null)
			throw new IllegalFastener("Parameters cannot be null");
		setPoint(point);
	}
	
	private void setPoint(String point) throws IllegalFastener{
		if(point.equalsIgnoreCase("Double Cut") || point.equalsIgnoreCase("Sharp") || point.equalsIgnoreCase("Type 17"))
			this.point = point;
		else
			throw new IllegalFastener("Illegal point");
	}
	
	@Override
	public String toString() {
		return "Wood Screw - " + super.toString() + ", Point: " + point;
	} // toString method
}
