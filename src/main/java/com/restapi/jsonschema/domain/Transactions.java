package com.restapi.jsonschema.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transactions {
	public Transactions() {
		super();
	}
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	public Transactions(Long id, int quantity, String name, String customer) {
		super();
		Id = id;
		this.quantity = quantity;
		this.name = name;
		this.customer = customer;
	}
	private Long fruit_id;
	private Long customer_id;
	private int quantity;
	private String name;
	private String customer;
	private int status;
	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public Long getFruit_id() {
		return fruit_id;
	}


	public void setFruit_id(Long fruit_id) {
		this.fruit_id = fruit_id;
	}


	public Long getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCustomer() {
		return customer;
	}


	public void setCustomer(String customer) {
		this.customer = customer;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}
	private int cost;
	
	@Override
	public String toString() {
		return "Transactions [Id=" + Id + ", fruit_id=" + fruit_id + ", customer_id=" + customer_id + ", quantity="
				+ quantity + ", name=" + name + ", customer=" + customer + ", cost=" + cost + "]";
	}


	public Transactions(Long Id, Long fruit_id, Long customer_id, int quantity) {
		super();
		this.Id = Id;
		this.fruit_id = fruit_id;
		this.customer_id = customer_id;
		this.quantity = quantity;
	}


	public Transactions(Long Id, Long fruit_id, Long customer_id, int quantity, String name, String customer,int cost) {
		super();
		this.Id = Id;
		this.fruit_id = fruit_id;
		this.customer_id = customer_id;
		this.quantity = quantity;
		this.name = name;
		this.customer = customer;
		this.cost=cost;
	}
	
	

}
