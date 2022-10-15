package org.brc.com.configuration.service;

import java.util.List;

import org.brc.com.configuration.model.Class1;
import org.brc.com.configuration.model.Sections;

/**
 * @author Sandeep Rana
 *
 */
public interface ClassSectionsService {
	
	Class1 save(Class1 class1);

	Sections save(Sections sections);

	Class1 saveUpdateClassSections(Class1 class1);

	List<Class1> findAllClass1();

	boolean delete(Class1 class1);
}
