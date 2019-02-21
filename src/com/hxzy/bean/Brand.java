package com.hxzy.bean;

import java.io.Serializable;

public class Brand implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -371083075032178719L;

	private Integer brandId;
	private String brandName;
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Brand(String brandName) {
		super();
		this.brandName = brandName;
	}
	public Brand() {
		super();
	}
	
	public Brand(Integer brandId) {
		super();
		this.brandId = brandId;
	}
	
	public Brand(Integer brandId, String brandName) {
		super();
		this.brandId = brandId;
		this.brandName = brandName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brandId == null) ? 0 : brandId.hashCode());
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
		Brand other = (Brand) obj;
		if (brandId == null) {
			if (other.brandId != null)
				return false;
		} else if (!brandId.equals(other.brandId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Brand [brandId=" + brandId + ", brandName=" + brandName + "]";
	}
	
	
}
