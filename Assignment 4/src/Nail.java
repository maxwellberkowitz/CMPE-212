import java.io.Serializable;

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
	}
	
	private void setSize(String size) throws IllegalFastener{
		String [] sizes = {"6D", "8D", "10D", "12D", "16D", "60D"};
		boolean validSize = false;
		for(String s : sizes) {
			if(size.equals(s))
				validSize = true;
		}
		if(validSize)
			this.size = size;
		else
			throw new IllegalFastener("Illegal size");
	}
	
	private void setLength(double length) throws IllegalFastener{
		double [] lengths = {2, 2.5, 3, 3.25, 3.5, 6};
		boolean validLength = false;
		for(double l : lengths) {
			if(l == length)
				validLength = true;
		}
		if(validLength)
			this.length = length;
		else
			throw new IllegalFastener("Illegal length");
	}
	
	private void setGauge(double gauge) throws IllegalFastener{
		double [] gauges = {2, 8, 9, 10.25, 11.5};
		boolean validGauge = false;
		for(double g : gauges) {
			if(g == gauge)
				validGauge = true;	
		}
		if(validGauge)
			this.gauge = gauge;
		else
			throw new IllegalFastener("Illegal gauge");
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Size:" + size + ", Length: " + String.valueOf(length)+", " + "Gauge: " + String.valueOf(gauge);
	}	// end toString method
}
