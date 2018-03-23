/*
 * A program designed by Max Berkowitz as an example of hierarchy program design
 * NetID 15mab25
 * Max Berkowitz, 2018
 */
import java.io.Serializable;

public class IllegalFastener extends Exception implements Serializable{

	private static final long serialVersionUID = -5562365087370073412L;

	/**
	 * Passes along the message supplied to the exception.
	 * @param message A specific message.
	 */
	public IllegalFastener(String message) {
		super(message);
	}

} // end IllegalFastener
