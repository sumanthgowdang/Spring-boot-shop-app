package com.restapi.jsonschema.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fruit {

		@Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	    private Long Id;
	    private String name;
	    private int price;
	    private int quantity;
		public Long getId() {
			return Id;
		}
		@Override
		public String toString() {
			return "Fruit [Id=" + Id + ", name=" + name + ", price=" + price + ", quantity=" + quantity
					+ "]";
		}
		public Fruit(Long Id, String name, int price, int quantity) {
			super();
			this.Id = Id;
			this.name = name;
			this.price = price;
			this.quantity = quantity;
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
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public Fruit() {

		}

}
