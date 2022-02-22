package com.example.chinook_java_assignment.model;

public class Customer {
    public Integer CustomerId;
    public String FirstName;
    public String LastName;
    public String Country;
    public String PostalCode;
    public String Phone;
    public String Email;

    public Customer(Integer customerId, String firstName, String lastName, String country, String postalCode, String phone, String email) {
        CustomerId = customerId;
        FirstName = firstName;
        LastName = lastName;
        Country = country;
        PostalCode = postalCode;
        Phone = phone;
        Email = email;
    }
}