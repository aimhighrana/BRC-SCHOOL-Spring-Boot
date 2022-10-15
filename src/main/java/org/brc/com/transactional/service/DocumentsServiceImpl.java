/**
 * 
 */
package org.brc.com.transactional.service;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.brc.com.transactional.dao.DocumentsDao;
import org.brc.com.transactional.model.Documents;
import org.brc.com.utility.FileUpload;
import org.brc.com.utility.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Sandeep Rana
 *
 */
@Service(value ="documentsService")
@Transactional
public class DocumentsServiceImpl implements DocumentsService {

	@Autowired
	private DocumentsDao documentsDao;
	
	@Autowired
	private FileUpload fileUpload;
	
	@Override
	public List<Documents> saveUpdateDocs(List<Documents> documents) {
		documents.forEach(doc->{
			documentsDao.saveUpdate(doc);
		});
		return documents;
	}
	
	@Override
	public List<Documents> findByUserName(String userName) {
		return documentsDao.findByUserName(userName);
	}
	
	@Override
	public boolean saveDocAndUploadDoc(FileUploadHelper helper, String userName) throws FileUploadException {
		Documents documents = new Documents();
		documents.setFileName(helper.getFileName());
		documents.setFileType(helper.getFileType()!=null ? helper.getFileType() : ".pdf");
		helper.setFolderName(helper.getFolderName()!=null ? helper.getFolderName() : "student_doc");
		documents.setUserName(userName);
		helper.setFileCode(documents.getDocId());
		helper.setFileType(helper.getFileType()!=null ? helper.getFileType() : ".pdf");
		saveUpdateDocs(Arrays.asList(documents));
		return fileUpload.upload(Arrays.asList(helper));
		
	}
}
