package com.restapi.jsonschema.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.restapi.jsonschema.domain.Customer;
import com.restapi.jsonschema.domain.Fruit;
import com.restapi.jsonschema.domain.Student;
import com.restapi.jsonschema.domain.Transactions;
import com.restapi.jsonschema.services.CustomerService;
import com.restapi.jsonschema.services.FruitService;
import com.restapi.jsonschema.services.StudentService;
import com.restapi.jsonschema.services.TransactionsService;

@Controller
public class StudentController {
	
	@Autowired
    private FruitService service;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Fruit> listfruit = service.getFruits();
        model.addAttribute("listfruit", listfruit);
        System.out.print("Get / ");	
        return "index";
    }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("fruit", new Fruit());
        return "new";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("fruit") Fruit std) {
    	service.save(std);
        return "redirect:/";
    }

    @RequestMapping("/edit/{Id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "Id") Long Id) {
        ModelAndView mav = new ModelAndView("new");
        Fruit std = service.get(Id);
        mav.addObject("fruit", std);
        return mav;
        
    }
    @RequestMapping("/delete/{Id}")
    public String deletefruit(@PathVariable(name = "Id") Long Id) {
        service.delete(Id);
        return "redirect:/";
    }
    
    
    @Autowired
	private CustomerService cService;
    @GetMapping("/cus")
    public String viewHomePageCustomer(Model model) {
        List<Customer> listcustomer = cService.getCustomers();
        model.addAttribute("listcustomer", listcustomer);
        System.out.print("Get / ");	
        return "index1";
    }

    @GetMapping("/new1")
    public String addcus(Model model) {
        model.addAttribute("customer", new Customer());
        return "new1";
    }

    @RequestMapping(value = "/savecus", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("customer") Customer std) {
    	cService.save(std);
        return "redirect:/cus";
    }

    @RequestMapping("/editcus/{Id}")
    public ModelAndView showEditCustomerPage(@PathVariable(name = "Id") Long Id) {
        ModelAndView mav = new ModelAndView("new1");
        Customer std = cService.get(Id);
        mav.addObject("customer", std);
        return mav;
        
    }
    @RequestMapping("/deletecus/{Id}")
    public String deleteCustomer(@PathVariable(name = "Id") Long Id) {
    	cService.delete(Id);
        return "redirect:/cus";
    }
    
    
    @Autowired
    private TransactionsService tService;

    @GetMapping("/tra")
    public String viewHomePageTransaction(Model model) {
        List<Transactions> listtra = tService.getAll();
        model.addAttribute("listtra", listtra);
        System.out.print("Get / ");	
        return "index2";
    }
    
    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    public String buy(@ModelAttribute("transaction") Transactions std,RedirectAttributes redirAttrs) {
    	String trans=tService.buy(std);
    	redirAttrs.addFlashAttribute("message",trans);
        return "redirect:/tra";
    }    
    @GetMapping("/new2")
    public String addtra(Model model) {
        model.addAttribute("transactions", new Transactions());
        return "new2";
    }
    @GetMapping("/bycustomer")
    public String filterByCustomer(Model model) {
    	System.out.print("bycustomer");
        model.addAttribute("transactions", new Transactions());
        return "FilterByCustomer";
    }
    
    @RequestMapping(value = "/OkCustomer", method = RequestMethod.POST)
	public String getCustomerTransactions(@ModelAttribute("customer_id") Long customer_id,Model model) {
    	List<Transactions> listtra = tService.getCustomerTransactions(customer_id);
        model.addAttribute("listtra", listtra);
		return "index2";
	}
    @GetMapping("/byfruit")
    public String filterByFruit(Model model) {
        model.addAttribute("transactions", new Transactions());
        return "FilterByFruit";
    }
    
    @RequestMapping(value = "/OkFruit", method = RequestMethod.POST)
	public String getFruitTransactions(@ModelAttribute("fruit_id") Long fruit_id,Model model) {
    	List<Transactions> listtra = tService.getFruitTransactions(fruit_id);
        model.addAttribute("listtra", listtra);
		return "index2";
	}
    @GetMapping("/byboth")
    public String filterByBoth(Model model) {
        model.addAttribute("transactions", new Transactions());
        return "FilterByBoth";
    }
    
    @RequestMapping(value = "/OkBoth", method = RequestMethod.POST)
	public String getBothTransactions(@ModelAttribute("fruit_id") Long fruit_id,@ModelAttribute("customer_id") Long customer_id,Model model) {
    	List<Transactions> listtra = tService.getCustomerTransactionsOnFruit(customer_id,fruit_id);
        model.addAttribute("listtra", listtra);
		return "index2";
	}
    /*
	@GetMapping("/transactions/fruit/{fruit_id}")
	public List<Transactions> getfruitTransactions(@PathVariable("fruit_id") int fruit_id) {
		return tService.getFruitTransactions(fruit_id);
	}
	@GetMapping("/transactions/filterByCustomerAndFruit")
	public List<Transactions> getCustomerTransactionsOnFruit(@RequestParam String name,@RequestParam String customer) {
		return tService.getCustomerTransactionsOnFruit(name,customer);
	}*/

}