package com.pos.org.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Organization")
public class Organization {
	@Id
	@Column(name="org_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private BigDecimal id;
	
	@Column(name="org_name")
	private String name;
	
	@Column(name="org_email")
	private String email;
	
	@Column(name="org_phone")
	private String phoneNo;
	
	@Column(name="org_logo")
	private String logo;
	
	public String getName() {
		return name;
	}
	
	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		return "Organization [name=" + name + ",  email=" + email + ", phoneNo=" + phoneNo
				+ "]";
	}
}
