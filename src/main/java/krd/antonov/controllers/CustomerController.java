package krd.antonov.controllers;

import krd.antonov.entity.Customer;
import krd.antonov.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.getCustomers());
        return "list-customers";
    }

    @GetMapping("/addCustomer")
    public String addCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/";
    }

    @GetMapping("/updateCustomer")
    public String updateCustomer(@RequestParam("customerId") Long id, Model model) {
        Customer customer = customerService.getCustomer(id);
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId") Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/";
    }
}
