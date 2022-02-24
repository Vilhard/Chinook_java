package com.example.chinook_java_assignment.controller;

import com.example.chinook_java_assignment.data.service.CustomerRepository;
import com.example.chinook_java_assignment.data.service.MusicRepository;
import com.example.chinook_java_assignment.model.customer.Customer;
import com.example.chinook_java_assignment.model.customer.CustomerCountry;
import com.example.chinook_java_assignment.model.customer.CustomerGenre;
import com.example.chinook_java_assignment.model.customer.CustomerSpender;
import com.example.chinook_java_assignment.model.music.Artist;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerRepository.addCustomer(customer);
    }
    @GetMapping("customer/limit/{limit}/offset/{offset}")
    public List<Customer> getPageOfCustomers(@PathVariable Integer limit, @PathVariable Integer offset){
        return customerRepository.getPageOfCustomers(limit, offset);
    }

    @PutMapping("customer")
    public Customer updateCustomer(@RequestBody Customer customer) {return customerRepository.updateCustomer(customer);}

    @GetMapping("statistics/customers")
    public ArrayList<CustomerCountry> getNumberOfCustomersByCountry() {return customerRepository.getNumberOfCustomersByCountry();}

    @GetMapping("statistics/spending")
    public CustomerSpender getTopSpendingCustomers() {return customerRepository.getTopSpendingCustomers();}

    @GetMapping("customer/favorite/{id}")
    public CustomerGenre getMostPopularGenreByCustomerId(@PathVariable String id) {return customerRepository.getMostPopularGenreByCustomerId(id);}

}


