package org.brc.com.authentication.dao;

import org.brc.com.authentication.model.Roles;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Sandeep Rana
 *
 */
@Repository(value ="rolesDao")
public class RolesDaoImpl implements RolesDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Roles saveUpdate(Roles roles) {
		sessionFactory.getCurrentSession().saveOrUpdate(roles);
		return roles;
	}
	
	@Override
	public Roles findByRoleName(String roleName) {
		Criteria criteria =  sessionFactory.getCurrentSession().createCriteria(Roles.class);
		criteria.add(Restrictions.eq("roleName", roleName));
		return (Roles) criteria.uniqueResult();
	}
}
