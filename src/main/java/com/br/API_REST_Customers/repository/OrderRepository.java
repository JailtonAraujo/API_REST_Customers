package com.br.API_REST_Customers.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.API_REST_Customers.document.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String>{

	@Query(" { 'createdBy': ?0 } ")
	public List<Order> findAllByCustomerId (String id);
}
