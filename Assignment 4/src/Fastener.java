import java.io.Serializable;

public abstract class Fastener implements Serializable {

	private static final long serialVersionUID = -7147782195922882002L;
	private String material;
	private String finish;
	private double unitPrice;
	private int numberPerUnit;
	
	public Fastener(String material, String finish, double unitPrice, int numberPerUnit) throws IllegalFastener{
		if(material == null || finish == null)
			throw new IllegalFastener("Parameters cannot be null");
		setMaterial(material);
		setFinish(finish);
		System.out.println(numberPerUnit);
		setUnitPrice(unitPrice);
		setNumberPerUnit(numberPerUnit);
	}
	
	private void setMaterial(String material) throws IllegalFastener{
		if(material.equalsIgnoreCase("Steel") || material.equalsIgnoreCase("Stainless Steel") || material.equalsIgnoreCase("Brass"))
			this.material = material;
		else
			throw new IllegalFastener("Illegal Material");
	}
	
	private void setFinish(String finish) throws IllegalFastener{
		if(validateFinish(finish))
			this.finish = finish;
		else
			throw new IllegalFastener("Illegal finish");
	}
	
	private void setUnitPrice(double unitPrice) throws IllegalFastener{
		if(unitPrice >= 0)
			this.unitPrice = unitPrice;
		else
			throw new IllegalFastener("Unit price must be non-negative");
	}
	
	private void setNumberPerUnit(int numberPerUnit) throws IllegalFastener{
		if((numberPerUnit == 1 || numberPerUnit % 5 == 0) && numberPerUnit >=1 && numberPerUnit <= 10000)
			this.numberPerUnit = numberPerUnit;
		else
			throw new IllegalFastener("Number per unit must be 1 or evenly divisible");
	}
	
	@Override
	public String toString() {
		return("Material: " + material + ", Finish: " + finish + ", Unit Price: " + String.valueOf(unitPrice) + ", Number per Unit: " + numberPerUnit);
	}
	
	public boolean isIn(String s, String[] arr) {
		for (String str : arr) {
			if (str.equals(s))
				return true;
		}
		return false;
	} // isIn method

	public boolean isIn(double value, double[] arr) {
		for (double d : arr) {
			if (d == value)
				return true;
		}
		return false;
	} // isIn method
	
	public boolean validateFinish(String finish){
		boolean validFinish = false;
		if(this.material.equalsIgnoreCase("Steel") && 
				  (finish.equalsIgnoreCase("Chrome") || 
				   finish.equalsIgnoreCase("Hot Dipped Galvanized") || 
				   finish.equalsIgnoreCase("Plain") || 
				   finish.equalsIgnoreCase("Yellow Zinc") || 
				   finish.equalsIgnoreCase("Zinc") ||
				   finish.equalsIgnoreCase("Black Phosphate") ||
				   finish.equalsIgnoreCase("ACQ 1000 Hour") ||
				   finish.equalsIgnoreCase("Lubricated") ||
				   finish.equalsIgnoreCase("Bright") ||
				   finish.equalsIgnoreCase("Hot Dipped Galvanized")))
						validFinish = true;
				else if((this.material.equalsIgnoreCase("Stainless Steel") || this.material.equalsIgnoreCase("Brass")) && (finish.equalsIgnoreCase("Plain")))
						validFinish = true;
				return validFinish;
	}
	
	// Method returns order cost as a String
	public String getOrderCost(int order) {
		return String.valueOf(order * numberPerUnit * unitPrice);
	} // getOrderCost method
}
