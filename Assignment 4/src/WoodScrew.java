
public class WoodScrew extends Screw{
	private String point;
	
	public WoodScrew(double length, String diameterThreadSize, String material, String finish, String head, String drive, String point, double unitPrice, int numberPerUnit) throws IllegalFastener{
		super(length, diameterThreadSize, material, finish, head, drive, unitPrice, numberPerUnit);
		setPoint(point);
	}
	
	private void setPoint(String point) throws IllegalFastener{
		if(point.equalsIgnoreCase("") || point.equalsIgnoreCase("Philips") || point.equalsIgnoreCase("Slotted") || point.equalsIgnoreCase("Square"))
			this.point = point;
		else
			throw new IllegalFastener("Illegal head");
	}
}
