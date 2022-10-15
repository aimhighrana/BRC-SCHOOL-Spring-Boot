package org.brc.com.configuration.dao;

import java.util.List;

import org.brc.com.configuration.model.City;
import org.brc.com.configuration.model.Country;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 * 
 * @author Sandeep Rana
 *
 */
@Repository(value = "cityDao")
public class CityDaoImpl implements CityDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<City> findByCountryId(String countryId) {
		Criteria criteria =  sessionFactory.getCurrentSession().createCriteria(City.class);
		criteria.add(Restrictions.eq("countryId", countryId));
		return criteria.list();
	}
	
	@Override
	public City saveUpdate(City city) {
		sessionFactory.getCurrentSession().saveOrUpdate(city);
		return city;
	}
	
	@Override
	public List<City> getAllIsEnabled(String countryId) {
		Criteria criteria =  sessionFactory.getCurrentSession().createCriteria(City.class);
		criteria.add(Restrictions.eq("isEnabled", true));
		criteria.add(Restrictions.eq("countryId", countryId));
		return criteria.list();
	}

}
