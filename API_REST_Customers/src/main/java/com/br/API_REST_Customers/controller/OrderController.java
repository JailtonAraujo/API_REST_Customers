package com.br.API_REST_Customers.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.API_REST_Customers.DTO.OrderDTO;
import com.br.API_REST_Customers.document.Order;
import com.br.API_REST_Customers.repository.OrderRepository;
import com.br.API_REST_Customers.service.OrderService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderRepository repository;
	
	@Autowired
	OrderService orderService;
	
	@PostMapping(value = "/")
	public ResponseEntity<OrderDTO> save (@RequestBody Order order ){
		
		OrderDTO dto = new OrderDTO(this.orderService.save(order));
		
		return new ResponseEntity<OrderDTO>( dto ,HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OrderDTO> findById ( @PathVariable(name = "id") String id ){
		
			Optional<Order> optional = this.orderService.findById(id);
		
		if(optional.isPresent()) {
			
			OrderDTO dto = new OrderDTO(optional.get());
			
			dto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OrderController.class).findById(id)).withSelfRel());
			
			dto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OrderController.class).findAll()).withRel("Order list!"));
			
			return ResponseEntity.ok(dto);
		}
		
		return new ResponseEntity<OrderDTO>(HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping(value = "/")
	public ResponseEntity<CollectionModel<OrderDTO>> findAll (){
		
		
		List<Order> orders = this.orderService.findAll();
		
		if(orders.size() > 0) {
			
			List<OrderDTO> dtos = orders.stream().map(order ->  new OrderDTO(order)).collect(Collectors.toList());
			
			dtos.forEach(dto -> 
			
				dto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OrderController.class).findById(dto.getId())).withSelfRel())
			
			);
			
			return ResponseEntity.ok(CollectionModel.of(dtos));
			
		}
		
		return new ResponseEntity<CollectionModel<OrderDTO>>(HttpStatus.NOT_FOUND);
		
	}
	
}
