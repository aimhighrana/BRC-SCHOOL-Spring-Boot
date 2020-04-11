package org.brc.com.authentication.service;

import org.brc.com.authentication.dao.UserDao;
import org.brc.com.authentication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Sandeep Rana
 *
 */
@Service(value ="userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User save(User user) {
		return userDao.save(user);
	}
	
	
	@Override
	public User findByUserId(String userId) {
		return userDao.findByUserId(userId);
	}

}
