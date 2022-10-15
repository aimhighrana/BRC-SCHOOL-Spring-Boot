package org.brc.com.configuration.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SECTIONS")
public class Sections implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 13572372374L;
	
	@Id
	@Column(name ="sectionId", nullable = false, length = 100)
	private String sectionId;
	
	private String sectionName;
	
//	@ManyToOne
//    @JoinColumn(name="class1_id", nullable=false)
//	private Class1 class1;

	public String getSectionId() {
		return sectionId;
	}

	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	
	
//	public Class1 getClass1() {
//		return class1;
//	}
//
//	public void setClass1(Class1 class1) {
//		this.class1 = class1;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sectionId == null) ? 0 : sectionId.hashCode());
		result = prime * result + ((sectionName == null) ? 0 : sectionName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sections other = (Sections) obj;
		if (sectionId == null) {
			if (other.sectionId != null)
				return false;
		} else if (!sectionId.equals(other.sectionId))
			return false;
		if (sectionName == null) {
			if (other.sectionName != null)
				return false;
		} else if (!sectionName.equals(other.sectionName))
			return false;
		return true;
	}
	
	
	

}
