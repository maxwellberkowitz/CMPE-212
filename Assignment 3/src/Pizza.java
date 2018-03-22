import java.io.Serializable;
import java.text.DecimalFormat;
/**
 * Pizza is an object that defines a small, medium, or large pizza with cheese and optional pepperoni and mushrooms.
 * Pizza objects are instantiated within LineItem objects to be used in the PizzaOrderSystem class.
 * @author Max Berkowitz
 */
public class Pizza implements Serializable{

	private static final long serialVersionUID = -6789654590912980891L;
	private String size;
	private String cheese;
	private String mushrooms;
	private String pepperoni;
	private double cost; 
	
	/**
	 * Full parameter constructor
	 * @param size The pizza size
	 * @param cheese The quantity of cheese
	 * @param mushrooms The quantity of mushrooms
	 * @param pepperoni The quantity of pepperoni
	 */
	// 4 parameter constructor that invokes mutators
	public Pizza(String size, String cheese, String mushrooms, String pepperoni) throws IllegalPizza {
		if(size == null || cheese == null || mushrooms == null || pepperoni == null)
			throw new IllegalPizza("Parameters cannot be null");
		setSize(size);
		setCheese(cheese);
		setToppings(mushrooms, pepperoni);
		setCost(size, cheese, mushrooms, pepperoni);
	} // end Pizza parameter constructor
	
	/**
	 * Zero parameter constructor. Assumes small pizza with single cheese, no mushrooms, and single pepperoni.
	 * @throws IllegalPizza
	 */
	// Zero parameter constructor
	public Pizza() throws IllegalPizza{
		this("small", "single", "none", "single");
	}
	
	/**
	 * Sets the pizza size
	 * @param size The pizza size
	 * @throws IllegalPizza if size is not small, medium, or large
	 */
	private void setSize(String size) throws IllegalPizza{
		if (size.equalsIgnoreCase("small") || size.equalsIgnoreCase("medium") || size.equalsIgnoreCase("large"))
			this.size = size;
		else
			throw new IllegalPizza("Illegal size");
	} // end setSize mutator
	
	/**
	 * Sets quantity of cheese
	 * @param cheese Quantity of cheese
	 * @throws IllegalPizza if cheese is not single, double, or triple
	 */
	private void setCheese(String cheese) throws IllegalPizza{
		if (cheese.equalsIgnoreCase("single") || cheese.equalsIgnoreCase("double") || cheese.equalsIgnoreCase("triple"))
			this.cheese = cheese;
		else
			throw new IllegalPizza("Illegal cheese");
	} // end setCheese mutator
	
	/**
	 * Sets quantity of mushrooms and pepperoni
	 * @param mushrooms
	 * @param pepperoni
	 * @throws IllegalPizza
	 */
	private void setToppings(String mushrooms, String pepperoni) throws IllegalPizza{
		if(pepperoni.equalsIgnoreCase("none") && !mushrooms.equalsIgnoreCase("none")) // If pizza has mushrooms but no pepperoni
			throw new IllegalPizza("Illegal mushroom pepperoni combo");
		if ((mushrooms.equalsIgnoreCase("none") ||
			mushrooms.equalsIgnoreCase("single") ||
			mushrooms.equalsIgnoreCase("double")) &&
			(pepperoni.equalsIgnoreCase("none") ||
			pepperoni.equalsIgnoreCase("single") ||
			pepperoni.equalsIgnoreCase("double"))) { // If pizza mushrooms and pepperoni are valid quanitities
			this.mushrooms = mushrooms;
			this.pepperoni = pepperoni;
		}
		else
			throw new IllegalPizza("Illegal mushroom pepperoni combo");
	} // end setToppings mutator
	
/**
 * Sets cost of pizza based on size and toppings
 * @param size Pizza size
 * @param cheese Quantity of cheese
 * @param mushrooms Quantity of mushrooms
 * @param pepperoni Quantity of pepperoni
 * @throws IllegalPizza
 */
	private void setCost(String size, String cheese, String mushrooms, String pepperoni) throws IllegalPizza{
		// Assign base cost based on size
		if(size.equalsIgnoreCase("small"))
			cost = 7.00;
		else if (size.equalsIgnoreCase("medium"))
			cost = 9.00;
		else if (size.equalsIgnoreCase("large"))
			cost = 11.00;
		else
			throw new IllegalPizza("Illegal size");
		// Add additional topping costs as applicable
		if(cheese.equalsIgnoreCase("double"))
			cost += 1.50;
		else if(cheese.equalsIgnoreCase("triple"))
			cost += 3.00;
		if(mushrooms.equalsIgnoreCase("single"))
			cost += 1.50;
		else if(mushrooms.equalsIgnoreCase("double"))
			cost += 3.00;
		if(pepperoni.equalsIgnoreCase("single"))
			cost += 1.50;
		else if(pepperoni.equalsIgnoreCase("double"))
			cost += 3.00;
	} // end setCost mutator 
	
	/**
	 * Accessor for cost of pizza
	 * @param pizza The pizza object
	 * @return The cost of the pizza object
	 */
	public double getCost() {
		return cost;
	} // end getCost accessor
	
	/**
     * A String representation of the current object.
     * @return A String representation of the contents of the object containing the values of
     * all the attributes.
	 */
	@Override
	public String toString() {
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		String mushString = mushrooms;
		String pepString = pepperoni;
		if (mushrooms.equalsIgnoreCase("none"))
			mushString = "no";
		if (pepperoni.equalsIgnoreCase("none"))
			pepString = "no";
		String s = size.toLowerCase() + " pizza, " + cheese.toLowerCase() + " cheese, " + mushString.toLowerCase() + " mushrooms, " + pepString.toLowerCase() + " pepperoni. Cost: $" + decimalFormat.format(cost) + " each.";
		return s;
	} // end toString
	
	/**
	 * Equals method where the basis for equality is all attributes being identical
	 * @param otherObject The other Pizza object 
	 */
	@Override
	public boolean equals(Object otherObject) {
		if (otherObject instanceof Pizza) {
			Pizza otherP = (Pizza)otherObject;
			if (size.equalsIgnoreCase(otherP.size) && 
				cheese.equalsIgnoreCase(otherP.cheese) &&
				mushrooms.equalsIgnoreCase(otherP.mushrooms) &&
				pepperoni.equalsIgnoreCase(otherP.pepperoni))
			return true;
		}
		return false;
	} // end equals
	
    /**
     * Returns a copy of the of the current Pizza object.
     * @return A copy of the current object.
     */
    // Overrides the clone method in the Object class.
    @Override
    public Pizza clone() {
        Pizza pizzaCopy = null;
        try {
           pizzaCopy = new Pizza(this.size, this.cheese, this.mushrooms, this.pepperoni);
        } catch (IllegalPizza e) {
            // Should never get here. The mutators are designed to throw IllegalPizza
        	// and will do so when the constructor is called in the try block
            return null;
        } // end try/catch
        return pizzaCopy;
    } // end clone
}