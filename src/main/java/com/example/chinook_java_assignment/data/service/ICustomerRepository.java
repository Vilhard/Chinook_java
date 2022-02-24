package com.example.chinook_java_assignment.data.service;

import com.example.chinook_java_assignment.model.customer.Customer;
import com.example.chinook_java_assignment.model.customer.CustomerCountry;
import com.example.chinook_java_assignment.model.customer.CustomerGenre;
import com.example.chinook_java_assignment.model.customer.CustomerSpender;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ICustomerRepository {
    Collection<Customer> getAllCustomers();
    Customer getCustomerById(String customerId);
    Customer getCustomerByName(String customerName);
    List<Customer> getPageOfCustomers(Integer limit, Integer offset);
    Customer addCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    List<CustomerCountry> getNumberOfCustomersByCountry ();
    CustomerSpender getTopSpendingCustomers();
    CustomerGenre getMostPopularGenreByCustomerId(String customerId);
}
