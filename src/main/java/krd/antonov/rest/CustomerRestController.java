package krd.antonov.rest;

import krd.antonov.entity.Customer;
import krd.antonov.rest.exception.CustomerNotFoundException;
import krd.antonov.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private CustomerService customerService;

    @Autowired
    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerID}")
    public Customer getCustomer(@PathVariable long customerID) {
        Customer customer = customerService.getCustomer(customerID);
        if (customer == null)
            throw new CustomerNotFoundException("Customer id not found - " + customerID);
        return customer;
    }

    @RequestMapping(value = "/customers", method = {RequestMethod.POST, RequestMethod.PUT})
    public Customer addOrUpdateCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable long customerId) {
        if (customerService.getCustomer(customerId) == null)
            throw new CustomerNotFoundException("Customer id not found - " + customerId);
        customerService.deleteCustomer(customerId);
        return "Deleted customer id - " + customerId;
    }
}
