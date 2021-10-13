package example_10_13_custom_exception.exception;

public class UserAlreadyExistsException extends HtaException {
	
	public UserAlreadyExistsException() {}
	
	public UserAlreadyExistsException(String message) {
		super(message);
	}
	public UserAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

}
