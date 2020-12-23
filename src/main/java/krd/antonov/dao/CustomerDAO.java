package krd.antonov.dao;

import krd.antonov.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(Long id);

    void deleteCustomer(Long id);
}
