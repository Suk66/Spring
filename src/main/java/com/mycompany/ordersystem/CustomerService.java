package com.mycompany.ordersystem;

import java.util.List;

public interface CustomerService {

    Customer getCustomer(long id);
    List<Customer> getCustomers();
    List<Customer> getCustomerByName(String name);

    void saveCustomer(Customer customer);

    void deleteCustomer(Customer customer);

}
