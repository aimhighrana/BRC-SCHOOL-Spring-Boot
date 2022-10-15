/**
 * 
 */
package org.brc.com.transactional.service;

import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.brc.com.transactional.model.Documents;
import org.brc.com.utility.FileUploadHelper;

/**
 * @author Sandeep Rana
 *
 */
public interface DocumentsService {

	List<Documents> saveUpdateDocs(List<Documents> documents);

	List<Documents> findByUserName(String userName);

	boolean saveDocAndUploadDoc(FileUploadHelper helper, String userName) throws FileUploadException;

}
