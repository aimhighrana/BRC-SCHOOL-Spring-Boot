package org.brc.com.configuration.dao;

import org.brc.com.configuration.model.Sections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sandeep Rana
 *
 */
public interface SectionsDao {

	Sections saveUpdate(Sections sections);
	
	
}
