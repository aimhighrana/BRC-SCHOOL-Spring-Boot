package org.brc.com.authentication.dao;

import org.brc.com.authentication.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sandeep Rana
 *
 */
@Repository(value ="rolesDao")
public interface RolesDao extends JpaRepository<Roles, Long> {

	
	
}
