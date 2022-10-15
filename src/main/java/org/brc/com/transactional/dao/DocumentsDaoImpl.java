/**
 * 
 */
package org.brc.com.transactional.dao;

import java.util.List;

import org.brc.com.transactional.model.Documents;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Sandeep Rana
 *
 */
@Repository(value ="documentsDao")
public class DocumentsDaoImpl implements DocumentsDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Documents saveUpdate(Documents documents) {
		sessionFactory.getCurrentSession().saveOrUpdate(documents);
		return documents;
	}
	
	@Override
	public List<Documents> findByUserName(String userName) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Documents.class);
		criteria.add(Restrictions.eq("userName", userName));
		return criteria.list();
	}
	
	
}
