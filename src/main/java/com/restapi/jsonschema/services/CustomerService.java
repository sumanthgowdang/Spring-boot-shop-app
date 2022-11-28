package com.restapi.jsonschema.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.restapi.jsonschema.Repository.CustomerRepository;
import com.restapi.jsonschema.domain.Customer;
import com.restapi.jsonschema.domain.Student;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository cRepository;

	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return (List<Customer>) cRepository.findAll();
	}
	
	public List<Customer> getCustomerDetail(String name) {
		// TODO Auto-generated method stub
		return (List<Customer>) cRepository.findByName(name);
	}
	public Customer addCustomer(@Validated Customer customer) {
		// TODO Auto-generated method stub
		return cRepository.save(customer);
	}
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return cRepository.save(customer);
	}
	public void deleteCustomer(String name) {
		// TODO Auto-generated method stub
		cRepository.deleteUsersByName(name);
		
	}
	public List<Customer> listAll() {
        return cRepository.findAll();
    }
     
    public void save(Customer std) {
    	cRepository.save(std);
    }
     
    public Customer get(long id) {
        return cRepository.findById(id).get();
    }
     
    public void delete(long id) {
    	cRepository.deleteById(id);
    }
}

