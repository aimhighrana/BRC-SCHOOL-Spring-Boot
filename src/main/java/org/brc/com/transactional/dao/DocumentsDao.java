/**
 * 
 */
package org.brc.com.transactional.dao;

import java.util.List;

import org.brc.com.transactional.model.Documents;

/**
 * @author Sandeep Rana
 *
 */
public interface DocumentsDao {

	Documents saveUpdate(Documents documents);

	List<Documents> findByUserName(String userName);

}
