package com.br.API_REST_Customers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.API_REST_Customers.document.Customer;
import com.br.API_REST_Customers.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	
	
	@Override
	public Customer save(Customer customer) {
		
		return this.customerRepository.save(customer);
	}


	@Override
	public Optional<Customer> findById(String id) {
		return this.customerRepository.findById(id);
	}


	@Override
	public List<Customer> findAll() {
		return this.customerRepository.findAll();
	}


	@Override
	public void deleteById(String id) {
		this.customerRepository.deleteById(id);
		
	}

	
}
