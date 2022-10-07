package com.br.API_REST_Customers.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.br.API_REST_Customers.document.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>{

}
