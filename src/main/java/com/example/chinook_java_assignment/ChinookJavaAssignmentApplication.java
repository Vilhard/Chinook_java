package com.example.chinook_java_assignment;

import datasource.ConnectionBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class ChinookJavaAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChinookJavaAssignmentApplication.class, args);
        Connection conn = ConnectionBuilder.getInstance().getConnection();

       try {
                PreparedStatement preparedStatement = conn.prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email  FROM Customer");
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()){
                    String CustomerId = resultSet.getString("CustomerID");
                    String CustomerName = resultSet.getString("FirstName");
                    String CustomerTitle = resultSet.getString("LastName");
                    String CustomerCountry = resultSet.getString("Country");
                    String CustomerPostalCode = resultSet.getString("PostalCode");
                    String CustomerPhone = resultSet.getString("Phone");
                    String CustomerEmail = resultSet.getString("Email");
                    System.out.printf("Customer {%s, %s, %s}", CustomerId, CustomerName, CustomerTitle, CustomerCountry,
                            CustomerPostalCode, CustomerPhone, CustomerEmail);
                }
           conn.close();
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            System.exit(-1);
        }
    }

}

//@NotNull = No empty parameters
