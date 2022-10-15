package org.brc.com.authentication.model;

import java.io.Serializable;

/**
 * @author Sandeep Rana
 *
 */
public class UserDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1236478264L;

	private User user;
	
	private UserInformation userInformation;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public UserInformation getUserInformation() {
		return userInformation;
	}

	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}
	
	
	
}
