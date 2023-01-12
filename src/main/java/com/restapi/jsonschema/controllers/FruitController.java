package com.restapi.jsonschema.controllers;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.jsonschema.domain.Fruit;
import com.restapi.jsonschema.domain.Student;
import com.restapi.jsonschema.services.FruitService;

@RestController
public class FruitController {
	
    
	@Autowired
	private FruitService fService;
	
	//Start  - types of Request handlers
//	@RequestMapping(value = "/fruits" , method = RequestMethod.GET)
//	@ResponseBody
	@GetMapping("/fruits")
	public List<Fruit> getFruits() {
		return fService.getFruits();
	}

	@GetMapping("/fruit/{name}")
	public List<Fruit> getfruit(@PathVariable("name") String name) {
		return fService.getFruitDetail(name);
	}
	@PostMapping("/fruit/add")
	public Fruit savefruit(@Validated @RequestBody Fruit fruit) {
		return fService.addfruit(fruit);
		
	}
	@PutMapping("/fruit/{Id}")
	public Fruit Updatefruit(@PathVariable Long id , @RequestBody Fruit fruit) {
		fruit.setId(id);
		return fService.updatefruit(fruit);
	}
	@DeleteMapping("/fruit")
	public void deletefruit(@RequestParam("name") String name) {
		fService.deletefruit(name);
	}
}

