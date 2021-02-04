package krd.antonov.rest;

import krd.antonov.entity.Customer;
import krd.antonov.rest.exception.CustomerNotFoundException;
import krd.antonov.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}