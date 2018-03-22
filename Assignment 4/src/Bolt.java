public abstract class Bolt extends Fastener {
	private String diameterThreadSize;
	private double length;
	private String material;
	private String finish;
	private double unitPrice;
	private int numberPerUnit;
	
	public Bolt(String diameterThreadSize, double length, String material, String finish, double unitPrice, int numberPerUnit, String m, String g, String s, String t) throws IllegalFastener {
		super(m,g,s,t);
		setDiameterThreadSize(diameterThreadSize);
		setLength(length);
		setMaterial(material);
		setFinish(finish);
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
	
	private void setMaterial(String material) throws IllegalFastener{
		if(material.equalsIgnoreCase("Steel") || material.equalsIgnoreCase("Stainless Steel") || material.equalsIgnoreCase("Brass"))
			this.material = material;
		else
			throw new IllegalFastener("Illegal Material");
	}
	
	private void setFinish(String finish) throws IllegalFastener{
		if(this.material.equalsIgnoreCase("Steel") && 
		  (finish.equalsIgnoreCase("Chrome") || 
		   finish.equalsIgnoreCase("Hot Dipped Galvanized") || 
		   finish.equalsIgnoreCase("Plain") || 
		   finish.equalsIgnoreCase("Yellow Zinc") || 
		   finish.equalsIgnoreCase("Zinc")))
			this.finish = finish;
		else if((this.material.equalsIgnoreCase("Stainless Steel") || this.material.equalsIgnoreCase("Brass")) && (material.equalsIgnoreCase("Plain")))
			this.finish = finish;
		else
			throw new IllegalFastener("Illegal finish");
	}
}
