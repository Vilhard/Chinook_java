package com.example.chinook_java_assignment.data.service;

import com.example.chinook_java_assignment.model.Customer;
import com.example.chinook_java_assignment.model.CustomerCountry;
import com.example.chinook_java_assignment.model.CustomerGenre;
import com.example.chinook_java_assignment.model.CustomerSpender;
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
    void updateCustomer(Customer customer);
    List<CustomerCountry> getNumberOfCustomersByCountry ();
    CustomerSpender getTopSpendingCustomers();
    CustomerGenre GetMostPopularGenreByCustomerId(int customerId);
}
