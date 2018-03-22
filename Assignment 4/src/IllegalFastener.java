public class IllegalFastener extends Exception {

	private static final long serialVersionUID = 3292889047196973345L;

	/**
	 * Passes along the message supplied to the exception.
	 * @param message A specific message.
	 */
	public IllegalFastener(String message) {
		super(message);
	}

} // end IllegalFastener
