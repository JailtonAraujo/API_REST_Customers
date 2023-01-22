package com.br.API_REST_Customers.document;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "customer")
public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	private String name;
	
	private String lastname;
	
	private List<Order> orders;
	
}
