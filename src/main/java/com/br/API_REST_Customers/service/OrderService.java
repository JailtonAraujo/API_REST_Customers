package com.br.API_REST_Customers.service;

import java.util.List;
import java.util.Optional;

import com.br.API_REST_Customers.document.Order;

public interface OrderService {
	
	public Order save (Order order);
	
	public List<Order> findAllByCustomerId (String id);
	
	public Optional<Order> findById(String id);
	
	public List<Order> findAll();
	
	public void deleteById(String id);
}
