package com.br.API_REST_Customers.document;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "order")
public class Order implements  Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	private Float value;
	
	private String date;

	private String createdBy;
	
}
