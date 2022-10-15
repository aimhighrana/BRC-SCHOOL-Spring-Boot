package org.brc.com.authentication.service;

import org.brc.com.authentication.model.User;

/**
 * @author Sandeep Rana
 *
 */
public interface UserService {
	
	User save(User user);

	User findByUserId(String userId);

}
