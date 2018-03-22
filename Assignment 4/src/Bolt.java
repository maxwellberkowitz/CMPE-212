public abstract class Bolt extends Fastener {
	private String diameterThreadSize;
	private double length;
	private String material;
	private String finish;
	private double unitPrice;
	private int numberPerUnit;
	
	public Bolt(String diameterThreadSize, double length, String material, String finish, double unitPrice, int numberPerUnit, String m, String g, String s, String t) {
		super(m,g,s,t);
		setDiameterThreadSize(diameterThreadSize);
	}
	
	private void setDiameterThreadSize(String diameterThreadSize) throws IllegalFastener{
		String [] sizes = {"#8-13", "#8-15", }; 
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
		
	}
}
