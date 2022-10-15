package org.brc.com.authentication.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.brc.com.authentication.model.Roles;
import org.brc.com.authentication.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.ResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Sandeep Rana
 *
 */
@Repository(value ="userDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public User findByUserId(String userId) {
		Criteria criteria =  sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("userId", userId));
		return (User) criteria.uniqueResult();
	}

	@Override
	public User saveUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return user;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public List<User> findByRole(String role) {
		String executableQry = "SELECT user.* FROM user user  INNER JOIN user_roles uroles ON user.userId = uroles.User_userId \r\n" + 
				"WHERE uroles.roles_roleId IN (SELECT role.roleId FROM roles role WHERE role.roleName = ?)";
		
		Query<User> query =  sessionFactory.getCurrentSession().createSQLQuery(executableQry);
		query.setParameter(1, role);
		List<User> users = new ArrayList<User>();
		query.setResultTransformer(new ResultTransformer() {
			
			@Override
			public Object transformTuple(Object[] val, String[] arg1) {
				User user = new User();
				user.setUserId(String.valueOf(val[0]));
				user.setFirstName(String.valueOf(val[2]));
				user.setLastName(String.valueOf(val[5]));
				return users.add(user);
			}
			
			@Override
			public List transformList(List arg0) {
				return arg0;
			}
		}).list();
		
		return users;
	}

	@Override
	public List<User> findAll(String qryString) {
		String query = "SELECT user.*,roles.* FROM user user INNER JOIN user_roles uroles ON user.userId = uroles.User_userId \r\n" + 
				"LEFT OUTER JOIN roles roles ON roles.roleId = uroles.roles_roleId \r\n" + 
				"WHERE (user.userId LIKE ? OR user.firstName LIKE ? OR user.lastName LIKE ? OR user.email LIKE ? OR user.phone LIKE ?)";
		Query<User> criteria =  sessionFactory.getCurrentSession().createSQLQuery(query);
		criteria.setParameter(1, qryString);
		criteria.setParameter(2, qryString);
		criteria.setParameter(3, qryString);
		criteria.setParameter(4, qryString);
		criteria.setParameter(5, qryString);
	
		criteria.setFirstResult(0);
		criteria.setMaxResults(20);
		
		List<User> users = new ArrayList<User>();
		criteria.setResultTransformer(new ResultTransformer() {
			
			@Override
			public Object transformTuple(Object[] val, String[] arg1) {
				User user = new User();
				
				user.setUserId(String.valueOf(val[0]));
				user.setEmail(String.valueOf(val[1]));
				user.setFirstName(String.valueOf(val[2]));
				user.setEnable(String.valueOf(val[3]).equals("1") ? true : false);
				user.setExpried(String.valueOf(val[4]).equals("1") ? true : false);
				user.setLastName(String.valueOf(val[5]));
				user.setPhone(String.valueOf(val[7]));
				user.setUserCreatedDate(Long.parseLong(String.valueOf(val[8])));
				
				Roles roles = new Roles();
				roles.setRoleId(Long.parseLong(String.valueOf(val[9])));
				roles.setRoleDesc(String.valueOf(val[10]));
				roles.setRoleName(String.valueOf(val[11]));
				
				Set<Roles> setRoles = new HashSet<>();
				setRoles.add(roles);
				user.setRoles(setRoles);
				return users.add(user);
			}
			
			@Override
			public List transformList(List arg0) {
				return arg0;
			}
		}).list();
		return users;
	}
}
