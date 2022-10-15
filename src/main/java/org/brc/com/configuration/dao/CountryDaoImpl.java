package org.brc.com.configuration.dao;

import java.util.List;

import org.brc.com.configuration.model.Country;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Sandeep Rana
 *
 */
@Repository(value ="countryDao")
public class CountryDaoImpl implements CountryDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Country findByCountryId(String countryId) {
		Criteria criteria =  sessionFactory.getCurrentSession().createCriteria(Country.class);
		criteria.add(Restrictions.eq("countryId", countryId));
		return (Country) criteria.uniqueResult();
	}

	@Override
	public Country saveUpdate(Country country) {
		sessionFactory.getCurrentSession().saveOrUpdate(country);
		return sessionFactory.getCurrentSession().get(Country.class, country.getCountryId());
	}
	
	@Override
	public List<Country> findAll() {
		Criteria criteria =  sessionFactory.getCurrentSession().createCriteria(Country.class);
		return criteria.list();
	}
	
	@Override
	public List<Country> getAllIsEnable() {
		Criteria criteria =  sessionFactory.getCurrentSession().createCriteria(Country.class);
		criteria.add(Restrictions.eq("isEnabled", true));
		return criteria.list();
	}
}
