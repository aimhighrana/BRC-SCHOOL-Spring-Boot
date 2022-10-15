package org.brc.com.configuration.dao;

import java.util.List;

import org.brc.com.configuration.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sandeep Rana
 *
 */
public interface CityDao {
	
	List<City> findByCountryId(String countryId);

	City saveUpdate(City city);

	List<City> getAllIsEnabled(String countryId);
}
