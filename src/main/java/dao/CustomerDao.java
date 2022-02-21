package dao;

import model.Customer;

import java.util.List;

public interface CustomerDao {
    //1 - 5
    List<Customer> getAllCustomers();
    void getCustomerById(Integer id);
    void getCustomerByName(String name);
    void getPageOfCustomers(Integer limit, Integer offset);
    void addCustomer(Customer customer);
}
