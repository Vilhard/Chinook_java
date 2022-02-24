package com.example.chinook_java_assignment.data.service;

import com.example.chinook_java_assignment.data.ConnectionHelper;
import com.example.chinook_java_assignment.model.customer.Customer;
import com.example.chinook_java_assignment.model.customer.CustomerCountry;
import com.example.chinook_java_assignment.model.customer.CustomerGenre;
import com.example.chinook_java_assignment.model.customer.CustomerSpender;

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


    //Update an existing customer
    @Override
    public Customer updateCustomer(Customer customer) {
        Connection conn = ConnectionHelper.getInstance().getConnection();
        String query = "UPDATE Customer SET Firstname=?, LastName=?, Country=?, PostalCode=?, Phone=?, Email=? WHERE CustomerId = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, customer.FirstName);
            statement.setString(2, customer.LastName);
            statement.setString(3, customer.Country);
            statement.setString(4, customer.PostalCode);
            statement.setString(5, customer.Phone);
            statement.setString(6, customer.Email);
            statement.setString(7, customer.CustomerId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    //Return the number of customers in each country, ordered descending (high to low). i.e. USA: 13, …
    @Override
    public ArrayList<CustomerCountry> getNumberOfCustomersByCountry (){

        Connection conn = ConnectionHelper.getInstance().getConnection();
        ArrayList<CustomerCountry> customerNumbers = new ArrayList<CustomerCountry>();
        String query = "SELECT Country, COUNT(CustomerId) AS total FROM Customer GROUP BY Country ORDER BY total DESC" ;

        try{
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CustomerCountry customerCountry = new CustomerCountry(resultSet.getString("Country"),resultSet.getInt("Total"));
                customerNumbers.add(customerCountry);

            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return customerNumbers;
    }


    //Customers who are the highest spenders (total in invoice table is the largest), ordered descending

    @Override
    public CustomerSpender getTopSpendingCustomers() {
        Connection conn = ConnectionHelper.getInstance().getConnection();
        CustomerSpender customerSpender = new CustomerSpender();

        try{
            String query = "SELECT Customer.CustomerId, SUM(Invoice.Total) AS total FROM Customer, Invoice WHERE Customer.CustomerId = Invoice.CustomerId GROUP BY Customer.CustomerId ORDER BY total DESC";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                customerSpender.AddCustomerSpendings(resultSet.getInt("customerId"), resultSet.getDouble("total"));
            }


        } catch (SQLException e){
            e.printStackTrace();
        }


        return customerSpender;
    }


    //For a given customer, their most popular genre (in the case of a tie, display both). Most popular in this context
    //means the genre that corresponds to the most tracks from invoices associated to that customer.
    @Override
    public CustomerGenre getMostPopularGenreByCustomerId(String customerId){


        Connection conn = ConnectionHelper.getInstance().getConnection();
        CustomerGenre customerGenres = new CustomerGenre();
        ArrayList<Integer> customerGenreTotals = new ArrayList<Integer>();
        String query ="SELECT Genre.Name, COUNT(Genre.Name) AS amount FROM Customer, Invoice, InvoiceLine, Track, Genre WHERE Customer.CustomerId = Invoice.CustomerId AND Invoice.CustomerId = InvoiceLine.InvoiceId AND InvoiceLine.TrackId = Track.TrackId AND Track.GenreId = Genre.GenreId AND Customer.CustomerId = ? GROUP BY Genre.Name ORDER BY amount DESC";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, customerId);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                customerGenreTotals.add(resultSet.getInt("amount"));

                int maximum = customerGenreTotals.get(0);
                for (int i = 1; i < customerGenreTotals.size(); i++) {
                    if (maximum < customerGenreTotals.get(i))
                        maximum = customerGenreTotals.get(i);
                }
                if (maximum == resultSet.getInt("amount")) {
                    customerGenres.AddGenreTotal(resultSet.getString("Name"), resultSet.getInt("amount"));
                }
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return customerGenres;
    }

}