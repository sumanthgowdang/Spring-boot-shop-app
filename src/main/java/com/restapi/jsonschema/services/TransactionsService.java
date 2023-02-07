package com.restapi.jsonschema.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
import com.restapi.jsonschema.Repository.FruitRepository;
import com.restapi.jsonschema.Repository.TransactionsRepository;
import com.restapi.jsonschema.domain.Customer;
import com.restapi.jsonschema.domain.Fruit;
import com.restapi.jsonschema.domain.Transactions;
@Service
public class TransactionsService {
	@Autowired
	private TransactionsRepository trans;
	@Autowired
	private FruitRepository fRepository;
	@Autowired
	private CustomerRepository cRepository;

	public List<Transactions> getAll() {
		// TODO Auto-generated method stub
		return trans.findAll();
	}
	
	public List<Transactions> getMy(String name) {
		// TODO Auto-generated method stub
		return trans.findBycustomer_name(name);
	}

	public List<Transactions> getCustomerTransactions(Long customer_id) {
		// TODO Auto-generated method stub
		return trans.findBycustomer_id(customer_id);
	}

	public List<Transactions> getFruitTransactions(Long fruit_id) {
		// TODO Auto-generated method stub
		return trans.findByfruit_id(fruit_id);
	}

	public String buy(Transactions tra) {
		// TODO Auto-generated method stub
		Fruit fruit=fRepository.getByName(tra.getName());
		if(fruit!=null) {
		Customer customer=cRepository.getByName(tra.getCustomer());
		tra.setCustomer_id(customer.getId());
		tra.setFruit_id(fruit.getId());
		if(fruit.getQuantity()>=tra.getQuantity()) {
			tra.setStatus(1);
			fruit.setQuantity(fruit.getQuantity()-tra.getQuantity());
			fruit.setId(tra.getFruit_id());
			tra.setCost(fruit.getPrice()*tra.getQuantity());
			tra.setDate(new Date());
			fRepository.save(fruit);
			trans.save(tra);
			return "Transaction Successful . your Bill amount is Rs"+tra.getCost();
		}
		else {
			tra.setStatus(2);
			return "quantity is less,Transaction is UnSuccessful";
		}
		}
		else {
		tra.setStatus(3);
		return "sorry "+tra.getName()+" fruit is not present please see the fruit details"; 
		}
		
	}

	public List<Transactions> getCustomerTransactionsOnFruit(Long customer_id, Long fruit_id) {
		// TODO Auto-generated method stub
		return trans.findBycustomer_idAndfruit_id(customer_id,fruit_id);
	}	

}
