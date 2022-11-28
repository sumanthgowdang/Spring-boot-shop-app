package com.restapi.jsonschema.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.jsonschema.domain.Customer;
import com.restapi.jsonschema.services.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService cService;
	
	//Start  - types of Request handlers
//	@RequestMapping(value = "/customers" , method = RequestMethod.GET)
//	@ResponseBody
	@GetMapping("/Customers")
	public List<Customer> getCustomers() {
		return cService.getCustomers();
	}

	@GetMapping("/customer/{name}")
	public List<Customer> getCustomer(@PathVariable("name") String name) {
		return cService.getCustomerDetail(name);
	}
	@PostMapping("/customer/add")
	public Customer saveCustomer(@Validated @RequestBody Customer customer) {
		return cService.addCustomer(customer);
		
	}
	@PutMapping("/customer/{Id}")
	public Customer UpdateCustomer(@PathVariable Long Id , @RequestBody Customer customer) {
		customer.setId(Id);
		return cService.updateCustomer(customer);
	}
	@DeleteMapping("/customer")
	public void deletecustomer(@RequestParam("name") String name) {
		cService.deleteCustomer(name);
	}
}
