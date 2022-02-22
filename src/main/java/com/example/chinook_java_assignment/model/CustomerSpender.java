package com.example.chinook_java_assignment.model;

import java.util.HashMap;

public class CustomerSpender {

    public HashMap<Integer, Double> getCustomerSpendings() {
        return CustomerSpendings;
    }

    public void setCustomerSpendings(HashMap<Integer, Double> customerSpendings) {
        CustomerSpendings = customerSpendings;
    }


    HashMap<Integer, Double> CustomerSpendings = new HashMap<Integer, Double>();

    public void AddCustomerSpendings(int customerId, double spendings) {
        CustomerSpendings.put(customerId, spendings);
    }


}
