package ch7;

public class WrongPasswordException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WrongPasswordException() {
		super();
	}

	public WrongPasswordException(String message) {
		super(message);
	}

}
