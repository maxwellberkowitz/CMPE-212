import java.io.Serializable;
/**
 * LineItem is an object containing Pizza objects and is used in the PizzaOrderSystem class
 * @author Max Berkowitz
 *
 */
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
		if(za == null)
			throw new IllegalPizza("Pizza cannot be null");
		setNumber(numZa);
		setPizza(za);
	} // end LineItem 2 parameter constructor
	
	/**
	 * 1 Parameter constructor for a LineItem object
	 * @param za A pizza object
	 * @throws IllegalPizza In the event of an illegal number of pizzas
	 */
	public LineItem(Pizza za) throws IllegalPizza {
		if(za == null)
			throw new IllegalPizza("Pizza cannot be null");
		setNumber(1);
		setPizza(za);
	} // end LineItem 1 parameter constructor
	
	/**
	 * Sets the number of pizzas ordered
	 * @param numZa Number of pizzas ordered
	 * @throws IllegalPizza In the event of an illegal number of pizzas
	 */
	public void setNumber(int numZa) throws IllegalPizza{
		if (numZa < 101 && numZa > 0)
			this.numZa = numZa;
		else
			throw new IllegalPizza("Number of pizzas is out of bounds");
	} // end setNumber mutator
	
	/**
	 * Points the Pizza object pointer in the LineItem to the address 
	 * of the Pizza object parameter
	 * @param za Pizza object to be pointed to
	 */
	private void setPizza(Pizza za) {
		this.za = za;
	} // end setPizza mutator
	
	/**
	 * Gets the number of pizzas in the line item
	 * @return Number of pizzas
	 */
	public int getNumber() {
		return this.numZa;
	} // end getNumer method
	
	/**
	 * Returns a copy of the Pizza object in the line item
	 * @return Copy of Pizza object
	 */
	public Pizza getPizza() {
		return this.za.clone();
	} // end getPizza method
	
	/**
	 * Gets the total cost of the order.
	 * @param li LineItem object supplied
	 * @return Total cost in dollars
	 */
	public double getCost() {
		if (numZa < 10)
		    return numZa*za.getCost();
		else if (numZa < 21)
			return 0.9*numZa*za.getCost();
		else
			return 0.85*numZa*za.getCost();
	} // end getCost method
	
	/**
	 * Displays LineItem object as a String
	 */
	@Override
	public String toString() {
		String s = "" + this.numZa + " " + this.za.toString();
		if (this.numZa < 10)
			s = " " + s;
		return s;
	} // end toString method
	
	/**
	 * Compares LineItem objects on the basis of cost
	 */
	@Override
	public int compareTo(LineItem otherLI) {
		return (int)(otherLI.getCost() - getCost());
	} // end compareTo method
}
