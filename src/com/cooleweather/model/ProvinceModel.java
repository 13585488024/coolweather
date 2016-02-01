package com.cooleweather.model;

import java.io.Serializable;

public class ProvinceModel implements Serializable {

	private static final long serialVersionUID = -7099442295337797189L;
	
	private Integer provingId;
	private String provingName;
	private String provingCode;
	
	public Integer getProvingId() {
		return provingId;
	}
	public void setProvingId(Integer provingId) {
		this.provingId = provingId;
	}
	public String getProvingName() {
		return provingName;
	}
	public void setProvingName(String provingName) {
		this.provingName = provingName;
	}
	public String getProvingCode() {
		return provingCode;
	}
	public void setProvingCode(String provingCode) {
		this.provingCode = provingCode;
	}

	
	
}
