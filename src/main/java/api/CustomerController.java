package api;

import model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api")
public class CustomerController {
    @GetMapping("customer/{customerId")
    public Collection<Customer> getAllCustomers() {
        return null;
    }
    @GetMapping("customer/{customerId")
    Customer getCustomerById(@PathVariable String customerId) {
        return null;
    }
    @GetMapping("customer/{customerName}")
        Customer getCustomerByName(@PathVariable String customerName) {
            return null;
        }
    @PostMapping("customer")
    public Customer addCustomer(Customer customer) {
    return null;
    }
    @GetMapping("customer/{limit}/{offset}")
    void getPageOfCustomers(@PathVariable String limit, @PathVariable String offset){

    }
}


