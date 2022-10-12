package com.br.API_REST_Customers.DTO;

import org.springframework.hateoas.RepresentationModel;

import com.br.API_REST_Customers.document.Order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO extends RepresentationModel<OrderDTO>{

	private String id;
	
	private Float value;
	
	private String date;
	
	private String createdBy;
	
	public OrderDTO(Order order) {
		this.id = order.getId();
		this.value = order.getValue();
		this.date = order.getDate();
		this.createdBy = order.getCreatedBy();
	}
	 
}
