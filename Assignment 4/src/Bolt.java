import java.io.Serializable;

public abstract class Bolt extends Fastener implements Serializable{

	private static final long serialVersionUID = 5249907541088760729L;
	private String diameterThreadSize;
	private double length;
	
	public Bolt(double length, String diameterThreadSize, String material, String finish, double unitPrice, int numberPerUnit) throws IllegalFastener {
		super(material, finish, unitPrice, numberPerUnit);
		if(diameterThreadSize == null)
			throw new IllegalFastener("Parameters cannot be null");
		if(finish.equalsIgnoreCase("Bright") || finish.equalsIgnoreCase("Black Phosphate") || finish.equalsIgnoreCase("ACQ 1000 Hour") || finish.equalsIgnoreCase("Lubricated"))
			throw new IllegalFastener("Illegal Finish");
		setDiameterThreadSize(diameterThreadSize);
		setLength(length);
	}
	
	private void setDiameterThreadSize(String diameterThreadSize) throws IllegalFastener{
		String [] sizes = {"#8-13", "#8-15", "#8-32", "#10-13", "#10-24", "#10-32", "1/4-20", "5/16-18", "3/8-16", "7/16-14", "1/2-13", "5/8-11", "3/4-10"}; 
		boolean validThreadSize = false;
		for(String size : sizes) {
			if(diameterThreadSize.equals(size))
				validThreadSize = true;
		}
		if (validThreadSize)
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
	
	@Override
	public String toString() {
		return super.toString() + ", Length: " + String.valueOf(length) + " , Thread Size: " + diameterThreadSize;
	} // end toString method
}
