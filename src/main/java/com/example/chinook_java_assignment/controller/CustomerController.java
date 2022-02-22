package com.example.chinook_java_assignment.controller;

import com.example.chinook_java_assignment.data.service.CustomerRepositoryImpl;
import com.example.chinook_java_assignment.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api")
public class CustomerController {
    CustomerRepositoryImpl custRepoImpl = new CustomerRepositoryImpl();

    @GetMapping("customer")
    public Collection<Customer> getAllCustomers() {
        return custRepoImpl.getAllCustomers();
    }
    @GetMapping("customer/{customerId}")
    Customer getCustomerById(@PathVariable String customerId) {
        return null;
    }
    @GetMapping("customer/{customerName}")
        Customer getCustomerByName(@PathVariable String customerName) {
            return null;
        }
    @PostMapping("customer")
    public Customer addCustomer(Customer customer) {
    return null;
    }
    @GetMapping("customer/{limit}/{offset}")
    void getPageOfCustomers(@PathVariable String limit, @PathVariable String offset){

    }
}


