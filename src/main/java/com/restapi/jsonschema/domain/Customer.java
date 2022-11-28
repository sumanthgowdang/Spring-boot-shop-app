package com.restapi.jsonschema.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Override
	public String toString() {
		return "Customer [Id=" + Id + ", name=" + name + ", phone_no=" + phone_no + "]";
	}

	private String name;
	
	private String phone_no;

	public Long getId() {
		return Id;
	}

	public void setId(Long Id) {
		this.Id = Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
}
