package org.brc.com.configuration.service;

import java.util.List;

import org.brc.com.configuration.model.City;
import org.brc.com.configuration.model.Country;

/**
 * @author Sandeep Rana
 *
 */
public interface CountryService {

	Country save(Country country);
	
	Country findByCountryId(String countryId);
	
	List<Country> findAll();
	
	City saveCity(City city);
	
	List<City> findCitiesByCountryId(String countryId);

	City save(City city);

	List<Country> getAllIsEnable();

	List<City> getAllIsEnabled(String countryId);
	
}
