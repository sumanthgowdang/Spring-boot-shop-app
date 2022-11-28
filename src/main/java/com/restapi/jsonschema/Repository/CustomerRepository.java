package com.restapi.jsonschema.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.restapi.jsonschema.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

	List<Customer> findByName(String name);
	void deleteUsersByName(String name);
	@Query("FROM Customer Where name=:name")
	Customer getByName(String name);

}
