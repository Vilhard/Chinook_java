package data.service;

import model.Customer;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CustomerRepository  {
    Collection<Customer> getAllCustomers();
    Customer getCustomerById(String customerId);
    Customer getCustomerByName(String customerName);
    void getPageOfCustomers(String limit, String offset);
    Customer addCustomer(Customer customer);
}
