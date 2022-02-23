package com.example.chinook_java_assignment.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class CustomerSpender {

    public ArrayList<CustomerSpendings> getCustomerSpendings() {
        return CustomerSpendings;
    }

    public void setCustomerSpendings(ArrayList<CustomerSpendings> customerSpendings) {
        CustomerSpendings = customerSpendings;
    }


    ArrayList<CustomerSpendings> CustomerSpendings = new ArrayList<CustomerSpendings>();

    public void AddCustomerSpendings(int customerId, double spendings) {
        CustomerSpendings customerSpendings = new CustomerSpendings(customerId, spendings);
        CustomerSpendings.add(customerSpendings);
    }

    public static class CustomerSpendings {
        public int customerId;
        public double spendings;

        CustomerSpendings(int id, double spending) {
            customerId = id;
            spendings = spending;
        }
    }


}
