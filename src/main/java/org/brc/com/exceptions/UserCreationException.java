package org.brc.com.exceptions;

/**
 * @author Sandeep Rana
 *
 */
public class UserCreationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserCreationException() {
		super();
	}

	public UserCreationException(String message) {
		super(message);
	}

	public UserCreationException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserCreationException(Throwable cause) {
		super(cause);
	}

	public UserCreationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
