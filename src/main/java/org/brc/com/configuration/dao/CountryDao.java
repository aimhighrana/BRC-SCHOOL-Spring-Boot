package org.brc.com.configuration.dao;

import java.util.List;

import org.brc.com.configuration.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sandeep Rana
 *
 */
public interface CountryDao {

	Country findByCountryId(String countryId);

	Country saveUpdate(Country country);

	List<Country> findAll();

	List<Country> getAllIsEnable();
	
	
}
