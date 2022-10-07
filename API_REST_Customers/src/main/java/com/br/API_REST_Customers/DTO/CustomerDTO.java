package com.br.API_REST_Customers.DTO;

import org.springframework.hateoas.RepresentationModel;

import com.br.API_REST_Customers.document.Customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO extends RepresentationModel<CustomerDTO>{

	private String id;
	
	private String name;
	
	private String lastName;
	
	public CustomerDTO(Customer customer) {
		this.id = customer.getId();
		this.name = customer.getName();
		this.lastName = customer.getLastname();
	}
}
