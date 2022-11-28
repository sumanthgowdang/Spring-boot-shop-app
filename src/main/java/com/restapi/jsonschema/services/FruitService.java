package com.restapi.jsonschema.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.restapi.jsonschema.Repository.FruitRepository;
import com.restapi.jsonschema.Repository.StudentRepository;
import com.restapi.jsonschema.domain.Fruit;
import com.restapi.jsonschema.domain.Student;



@Service
public class FruitService {
	@Autowired
	private FruitRepository fRepository;
	
	public List<Fruit> getFruits() {
		// TODO Auto-generated method stub
		return (List<Fruit>) fRepository.findAll();
	}
	
	public List<Fruit> getFruitDetail(String name) {
		// TODO Auto-generated method stub
		return (List<Fruit>) fRepository.findByName(name);
	}
	public Fruit addfruit(@Validated Fruit fruit) {
		// TODO Auto-generated method stub
		return fRepository.save(fruit);
	}
	public Fruit updatefruit(Fruit fruit) {
		// TODO Auto-generated method stub
		return fRepository.save(fruit);
	}
	public void deletefruit(String name) {
		// TODO Auto-generated method stub
		fRepository.deleteUsersByName(name);
		
	}
	public List<Fruit> listAll() {
        return fRepository.findAll();
    }
     
    public void save(Fruit std) {
    	fRepository.save(std);
    }
     
    public Fruit get(Long Id) {
        return  fRepository.findById(Id).get();
    }
     
    public void delete(Long Id) {
    	fRepository.deleteById(Id);
    }

}

