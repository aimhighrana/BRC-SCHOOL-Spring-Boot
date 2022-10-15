package org.brc.com.authentication.service;

import org.brc.com.authentication.model.UserInformation;

/**
 * @author Sandeep Rana
 *
 */
public interface UserInformationService {

	UserInformation save(UserInformation userInformation);

	UserInformation findByUserName(String userName);

}
