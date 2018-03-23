/*
 * A program designed by Max Berkowitz as an example of hierarchy program design
 * Student Number 20019830
 * Max Berkowitz, 2018
 */
import java.io.Serializable;

public abstract class InnerThreaded extends Fastener implements Serializable{

	private static final long serialVersionUID = -5324171313207802043L;
	private String diameterThreadSize;
	
	public InnerThreaded(String diameterThreadSize, String material, String finish, double unitPrice, int numberPerUnit) throws IllegalFastener{
		super(material, finish, unitPrice, numberPerUnit);
		if(diameterThreadSize == null)
			throw new IllegalFastener("Parameters cannot be null");
		if(finish.equalsIgnoreCase("Bright") || finish.equalsIgnoreCase("Hot Dipped Galvanized") || finish.equalsIgnoreCase("Black Phosphate") || finish.equalsIgnoreCase("ACQ 1000 Hour") || finish.equalsIgnoreCase("Lubricated"))
			throw new IllegalFastener("Illegal Finish");
		setDiameterThreadSize(diameterThreadSize);
	}
	
	private void setDiameterThreadSize(String diameterThreadSize) throws IllegalFastener{
		String [] sizes = {"#8-13", "#8-15", "#8-32", "#10-13", "#10-24", "#10-32", "1/4-20", "5/16-18", "3/8-16", "7/16-14", "1/2-13", "5/8-11", "3/4-10"}; 
		if (isIn(diameterThreadSize, sizes))
			this.diameterThreadSize = diameterThreadSize;
		else
			throw new IllegalFastener("Illegal size");
	} // end setDiameterThreadSize mutator
	
	@Override
	public String toString() {
		return super.toString() + ", Thread Size: " + diameterThreadSize;
	} // toString method
}
