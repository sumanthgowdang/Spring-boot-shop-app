package com.restapi.jsonschema.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Table(name = "customer")
public class Customer {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Override
	public String toString() {
		return "Customer [Id=" + Id + ", name=" + name + ", phone_no=" + phone_no + ", Role=" + role + "]";
	}

	private String name;
	
	private String password;
	
	

	public Customer(Long id, String name, String password, String phone_no, String role) {
		super();
		System.out.println("line 34");
		Id = id;
		this.name = name;
		this.password = password;
		System.out.println(this.password);
		this.phone_no = phone_no;
		this.role = role;
	}
	public Customer() {
		super();
		System.out.println("line 47");
	}
	


	public Customer(Long id, String name, String password) {
		super();
		System.out.println("line 54");
		Id = id;
		this.name = name;
		this.password = password;
	}

	private String phone_no;

	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		System.out.println("line 101");
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String testPasswordEncoded = "{bcrypt}" + passwordEncoder.encode(password);
		this.password = testPasswordEncoded;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, name, password, phone_no, role);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(phone_no, other.phone_no)
				&& Objects.equals(role, other.role);
	}
}
