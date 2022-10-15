package org.brc.com.configuration.service;

import java.util.List;

import org.brc.com.configuration.dao.CityDao;
import org.brc.com.configuration.dao.CountryDao;
import org.brc.com.configuration.model.City;
import org.brc.com.configuration.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Sandeep Rana
 *
 */
@Service("countryService")
@Transactional
public class CountryServiceService implements CountryService {

	@Autowired
	private CountryDao countryDao;
	
	@Autowired
	private CityDao cityDao;
	
	@Override
	public Country save(Country country) {
		return countryDao.saveUpdate(country);
	}

	@Override
	public Country findByCountryId(String countryId) {
		return countryDao.findByCountryId(countryId);
	}

	@Override
	public List<Country> findAll() {
		return countryDao.findAll();
	}

	@Override
	public City saveCity(City city) {
		return cityDao.saveUpdate(city);
	}

	@Override
	public List<City> findCitiesByCountryId(String countryId) {
		return cityDao.findByCountryId(countryId);
	}
	
	@Override
	public City save(City city) {
		return cityDao.saveUpdate(city);
	}
	
	@Override
	public List<Country> getAllIsEnable() {
		return countryDao.getAllIsEnable();
	}
	
	@Override
	public List<City> getAllIsEnabled(String countryId) {
		return cityDao.getAllIsEnabled(countryId);
		
	}

}
