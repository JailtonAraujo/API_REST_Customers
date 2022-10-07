package com.br.API_REST_Customers.document;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

@Data
@Document(collection = "customer")
public class Customer {

	@MongoId
	private String id;
	
	private String name;
	
	private String lastname;
}
