package com.br.API_REST_Customers.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.br.API_REST_Customers.document.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String>{

}
