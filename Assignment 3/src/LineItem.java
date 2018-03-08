import java.io.Serializable;
public class LineItem implements Comparable<LineItem>, Serializable {
	
	private static final long serialVersionUID = -1541027673876107789L;
	private int numZa; // number of pizzas
	private Pizza za; // pizza object
	
	/**
	 * 2 Parameter constructor for a LineItem object
	 * @param numZa Must be within 1 and 100 inclusive
	 * @param za A pizza object
	 * @throws IllegalPizza In the event of an illegal number of pizzas
	 */
	public LineItem(int numZa, Pizza za) throws IllegalPizza {
		setNumZa(numZa);
		setZa(za);
	} // end LineItem 2 parameter constructor
	
	/**
	 * 1 Parameter constructor for a LineItem object
	 * @param za A pizza object
	 * @throws IllegalPizza In the event of an illegal number of pizzas
	 */
	public LineItem(Pizza za) throws IllegalPizza {
		setNumZa(1);
		setZa(za);
	} // end LineItem 1 parameter constructor
	
	/**
	 * Sets the number of pizzas ordered
	 * @param numZa Number of pizzas ordered
	 * @throws IllegalPizza In the event of an illegal number of pizzas
	 */
	public void setNumZa(int numZa) throws IllegalPizza{
		if (numZa < 101 && numZa > 0)
			this.numZa = numZa;
		else
			throw new IllegalPizza("Number of pizzas is out of bounds");
	}
	
	/**
	 * Points the Pizza object pointer in the LineItem to the address 
	 * of the Pizza object parameter
	 * @param za Pizza object to be pointed to
	 */
	private void setZa(Pizza za) {
		this.za = za;
	}
	
	/**
	 * Gets the number of pizzas in the line item
	 * @return Number of pizzas
	 */
	public int getNumZa() {
		return this.numZa;
	}
	
	/**
	 * Returns a copy of the Pizza object in the line item
	 * @return Copy of Pizza object
	 */
	public Pizza getZa() {
		return this.za.clone();
	}
	
	/**
	 * Gets the total cost of the order.
	 * @param li LineItem object supplied
	 * @return Total cost in dollars
	 */
	public double getTotalCost(LineItem li) {
		if (this.numZa < 10)
		    return this.numZa*this.za.getCost();
		else if (this.numZa < 21)
			return 0.9*this.numZa*this.za.getCost();
		else
			return 0.8*this.numZa*this.za.getCost();
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		String s = "" + this.numZa + this.za.toString();
		if (this.numZa < 10)
			s = " " + s;
		return s;
	}
	
	@Override
	public int compareTo(LineItem otherLI) {
		return (int)(za.getCost() - otherLI.za.getCost());
	}
}
