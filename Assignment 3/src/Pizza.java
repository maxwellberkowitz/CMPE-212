import java.io.Serializable;
import java.text.DecimalFormat;

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
		if (size.equals("small") || cheese.equals("medium") || cheese.equals("large"))
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
		if (cheese.equals("single") || cheese.equals("double") || cheese.equals("triple"))
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
		if(pepperoni.equals("none") && !mushrooms.equals("none")) // If pizza has mushrooms but no pepperoni
			throw new IllegalPizza("Illegal mushroom pepperoni combo");
		if ((mushrooms.equals("none") ||
			mushrooms.equals("single") ||
			mushrooms.equals("double")) &&
			(pepperoni.equals("none") ||
			pepperoni.equals("single") ||
			pepperoni.equals("double"))) { // If pizza mushrooms and pepperoni are valid quanitities
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
		if(size.equals("small"))
			cost = 7.00;
		else if (size.equals("medium"))
			cost = 9.00;
		else if (size.equals("large"))
			cost = 11.00;
		else
			throw new IllegalPizza("Illegal size");
		// Add additional topping costs as applicable
		if(cheese.equals("double"))
			cost += 1.50;
		else if(cheese.equals("triple"))
			cost += 3.00;
		if(mushrooms.equals("single"))
			cost += 1.50;
		else if(mushrooms.equals("double"))
			cost += 3.00;
		if(pepperoni.equals("single"))
			cost += 1.50;
		else if(pepperoni.equals("double"))
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
		if (mushrooms.equals("none"))
			mushString = "no";
		if (pepperoni.equals("none"))
			pepString = "no";
		String s = size + " pizza, " + cheese + " cheese, " + mushString + " mushrooms, " + pepString + " pepperoni. Cost: $" + decimalFormat.format(cost) + " each.";
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
			if (this.size.equals(otherP.size) && 
				this.cheese.equals(otherP.cheese) &&
				this.mushrooms.equals(otherP.mushrooms) &&
				this.pepperoni.equals(otherP.pepperoni));
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