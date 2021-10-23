package example_10_21_store.exception;

public class StoreException extends RuntimeException {

	private static final long serialVersionUID = 8144943641636369682L;

	public StoreException(String message) {
		super(message);
	}
}
