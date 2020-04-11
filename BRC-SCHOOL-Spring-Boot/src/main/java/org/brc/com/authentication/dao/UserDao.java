package org.brc.com.authentication.dao;

import org.brc.com.authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author Sandeep Rana
 *
 */
@Repository(value ="userDao")
public interface UserDao extends JpaRepository<User, String>{
	
	User findByUserId(String userId);
	
	
}
