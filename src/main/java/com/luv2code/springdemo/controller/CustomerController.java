package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import com.luv2code.springdemo.utils.SortUtil;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String list(@RequestParam(name="sort", required = false) String sort, Model model) {

		List<Customer> customers = null;
		
		int sortField = null != sort ? Integer.parseInt(sort) : SortUtil.FIRST_NAME;
		
		customers = customerService.getCustomers(sortField);

		model.addAttribute("customers", customers);

		return "customer-list";
	}

	@GetMapping("/search")
	public String search(@RequestParam(name="filter", required = false) String filter, Model model) {

		List<Customer> customers = null;
				
		customers = customerService.searchCustomers(filter);

		model.addAttribute("customers", customers);
		model.addAttribute("filter", filter);

		return "customer-list";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer-form";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/{customerId}/edit")
	public String edit(@PathVariable("customerId") int id, Model model) {
		Customer customer = customerService.getCustomer(id);
		
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@GetMapping("/{customerId}/delete")
	public String delete(@PathVariable("customerId") int id) {		
		customerService.deleteCustomer(id);
		
		return "redirect:/customer/list";
	}
}
