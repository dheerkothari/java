package com.example.demo.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.bean.CustomerBean;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;

@Component
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<CustomerBean> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();

		List<CustomerBean> customerBeans = new ArrayList<>();

		for (Customer customer : customers) {
			CustomerBean customerBean = new CustomerBean();
			BeanUtils.copyProperties(customer, customerBean);
			customerBeans.add(customerBean);
		}
		return customerBeans;
	}

	@Override
	public String saveCustomer(CustomerBean customerBean) {
		try {

			Customer customer = new Customer();
			BeanUtils.copyProperties(customerBean, customer);
			Customer response = customerRepository.save(customer);
			if (response != null) {
				return "Customer Insterted Successfully";
			} else {
				return "Error in Customer Insertion";
			}
		} catch (Exception e) {
			return "Error in Customer Insertion";
		}

	}

	@Override
	public String deleteCustomer(Long id) {
		try {
			customerRepository.deleteById(id);
		} catch (Exception e) {
			return "Error in Deleting Customer";
		}
		return "Customer Deleted Successfully";
	}

	@Override
	public String updateCustomer(CustomerBean customerBean) {
		Customer customer = customerRepository.getById(customerBean.getId());

		if (null != customer) {
			BeanUtils.copyProperties(customerBean, customer);
			Customer response = customerRepository.save(customer);
			if (null != response) {
				return "Customer updated Successfully";
			} else {
				return "Error in Customer updation";
			}
		} else {
			return "Error in Customer updation";
		}
	}

}
