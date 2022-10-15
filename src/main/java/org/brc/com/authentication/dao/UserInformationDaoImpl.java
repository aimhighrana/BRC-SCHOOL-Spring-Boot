package org.brc.com.authentication.dao;

import org.brc.com.authentication.model.UserInformation;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Sandeep Rana
 *
 */
@Repository("userInformationDao")
public class UserInformationDaoImpl implements UserInformationDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public UserInformation findByUserName(String userName) {
		Criteria criteria =  sessionFactory.getCurrentSession().createCriteria(UserInformation.class);
		criteria.add(Restrictions.eq("userName", userName));
		return (UserInformation) criteria.uniqueResult();
	}
	
	@Override
	public UserInformation saveUpdate(UserInformation userInformation) {
		sessionFactory.getCurrentSession().saveOrUpdate(userInformation);
		return sessionFactory.getCurrentSession().get(UserInformation.class, userInformation.getUserName());
	}

}
