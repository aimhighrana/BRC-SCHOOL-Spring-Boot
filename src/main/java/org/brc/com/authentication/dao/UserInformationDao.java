package org.brc.com.authentication.dao;

import org.brc.com.authentication.model.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sandeep Rana
 *
 */
public interface UserInformationDao {
	
	UserInformation findByUserName(String userName);

	UserInformation saveUpdate(UserInformation userInformation);
	
	
}
