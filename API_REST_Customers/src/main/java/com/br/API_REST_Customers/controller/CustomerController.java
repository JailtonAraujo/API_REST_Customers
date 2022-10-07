package com.br.API_REST_Customers.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.LinkRelation;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.API_REST_Customers.DTO.CustomerDTO;
import com.br.API_REST_Customers.document.Customer;
import com.br.API_REST_Customers.service.CustomerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@PostMapping(value = "/")
	public ResponseEntity<CustomerDTO> save ( @RequestBody Customer customer ){
		
		CustomerDTO dto = new CustomerDTO(
				this.customerService.save(customer));
		
		dto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class).findById(dto.getId())).withSelfRel());
		
		dto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class).findAll()).withRel("Customers_list"));
		
		dto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class).deleteById(dto.getId())).withRel("link_delete"));
		
		return ResponseEntity.ok(dto);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CustomerDTO> findById( @PathVariable(name = "id") String id ){
		
		Optional<Customer> optional = this.customerService.findById(id);
		
		if(optional.isPresent()) {
			
			CustomerDTO dto = new CustomerDTO(optional.get());
			
			dto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class).findById(dto.getId())).withSelfRel());
			
			dto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class).findAll()).withRel("Customers list"));
			
			dto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class).deleteById(dto.getId())).withRel("link_delete"));
			
			return ResponseEntity.ok(dto);
		}
		
		return new ResponseEntity<CustomerDTO>(HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping(value = "/")
	public ResponseEntity<CollectionModel<CustomerDTO>> findAll(){
		
		List<Customer> customers = this.customerService.findAll();
		
		if(customers.size() > 0) {
			
			List<CustomerDTO> dtos = customers.stream().map(obj -> new CustomerDTO(obj)).collect(Collectors.toList());
			
			dtos.forEach(element -> 
				element.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class).findById(element.getId())).withSelfRel())
			);
			
			
			return ResponseEntity.ok(CollectionModel.of(dtos));
		}
		
		return new ResponseEntity<CollectionModel<CustomerDTO>>(HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Customer> deleteById ( @PathVariable(name = "id") String id ) {
		
		this.customerService.deleteById(id);
		
		return new ResponseEntity<Customer>(HttpStatus.OK);
		
	}
	
}
