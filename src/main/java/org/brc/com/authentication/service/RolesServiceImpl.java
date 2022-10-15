package org.brc.com.authentication.service;

import org.brc.com.authentication.dao.RolesDao;
import org.brc.com.authentication.model.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Sandeep Rana
 *
 */
@Service(value ="rolesService")
public class RolesServiceImpl implements RolesService {

	@Autowired
	private RolesDao rolesDao;
	
	@Override
	public Roles save(Roles roles) {
		return rolesDao.save(roles);
	}

}
