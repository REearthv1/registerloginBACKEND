package com.app.reearth.reearth.Exception;

public class UserAlreadyExistsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAlreadyExistsException(String message) {
        super("User already exists");

}
}
