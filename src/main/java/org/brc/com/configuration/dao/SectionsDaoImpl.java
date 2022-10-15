package org.brc.com.configuration.dao;

import org.brc.com.configuration.model.Sections;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Sandeep Rana
 *
 */
@Repository(value ="sectionsDao")
@Transactional
public class SectionsDaoImpl implements SectionsDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Sections saveUpdate(Sections sections) {
		sessionFactory.getCurrentSession().saveOrUpdate(sections);
		return sections;
	}
}
