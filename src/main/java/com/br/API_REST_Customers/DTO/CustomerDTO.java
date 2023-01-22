package com.br.API_REST_Customers.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
	
	private List<OrderDTO> orders = new ArrayList<OrderDTO>();
	
	public CustomerDTO(Customer customer) {
		this.id = customer.getId();
		this.name = customer.getName();
		this.lastName = customer.getLastname();
		
		if(customer.getOrders() != null) {
			this.orders = customer.getOrders().stream().map(obj -> new OrderDTO(obj)).collect(Collectors.toList());
		}
	}
}
