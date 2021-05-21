package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.CustomerBean;
import com.example.demo.bean.CustomerResponseBean;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping(path = "/customers")
	public CustomerResponseBean getAllCustomers() {
		CustomerResponseBean customerResponseBean = new CustomerResponseBean();
		customerResponseBean.setCustomers(customerService.getAllCustomers());
		return customerResponseBean;

	}

	@PostMapping(path = "/customers")
	public HashMap<String, String> addCustomer(@RequestBody CustomerBean customerBean) {

		HashMap<String, String> response = new HashMap<>();
		response.put("response", customerService.saveCustomer(customerBean));

		return response;

	}

	@DeleteMapping(path = "/customers/{id}")
	public HashMap<String, String> deleteCustomer(@PathVariable(name = "id", required = true) Long id) {

		HashMap<String, String> response = new HashMap<>();
		response.put("response", customerService.deleteCustomer(id));

		return response;
	}

	@PutMapping(path = "/customers")
	public HashMap<String, String> updateCustomer(@RequestBody CustomerBean customerBean) {

		HashMap<String, String> response = new HashMap<>();
		response.put("response", customerService.updateCustomer(customerBean));

		return response;
	}

}
