package com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdemo.entity.Customer;
import com.springdemo.services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String listCustmors(Model theModel) {
		List<Customer> customers = customerService.getCustomers();
		theModel.addAttribute("customers",customers);
		//System.out.println(theModel);
		return "list-customers";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model theModel) {
		Customer customer = new Customer();
		theModel.addAttribute("customer",customer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("customerId") int theId,Model theModel) {
		//System.out.println("update");
		Customer theCustomer = customerService.getCustomer(theId);
		theModel.addAttribute("customer",theCustomer);
		return "customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		//System.out.println("delete");
		Customer theCustomer = customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
}
