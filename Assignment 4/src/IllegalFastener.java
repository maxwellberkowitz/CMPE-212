/*
 * A program designed by Max Berkowitz as an example of hierarchy program design
 * NetID 15mab25
 * Max Berkowitz, 2018
 */
import java.io.Serializable;

// The exception thrown for all cases of a needed exception in the Fastener hierarchy
public class IllegalFastener extends Exception implements Serializable{

	private static final long serialVersionUID = -5562365087370073412L;

	public IllegalFastener(String message) {
		super(message);
	}

} // end IllegalFastener
