package example_10_13_custom_exception.exception;

public class PasswordMismatchException extends HtaException {

	public PasswordMismatchException () {}
	
	public PasswordMismatchException (String message) {
		super(message);
	}
	public PasswordMismatchException (String message, Throwable cause) {
		super(message, cause);
	}
	
}
