package org.brc.com.authentication.service;

import org.brc.com.authentication.dao.UserInformationDao;
import org.brc.com.authentication.model.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Sandeep Rana
 *
 */
@Service("userInformationService")
@Transactional
public class UserInformationServiceImpl implements UserInformationService {

	@Autowired
	private UserInformationDao userInformationDao;
	
	@Override
	public UserInformation save(UserInformation userInformation) {
		return userInformationDao.saveUpdate(userInformation);
	}
	
	@Override
	public UserInformation findByUserName(String userName) {
		return userInformationDao.findByUserName(userName);
	}
	
	
}
