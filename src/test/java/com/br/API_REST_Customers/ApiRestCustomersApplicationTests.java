package com.br.API_REST_Customers;



import com.br.API_REST_Customers.document.Customer;
import com.br.API_REST_Customers.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApiRestCustomersApplicationTests {

    @Autowired
    private CustomerRepository repository;


    @Test
    void findAllCustomers(){

        List<Customer> customers = repository.findAll();



    }

}
