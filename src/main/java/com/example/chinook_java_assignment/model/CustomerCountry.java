package com.example.chinook_java_assignment.model;

public class CustomerCountry {

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public String Name;
    public int Count;


    public CustomerCountry(String name, int count){
        Name = name;
        Count = count;
    }


}
