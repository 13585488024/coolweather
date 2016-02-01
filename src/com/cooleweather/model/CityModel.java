package com.cooleweather.model;

import java.io.Serializable;

public class CityModel implements Serializable {

	private static final long serialVersionUID = -6650509988311798971L;
	
	private Integer crtyId;
	private String cityName;
	private String cityCode;
	private Integer provinceId;
	
	public Integer getCrtyId() {
		return crtyId;
	}
	public void setCrtyId(Integer crtyId) {
		this.crtyId = crtyId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	
	

}
