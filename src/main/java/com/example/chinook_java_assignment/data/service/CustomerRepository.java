package com.example.chinook_java_assignment.data.service;

import com.example.chinook_java_assignment.data.ConnectionHelper;
import com.example.chinook_java_assignment.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {

    @Override
    public Collection<Customer> getAllCustomers() {
        Collection<Customer> customers = new ArrayList<>();
        try {
            Connection conn = ConnectionHelper.getInstance().getConnection();
            String query = "SELECT * FROM Customer";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer(resultSet.getString("customerId"),resultSet.getString("FirstName"), resultSet.getString("LastName"),
                        resultSet.getString("Country"), resultSet.getString("PostalCode"), resultSet.getString("Phone"), resultSet.getString("Email"));
                customers.add(customer);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer getCustomerById(String id) {
        Customer customer = null;
        Connection conn = ConnectionHelper.getInstance().getConnection();
        String query = "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email  FROM Customer WHERE customerId = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer(resultSet.getString("customerId"),resultSet.getString("FirstName"), resultSet.getString("LastName"),
                        resultSet.getString("Country"), resultSet.getString("PostalCode"), resultSet.getString("Phone"), resultSet.getString("Email"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public Customer getCustomerByName(String name) {
        Customer customer = null;
        Connection conn = ConnectionHelper.getInstance().getConnection();
        String query = "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email  FROM Customer WHERE FirstName LIKE ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, name + '%');
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
               customer = new Customer(resultSet.getString("customerId"),resultSet.getString("FirstName"), resultSet.getString("LastName"),
                        resultSet.getString("Country"), resultSet.getString("PostalCode"), resultSet.getString("Phone"), resultSet.getString("Email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Customer> getPageOfCustomers(Integer limit, Integer offset) {
        List<Customer> customers = new ArrayList<>();
        Connection conn = ConnectionHelper.getInstance().getConnection();
        String query = "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email  FROM Customer LIMIT ? OFFSET ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, limit);
            statement.setInt(2, offset);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer(resultSet.getString("customerId"),resultSet.getString("FirstName"), resultSet.getString("LastName"),
                        resultSet.getString("Country"), resultSet.getString("PostalCode"), resultSet.getString("Phone"), resultSet.getString("Email"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer addCustomer(Customer newCustomer) {
        Connection conn = ConnectionHelper.getInstance().getConnection();
        String query = "INSERT INTO Customer (CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, newCustomer.CustomerId);
            statement.setString(2,newCustomer.FirstName);
            statement.setString(3,newCustomer.LastName);
            statement.setString(4,newCustomer.Country);
            statement.setString(5,newCustomer.PostalCode);
            statement.setString(6,newCustomer.Phone);
            statement.setString(7,newCustomer.Email);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newCustomer;
    }
}