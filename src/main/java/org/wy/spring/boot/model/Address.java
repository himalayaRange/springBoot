package org.wy.spring.boot.model;

import java.io.Serializable;

public class Address implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String province;
	private String city;
	public Address(){}
	public Address(Long id, String province, String city) {
		super();
		this.id = id;
		this.province = province;
		this.city = city;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", province=" + province + ", city="
				+ city + "]";
	}
	
}
