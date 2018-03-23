/*
 * A program designed by Max Berkowitz as an example of hierarchy program design
 * NetID 15mab25
 * Max Berkowitz, 2018
 */
import java.io.Serializable;

//This class is a superclass for all inner-threaded-type fasteners
public abstract class InnerThreaded extends Fastener implements Serializable{

	private static final long serialVersionUID = -5324171313207802043L;
	private String diameterThreadSize;
	
	public InnerThreaded(String diameterThreadSize, String material, String finish, double unitPrice, int numberPerUnit) throws IllegalFastener{
		super(material, finish, unitPrice, numberPerUnit);
		if(diameterThreadSize == null)
			throw new IllegalFastener("Parameters cannot be null");
		setDiameterThreadSize(diameterThreadSize);
	} // end InnerThreaded constructor
	
	private void setDiameterThreadSize(String diameterThreadSize) throws IllegalFastener{
		String [] sizes = {"#8-13", "#8-15", "#8-32", "#10-13", "#10-24", "#10-32", "1/4-20", "5/16-18", "3/8-16", "7/16-14", "1/2-13", "5/8-11", "3/4-10"}; 
		if (isIn(diameterThreadSize, sizes))
			this.diameterThreadSize = diameterThreadSize;
		else
			throw new IllegalFastener("Illegal size");
	} // end setDiameterThreadSize mutator
	
	@Override
	public String toString() {
		return diameterThreadSize + " thread, " + super.toString();
	} // toString method
}
