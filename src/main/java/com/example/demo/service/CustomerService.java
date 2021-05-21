package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.bean.CustomerBean;

@Service
public interface CustomerService {

	List<CustomerBean> getAllCustomers();
	
	String saveCustomer(CustomerBean customerBean);
	
	String deleteCustomer(Long id);
	
	String updateCustomer(CustomerBean customerBean);

}
