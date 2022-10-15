/**
 * 
 */
package org.brc.com.transactional.model;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sandeep Rana
 *
 */
@Entity
@Table(name ="documents")
public class Documents implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 127367365L;
	
	@Id
	private String docId;
	
	private String fileName;
	
	private String userName;
	
	private String fileType;
	
	private Long uploadAt;
	
	private Long modifiedAt;
	

	public Long getUploadAt() {
		return uploadAt;
	}

	public Long getModifiedAt() {
		return modifiedAt;
	}

	public void setUploadAt(Long uploadAt) {
		this.uploadAt = uploadAt;
	}

	public void setModifiedAt(Long modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public String getDocId() {
		return docId;
	}

	public String getFileName() {
		return fileName;
	}

	public String getUserName() {
		return userName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	@Override
	public String toString() {
		return "Documents [docId=" + docId + ", fileName=" + fileName + ", userName=" + userName + ", fileType="
				+ fileType + ", uploadAt=" + uploadAt + ", modifiedAt=" + modifiedAt + "]";
	}
	
	public Documents() {
		this.uploadAt = Instant.now().atOffset(ZoneOffset.UTC).toInstant().toEpochMilli();
		this.modifiedAt = Instant.now().atOffset(ZoneOffset.UTC).toInstant().toEpochMilli();
		this.docId = UUID.randomUUID().toString().substring(24).toUpperCase() + "_" + Instant.now().atOffset(ZoneOffset.UTC).toInstant().toEpochMilli();
	}
	
}
