package com.cooleweather.model;

import java.io.Serializable;

public class CountyModel implements Serializable {

	private static final long serialVersionUID = 6377067631053476231L;
	
	private Integer countyId;
	private String countyName;
	private String countyCode;
	private Integer cityId;
	
	public Integer getCountyId() {
		return countyId;
	}
	public void setCountyId(Integer countyId) {
		this.countyId = countyId;
	}
	public String getCountyName() {
		return countyName;
	}
	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}
	public String getCountyCode() {
		return countyCode;
	}
	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	
	
	
}
