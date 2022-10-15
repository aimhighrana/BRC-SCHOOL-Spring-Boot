package org.brc.com.configuration.dao;

import java.util.ArrayList;
import java.util.List;

import org.brc.com.configuration.model.Class1;
import org.brc.com.configuration.model.Sections;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.ResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Sandeep Rana
 *
 */
@Repository(value ="class1Dao")
public class Class1DaoImpl implements Class1Dao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Class1 saveUpdate(Class1 class1) {
		sessionFactory.getCurrentSession().saveOrUpdate(class1);
		return class1;
	}
	
	@Override
	public List<Class1> findAll() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Class1.class);
		return criteria.list();
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Class1> findAllClass() {
		List<Class1> classes = new ArrayList<>();
		
		String classQuery = "SELECT *FROM class";
		Query<Class1> query =  sessionFactory.getCurrentSession().createSQLQuery(classQuery);
		query.setResultTransformer(new ResultTransformer() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1242578L;

			@Override
			public Object transformTuple(Object[] values, String[] arg1) {
				Class1 class1 = new Class1();
				class1.setClassId(String.valueOf(values[0]));
				class1.setClassName(String.valueOf(values[1]));
//				classes.add(class1);
				return class1;
			}
			
			@Override
			public List transformList(List list) {
				return list;
			}
		});
		classes = (List<Class1>) query.list();
		
		if(classes !=null && !classes.isEmpty()) {
			String joinedQuery = "SELECT sec.sectionId , sec.sectionName  FROM class  cls inner  JOIN \r\n" + 
					"class_sections cls_sec ON cls.classId = cls_sec.Class1_classId\r\n" + 
					"INNER JOIN sections sec ON sec.sectionId = cls_sec.sections_sectionId\r\n" + 
					"WHERE cls.classId = ?";
			
			classes.forEach(class1->{
				Query exeQuery =  sessionFactory.getCurrentSession().createSQLQuery(joinedQuery);
				exeQuery.setParameter(1, class1.getClassId());
				
				List<Sections> sections = new ArrayList<>(); 
				exeQuery.setResultTransformer(new ResultTransformer() {
					
					@Override
					public Object transformTuple(Object[] value, String[] arg1) {
						Sections section = new Sections();
						section.setSectionId(String.valueOf(value[0]));
						section.setSectionName(String.valueOf(value[1]));
						return section;
					}
					
					@Override
					public List transformList(List arg0) {
						return arg0;
					}
				});
				sections = exeQuery.list();
				class1.setSections(sections);
			});
		}
		return classes;
	}
	
	@Override
	public boolean delete(Class1 class1) {
		
		String classQuery = "delete from class where classId = ?";
		Query<Class1> qryCls = sessionFactory.getCurrentSession().createSQLQuery(classQuery);
		qryCls.setParameter(1, class1.getClassId());
		qryCls.executeUpdate();
		
		String classSecQuery = "delete from class_sections where Class1_classId = ?";
		Query<Class1> qryClassSecQuery = sessionFactory.getCurrentSession().createSQLQuery(classSecQuery);
		qryClassSecQuery.setParameter(1, class1.getClassId());
		qryClassSecQuery.executeUpdate();
		
		return Boolean.TRUE;
	}
}
