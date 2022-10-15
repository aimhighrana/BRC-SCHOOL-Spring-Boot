/**
 * 
 */
package org.brc.com.utility;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

/**
 * Dto for help file upload request
 * @author Sandeep Rana
 *
 */
public class FileUploadHelper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 127427547L;
	
	
	
	private String fileType;
	
	private String fileName;
	
	private String folderName;
	
	private MultipartFile file;
	
	private boolean ifExitReplace;
	
	private String fileCode;

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public boolean isIfExitReplace() {
		return ifExitReplace;
	}

	public void setIfExitReplace(boolean ifExitReplace) {
		this.ifExitReplace = ifExitReplace;
	}

	public String getFileCode() {
		return fileCode;
	}

	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "FileUploadHelper [fileType=" + fileType + ", folderName=" + folderName + ", file=" + file
				+ ", ifExitReplace=" + ifExitReplace + ", fileCode=" + fileCode + "]";
	}
	
	
	public FileUploadHelper() {
		this.ifExitReplace = Boolean.TRUE;
	}

}
