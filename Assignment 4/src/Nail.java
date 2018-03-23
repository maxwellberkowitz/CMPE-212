/*
 * A program designed by Max Berkowitz as an example of hierarchy program design
 * NetID 15mab25
 * Max Berkowitz, 2018
 */
import java.io.Serializable;

//This class is a superclass for all nail-type fasteners
public abstract class Nail extends Fastener implements Serializable{
	private static final long serialVersionUID = -1820539242139531294L;
	private static String material = "Steel";
	private String size;
	private double length;
	private double gauge;
	
	public Nail(String size, double length, double gauge, String finish, double unitPrice, int numberPerUnit) throws IllegalFastener{
		super(material, finish, unitPrice, numberPerUnit);
		if(size == null)
			throw new IllegalFastener("Parameters cannot be null");
		if(finish.equalsIgnoreCase("Black Phosphate") || finish.equalsIgnoreCase("ACQ 1000 Hour") || finish.equalsIgnoreCase("Lubricated"))
			throw new IllegalFastener("Illegal finish");
		setSize(size);
		setLength(length);
		setGauge(gauge);
	} // end Nail constructor
	
	private void setSize(String size) throws IllegalFastener{
		String [] sizes = {"6D", "8D", "10D", "12D", "16D", "60D"};
		if(isIn(size, sizes))
			this.size = size;
		else
			throw new IllegalFastener("Illegal size");
	} // end setSize mutator
	
	private void setLength(double length) throws IllegalFastener{
		double [] lengths = {2, 2.5, 3, 3.25, 3.5, 6};
		if(isIn(length, lengths))
			this.length = length;
		else
			throw new IllegalFastener("Illegal length");
	} // end setLength mutator
	
	private void setGauge(double gauge) throws IllegalFastener{
		double [] gauges = {2, 8, 9, 10.25, 11.5};
		if(isIn(gauge, gauges))
			this.gauge = gauge;
		else
			throw new IllegalFastener("Illegal gauge");
	} // end setGauge mutator
	
	@Override
	public String toString() {
		return size + " size, " + String.valueOf(length) + "\" long, " + gauge + " gauge, " + super.toString();
	}	// end toString method
}
