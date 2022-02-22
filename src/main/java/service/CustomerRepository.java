package service;

import model.Customer;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CustomerRepository  {
    Collection<Customer> getAllCustomers();
    Customer getCustomerById(Integer id);
    Customer getCustomerByName(String name);
    void getPageOfCustomers(Integer limit, Integer offset);
    void addCustomer(Customer customer);
}
