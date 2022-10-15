/**
 * 
 */
package org.brc.com.exceptions;

/**
 * @author Sandeep Rana
 *
 */
public class FileUploadException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1367542356L;

	public FileUploadException() {
		super();
	}

	public FileUploadException(String message) {
		super(message);
	}

	public FileUploadException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileUploadException(Throwable cause) {
		super(cause);
	}

	public FileUploadException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
}
