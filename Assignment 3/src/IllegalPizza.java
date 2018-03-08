/**
 * An Exception thrown if pizza parameters are not legal
 * <ul>
 * <li> The size can be "small", "medium", or "large" only.
 * <li> The cheese can be  "single", "double" or "triple" only.
 * <li> The mushrooms can be "none", "single", or "double" only.
 * <li> The pepperoni can be "none", "single", or "double" only.
 * <li> Mushrooms must be "none" if pepperoni is "none".
 * </ul>
 * @author Max Berkowitz
 * @version 1.0
 */
public class IllegalPizza extends Exception {
	private static final long serialVersionUID = 4593713417540203652L;

	/**
	 * Passes along the message supplied to the exception.
	 * @param message A more specific message.
	 */
	public IllegalPizza(String message) {
		super(message);
	}

} // end IllegalPizza
