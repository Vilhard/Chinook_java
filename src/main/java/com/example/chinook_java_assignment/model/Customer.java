package com.example.chinook_java_assignment.model;

public record Customer(Integer CustomerId, String FirstName, String LastName, String Country, String PostalCode, String Phone, String Email) {
    public Customer(Integer CustomerId, String FirstName, String LastName, String Country, String PostalCode,
                    String Phone, String Email) {
        this.CustomerId = CustomerId;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Country = Country;
        this.PostalCode = PostalCode;
        this.Phone = Phone;
        this.Email = Email;
    }
    public Integer CustomerId() {return this.CustomerId;}
    public String FirstName() {return this.FirstName;}
    public String LastName() {return this.LastName;}
    public String Country() {return this.Country;}
    public String PostalCode() {return this.PostalCode;}
    public String Phone() {return this.Phone;}
    public String Email() {return this.Email;}

}
