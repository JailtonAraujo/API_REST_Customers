package com.br.API_REST_Customers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.br.API_REST_Customers.document.Customer;
import com.br.API_REST_Customers.repository.CustomerRepository;
import com.mongodb.internal.operation.AggregateOperation;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	MongoTemplate mongoTemplate;

	
	@Override
	public Customer save(Customer customer) {
		
		return this.customerRepository.save(customer);
	}


	@Override
	public Optional<Customer> findById(String id) {
		
		LookupOperation lookupOperation = LookupOperation.newLookup()
				.from("order")
				.localField("ObjectId('_id')")
				.foreignField("ObjectId('createdBy')")
				.as("orders");
		
		MatchOperation match = Aggregation.match( Criteria.where("_id").is(id));
		
		
		Aggregation aggregation = Aggregation.newAggregation(lookupOperation,match);
		
		Optional<Customer> optional = Optional.of( this.mongoTemplate.aggregate(aggregation, "customer", Customer.class).getUniqueMappedResult());
		
		return optional;
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
