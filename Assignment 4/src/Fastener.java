public abstract class Fastener {
	
	private String material;
	private String finish;
	private double unitPrice;
	private int numberPerUnit;
	
	public Fastener(String material, String finish, double unitPrice, int numberPerUnit) throws IllegalFastener{
		setMaterial(material);
		setFinish(finish);
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
	
	private void setUnitPrice(double unitPrice) throws IllegalFastener{
		if(unitPrice >= 0)
			this.unitPrice = unitPrice;
		else
			throw new IllegalFastener("Unit price must be non-negative");
	}
	
	private void setNumberPerUnit(int numberPerUnit) throws IllegalFastener{
		if(numberPerUnit == 1 || numberPerUnit % 5 == 0)
			this.numberPerUnit = numberPerUnit;
		else
			throw new IllegalFastener("Number per unit must be 1 or evenly divisible");
	}
}
