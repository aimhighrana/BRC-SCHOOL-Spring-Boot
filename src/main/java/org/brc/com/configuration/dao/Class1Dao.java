package org.brc.com.configuration.dao;

import java.util.List;

import org.brc.com.configuration.model.Class1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sandeep Rana
 *
 */
public interface Class1Dao {

	Class1 saveUpdate(Class1 class1);

	List<Class1> findAll();

	List<Class1> findAllClass();

	boolean delete(Class1 class1);
	
	
	
}
