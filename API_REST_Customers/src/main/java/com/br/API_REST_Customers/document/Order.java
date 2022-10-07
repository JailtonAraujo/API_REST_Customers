package com.br.API_REST_Customers.document;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "order")
public class Order {
	
	private String id;
	
	private Float value;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate date;
	
}
