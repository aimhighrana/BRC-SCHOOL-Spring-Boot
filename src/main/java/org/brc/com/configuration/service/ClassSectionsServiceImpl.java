package org.brc.com.configuration.service;

import java.util.List;

import org.brc.com.configuration.dao.Class1Dao;
import org.brc.com.configuration.dao.SectionsDao;
import org.brc.com.configuration.model.Class1;
import org.brc.com.configuration.model.Sections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Sandeep Rana
 *
 */
@Service(value ="classSectionsService")
@Transactional
public class ClassSectionsServiceImpl implements ClassSectionsService {

	@Autowired
	private Class1Dao class1Dao;
	
	@Autowired
	private SectionsDao sectionsDao;
	
	@Override
	public Class1 save(Class1 class1) {
		return class1Dao.saveUpdate(class1);
	}
	
	@Override
	public Sections save(Sections sections) {
		return sectionsDao.saveUpdate(sections);
	}
	
	@Override
	public Class1 saveUpdateClassSections(Class1 class1) {
		return class1Dao.saveUpdate(class1);
	}
	
	@Override
	public List<Class1> findAllClass1() {
		return class1Dao.findAllClass();
	}
	
	@Override
	public boolean delete(Class1 class1) {
		return class1Dao.delete(class1);
	}

}
