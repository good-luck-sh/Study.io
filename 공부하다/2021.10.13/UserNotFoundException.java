package example_10_13_custom_exception.exception;

public class UserNotFoundException extends HtaException{

	public UserNotFoundException () {}
	public UserNotFoundException (String message) {
		super(message);
	}
	public UserNotFoundException (String message, Throwable cause) {
		super(message, cause);
	}
}
