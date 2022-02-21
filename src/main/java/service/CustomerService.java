package service;

import dao.CustomerDao;
import model.Customer;

import java.util.List;

public class CustomerService implements CustomerDao {
    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public void getCustomerById(Integer id) {

    }

    @Override
    public void getCustomerByName(String name) {

    }

    @Override
    public void getPageOfCustomers(Integer limit, Integer offset) {

    }

    @Override
    public void addCustomer(Customer customer) {

    }
}
