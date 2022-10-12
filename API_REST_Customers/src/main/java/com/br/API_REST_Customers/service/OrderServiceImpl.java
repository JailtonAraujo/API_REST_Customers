package com.br.API_REST_Customers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.API_REST_Customers.document.Order;
import com.br.API_REST_Customers.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public Order save(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public List<Order> findAllByCustomerId(String id) {
		
		return orderRepository.findAllByCustomerId(id);
	}

	@Override
	public Optional<Order> findById(String id) {
		return orderRepository.findById(id);
	}

	@Override
	public List<Order> findAll() {
		
		return orderRepository.findAll();
	}

}
