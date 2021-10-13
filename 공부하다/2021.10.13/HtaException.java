package example_10_13_custom_exception.exception;

public class HtaException extends RuntimeException{ //앞으로 만드는 exception은 자세하지만, HtaException에서 상속받음

	public HtaException() {}
	public HtaException(String message) {
		super(message);
	}
	public HtaException(String message, Throwable cause) {
		super(message, cause);
	}
}
