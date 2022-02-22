package com.example.chinook_java_assignment.data.service;

import com.example.chinook_java_assignment.data.ConnectionHelper;
import com.example.chinook_java_assignment.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public Collection<Customer> getAllCustomers() {
        Collection<Customer> customers = new ArrayList<>();
        try {
            Connection conn = ConnectionHelper.getInstance().getConnection();
            String query = "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email  FROM Customer";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer(resultSet.getInt("customerId"),resultSet.getString("FirstName"), resultSet.getString("LastName"),
                        resultSet.getString("Country"), resultSet.getString("PostalCode"), resultSet.getString("Phone"), resultSet.getString("Email"));
                customers.add(customer);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer getCustomerById(String customerId) {
        return null;
    }

    @Override
    public Customer getCustomerByName(String customerName) {
        Connection conn = ConnectionHelper.getInstance().getConnection();
        String query = "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email  FROM Customer WHERE FirstName = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, customerName);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                //map to dto and return
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void getPageOfCustomers(String limit, String offset) {

    }

    @Override
    public Customer addCustomer(Customer customer) {
        return null;
    }
}