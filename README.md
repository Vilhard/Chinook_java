# Chinook_java

Database access tool
C# console application used to interface with the "Chinook" SQLExpress database.
To use this, change customerRepo into your own data source.
The console application can be used to choose different operations that call the correct methods:

- display all customers
- display specific customer by ID
- read specific customer by name. accepts partial matches.
- display a limited amount of customers starting from point of choice
- add new customer
- update data of a customer of choice.
- display top countries by customer count
- displays top spenders among all customers
- displays the top genre choice of a specific customer by ID



The are multiple methods you can call:


- display all customers ```GetAllCustomers()``` returns a list of Customer objects
- display specific customer by ID  ```GetCustomerById(String id)``` returns specific Customer object
- read specific customer by name. accepts partial matches. ```GetCustomerByName(String Name)``` returns Customer object
- display a limited amount of customers starting from point of choice ```GetPageOfCustomers(Integer limit, Integer offset)``` returns a list of Customer objects
- add new customer. ```AddCustomer(Customer newCustomer)``` returns Customer object
- update data of a customer of choice. ```UpdateCustomer(Customer customer)```
- display top countries by customer count ```GetNumberOfCustomersByCountry()``` returns a list of CustomerCountry objects
- displays top spenders among all customers ```GetToptSpendingCustomers()``` returns a CustomerSpender object
- displays the top genre choice of a specific customer by ID. ```GetMostPopularGenreByCustomerId(String customerId)``` returns CustomerGenre object
