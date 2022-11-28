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

import com.restapi.jsonschema.Repository.CustomerRepository;
import com.restapi.jsonschema.domain.Fruit;
import com.restapi.jsonschema.domain.Transactions;
import com.restapi.jsonschema.services.TransactionsService;

@RestController
public class TransactionsController {
	@Autowired
	private TransactionsService tService;
	
	//Start  - types of Request handlers
//	@RequestMapping(value = "/fruits" , method = RequestMethod.GET)
//	@ResponseBody
	@GetMapping("/transactions")
	public List<Transactions> get() {
		return tService.getAll();
	}
/*
	@GetMapping("/transactions/{customer_id}")
	public List<Transactions> getCustomerTransactions(@PathVariable("customer_id") int  customer_id) {
		return tService.getCustomerTransactions(customer_id);
	}
	@GetMapping("/transactions/fruit/{fruit_id}")
	public List<Transactions> getfruitTransactions(@PathVariable("fruit_id") int fruit_id) {
		return tService.getFruitTransactions(fruit_id);
	}
	@GetMapping("/transactions/filterByCustomerAndFruit")
	public List<Transactions> getCustomerTransactionsOnFruit(@RequestParam String name,@RequestParam String customer) {
		return tService.getCustomerTransactionsOnFruit(name,customer);
	}

	@PostMapping("/fruit/buy")
	public String buy(@Validated @RequestBody Transactions tra) {
		return tService.buy(tra);
	}*/

	
}
