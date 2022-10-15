package org.brc.com.authentication.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.context.properties.bind.DefaultValue;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Sandeep Rana
 *
 */
@Entity
@Table(name ="USER")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1786785627835L;

	@Id
	@Column(name ="userId", nullable = false, length = 100)
//	@GenericGenerator(name = "sequence_id", strategy = "org.brc.com.utility.IdGenerator")
//    @GeneratedValue(generator = "sequence_id")
	private String userId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phone;
	
	private String fullName;
	
	@JsonIgnore
	private String password;
	
	private boolean isEnable;
	
	private boolean isExpried;
	
	private Long userCreatedDate;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Roles> roles;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnable() {
		return isEnable;
	}

	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}

	public boolean isExpried() {
		return isExpried;
	}

	public void setExpried(boolean isExpried) {
		this.isExpried = isExpried;
	}

	public Long getUserCreatedDate() {
		return userCreatedDate;
	}

	public void setUserCreatedDate(Long userCreatedDate) {
		this.userCreatedDate = userCreatedDate;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + (isEnable ? 1231 : 1237);
		result = prime * result + (isExpried ? 1231 : 1237);
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((userCreatedDate == null) ? 0 : userCreatedDate.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (isEnable != other.isEnable)
			return false;
		if (isExpried != other.isExpried)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (userCreatedDate == null) {
			if (other.userCreatedDate != null)
				return false;
		} else if (!userCreatedDate.equals(other.userCreatedDate))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	
	public User() {
		this.isEnable = Boolean.TRUE;
		this.isExpried = Boolean.TRUE;
		this.userCreatedDate = LocalDateTime.now().atZone(ZoneId.of("UTC")).toInstant().toEpochMilli();
	}
	

}
