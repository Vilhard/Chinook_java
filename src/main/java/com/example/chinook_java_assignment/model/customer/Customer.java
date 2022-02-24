package com.example.chinook_java_assignment.model.customer;

public class Customer {
    public String CustomerId;
    public String FirstName;
    public String LastName;
    public String Country;
    public String PostalCode;
    public String Phone;
    public String Email;

    public Customer(String customerId, String firstName, String lastName, String country, String postalCode, String phone, String email) {
        CustomerId = customerId;
        FirstName = firstName;
        LastName = lastName;
        Country = country;
        PostalCode = postalCode;
        Phone = phone;
        Email = email;
    }
}