package com.app.reearth.reearth.Exception;

import com.app.reearth.reearth.Repostiory.UserRepo;

public final class UserNotFoundException  extends RuntimeException{


	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public UserNotFoundException(String message) {
	        super("User not found");
	    }
	}
