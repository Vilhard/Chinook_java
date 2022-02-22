package com.example.chinook_java_assignment.controller;

import com.example.chinook_java_assignment.data.service.CustomerRepository;
import com.example.chinook_java_assignment.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("api")
public class CustomerController {
    CustomerRepository customerRepository = new CustomerRepository();

    @GetMapping("customer")
    public Collection<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }
    @GetMapping("customer/id/{id}")
    Customer getCustomerById(@PathVariable String id) {
        return customerRepository.getCustomerById(id);
    }
    @GetMapping("customer/name/{name}")
        public Customer getCustomerByName(@PathVariable String name ) {
            return customerRepository.getCustomerByName(name);
        }
    @PostMapping("customer")
    public Customer addCustomer(Customer customer) {
    return null;
    }
    @GetMapping("customer/{limit}/{offset}")
    void getPageOfCustomers(@PathVariable String limit, @PathVariable String offset){

    }
}


