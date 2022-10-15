/**
 * 
 */
package org.brc.com.utility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * Helper for upload any type file ..
 * @author Sandeep Rana
 *
 */
@Component
public class FileUpload {

	@Value("${file.paths}")
	private String filePath;
	
	/**
	 * Help for upload file , if the file is exit then replace it 
	 * If you want to not replace then see {@link FileUploadHelper} 
	 * 
	 * @param fileReqs
	 * @throws FileUploadException
	 * @return if upload successfully then return true otherwise throw {@link FileUploadException}
	 */
	public boolean upload(List<FileUploadHelper> fileReqs) throws FileUploadException {
		List<Boolean> status = new ArrayList<>();
		// check folder exits 
		fileReqs.forEach(file->{
			String finalPath = filePath + "/" + file.getFolderName();
			if(! new File(finalPath).exists()) {
				new File(finalPath).mkdirs();
			}
			// transfer file 
			try {
				file.getFile().transferTo(new File(finalPath+"/"+ file.getFileCode()+file.getFileType()));
				status.add(Boolean.TRUE);
			} catch (Exception e) {
				status.add(Boolean.FALSE);
				e.printStackTrace();
			}
			
		});
		if(status.stream().filter(fil-> !fil.booleanValue()).collect(Collectors.toList()).size() >0) {
			throw new FileUploadException("Exception while file upload check logs !!!");
		}
		return Boolean.TRUE;
	}
	
	
}
