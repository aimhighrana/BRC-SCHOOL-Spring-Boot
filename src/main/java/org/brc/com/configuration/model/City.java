package org.brc.com.configuration.model;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZoneOffset;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Sandeep Rana
 *
 */
@Entity
@Table(name ="city")
public class City implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 17235475237572L;
	
	@Id
	private String cityId;
	
	@NotNull
	private String countryId;
	
	private String cityName;
	
	private Boolean isEnabled;
	
	private Long createdDate;
	
	private Long updatedDate;

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Long getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Long createdDate) {
		this.createdDate = createdDate;
	}

	public Long getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Long updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", countryId=" + countryId + ", cityName=" + cityName + ", isEnabled="
				+ isEnabled + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}
	
	public City() {
		this.isEnabled = Boolean.TRUE;
		this.createdDate = Instant.now().atOffset(ZoneOffset.UTC).toInstant().toEpochMilli();
		this.updatedDate = Instant.now().atOffset(ZoneOffset.UTC).toInstant().toEpochMilli();
	}
	

}
