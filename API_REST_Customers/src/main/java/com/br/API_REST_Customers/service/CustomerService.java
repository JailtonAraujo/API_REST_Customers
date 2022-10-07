package com.br.API_REST_Customers.service;

import java.util.List;
import java.util.Optional;

import com.br.API_REST_Customers.document.Customer;

public interface CustomerService {

	public Customer save (Customer customer);
	
	public Optional<Customer> findById (String id);
	
	public List<Customer> findAll ();
	
	public void deleteById (String id);
}
