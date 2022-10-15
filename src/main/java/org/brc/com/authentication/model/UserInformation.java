package org.brc.com.authentication.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sandeep Rana
 *
 */
@Entity
@Table(name="USER_INFORMATION")
public class UserInformation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1752356786237L;
	
	@Id
	@Column(name="userName", nullable = false, length = 100)
	private String userName;
	
	private String country;
	
	private String city;
	
	private String address;
	
	private String profileImgSno;
	
	private Integer friends;
	
	private String aboutme;
	
	private String nickName;
	
	private String telephone;
	
	private String panNumber;
	
	private String aadharNumber;
	
	private String workingOn;
	
	private String parent;
	
	private String guardianName;
	
	private String motherName;
	
	private String previousClass;
	
	private String previousSection;
	
	private String previousMarks;
	
	private String currentClass;
	
	private String currentSection;
	
	

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getWorkingOn() {
		return workingOn;
	}

	public void setWorkingOn(String workingOn) {
		this.workingOn = workingOn;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getPreviousClass() {
		return previousClass;
	}

	public void setPreviousClass(String previousClass) {
		this.previousClass = previousClass;
	}

	public String getPreviousSection() {
		return previousSection;
	}

	public void setPreviousSection(String previousSection) {
		this.previousSection = previousSection;
	}

	public String getPreviousMarks() {
		return previousMarks;
	}

	public void setPreviousMarks(String previousMarks) {
		this.previousMarks = previousMarks;
	}

	public String getCurrentClass() {
		return currentClass;
	}

	public void setCurrentClass(String currentClass) {
		this.currentClass = currentClass;
	}

	public String getCurrentSection() {
		return currentSection;
	}

	public void setCurrentSection(String currentSection) {
		this.currentSection = currentSection;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProfileImgSno() {
		return profileImgSno;
	}

	public void setProfileImgSno(String profileImgSno) {
		this.profileImgSno = profileImgSno;
	}

	public Integer getFriends() {
		return friends;
	}

	public void setFriends(Integer friends) {
		this.friends = friends;
	}

	public String getAboutme() {
		return aboutme;
	}

	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aadharNumber == null) ? 0 : aadharNumber.hashCode());
		result = prime * result + ((aboutme == null) ? 0 : aboutme.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((currentClass == null) ? 0 : currentClass.hashCode());
		result = prime * result + ((currentSection == null) ? 0 : currentSection.hashCode());
		result = prime * result + ((friends == null) ? 0 : friends.hashCode());
		result = prime * result + ((guardianName == null) ? 0 : guardianName.hashCode());
		result = prime * result + ((motherName == null) ? 0 : motherName.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result + ((panNumber == null) ? 0 : panNumber.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + ((previousClass == null) ? 0 : previousClass.hashCode());
		result = prime * result + ((previousMarks == null) ? 0 : previousMarks.hashCode());
		result = prime * result + ((previousSection == null) ? 0 : previousSection.hashCode());
		result = prime * result + ((profileImgSno == null) ? 0 : profileImgSno.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((workingOn == null) ? 0 : workingOn.hashCode());
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
		UserInformation other = (UserInformation) obj;
		if (aadharNumber == null) {
			if (other.aadharNumber != null)
				return false;
		} else if (!aadharNumber.equals(other.aadharNumber))
			return false;
		if (aboutme == null) {
			if (other.aboutme != null)
				return false;
		} else if (!aboutme.equals(other.aboutme))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (currentClass == null) {
			if (other.currentClass != null)
				return false;
		} else if (!currentClass.equals(other.currentClass))
			return false;
		if (currentSection == null) {
			if (other.currentSection != null)
				return false;
		} else if (!currentSection.equals(other.currentSection))
			return false;
		if (friends == null) {
			if (other.friends != null)
				return false;
		} else if (!friends.equals(other.friends))
			return false;
		if (guardianName == null) {
			if (other.guardianName != null)
				return false;
		} else if (!guardianName.equals(other.guardianName))
			return false;
		if (motherName == null) {
			if (other.motherName != null)
				return false;
		} else if (!motherName.equals(other.motherName))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		if (panNumber == null) {
			if (other.panNumber != null)
				return false;
		} else if (!panNumber.equals(other.panNumber))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		if (previousClass == null) {
			if (other.previousClass != null)
				return false;
		} else if (!previousClass.equals(other.previousClass))
			return false;
		if (previousMarks == null) {
			if (other.previousMarks != null)
				return false;
		} else if (!previousMarks.equals(other.previousMarks))
			return false;
		if (previousSection == null) {
			if (other.previousSection != null)
				return false;
		} else if (!previousSection.equals(other.previousSection))
			return false;
		if (profileImgSno == null) {
			if (other.profileImgSno != null)
				return false;
		} else if (!profileImgSno.equals(other.profileImgSno))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (workingOn == null) {
			if (other.workingOn != null)
				return false;
		} else if (!workingOn.equals(other.workingOn))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "UserInformation [userName=" + userName + ", country=" + country + ", city=" + city + ", address="
				+ address + ", profileImgSno=" + profileImgSno + ", friends=" + friends + ", aboutme=" + aboutme
				+ ", nickName=" + nickName + ", telephone=" + telephone + ", panNumber=" + panNumber + ", aadharNumber="
				+ aadharNumber + ", workingOn=" + workingOn + ", parent=" + parent + ", guardianName=" + guardianName
				+ ", motherName=" + motherName + ", previousClass=" + previousClass + ", previousSection="
				+ previousSection + ", previousMarks=" + previousMarks + ", currentClass=" + currentClass
				+ ", currentSection=" + currentSection + "]";
	}

	public UserInformation() {
		super();
		this.profileImgSno = "PRO_"+UUID.randomUUID().toString().substring(24).toUpperCase() + "_" + Calendar.getInstance().getTimeInMillis();
	}
	
	
	
	

}
