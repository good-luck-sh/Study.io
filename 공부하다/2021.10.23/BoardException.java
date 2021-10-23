package example_10_23_board.exception;

public class BoardException extends RuntimeException {
	
	private static final long serialVersionUID = 7078461549208308703L;

	public BoardException(String message) {
		super(message);
	}
}
