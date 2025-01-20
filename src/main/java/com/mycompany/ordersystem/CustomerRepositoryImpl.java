package com.mycompany.ordersystem;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    private List<Customer> customers;

    public CustomerRepositoryImpl() {
        customers = new ArrayList<>();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("김일");
        customer.setAddress("서울시");
        customer.setEmail("kim1@gmail.com");
        customers.add(customer);

        Customer customer2 = new Customer();
        customer.setId(1);
        customer.setName("김이");
        customer.setAddress("대전시");
        customer.setEmail("kim2@gmail.com");
        customers.add(customer2);

        Customer customer3 = new Customer();
        customer.setId(1);
        customer.setName("김삼");
        customer.setAddress("대구시");
        customer.setEmail("kim3@gmail.com");
        customers.add(customer3);

        Customer customer4 = new Customer();
        customer.setId(1);
        customer.setName("김사");
        customer.setAddress("부산시");
        customer.setEmail("kim4@gmail.com");
        customers.add(customer4);

        Customer customer5 = new Customer();
        customer.setId(1);
        customer.setName("김오");
        customer.setAddress("제주시");
        customer.setEmail("kim5@gmail.com");
        customers.add(customer5);
    }

    @Override
    public Customer findById(long id) {
        for(Customer customer: customers) {
            if(customer.getId() == id)
                return customer;
        }
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> list = new ArrayList<>();
        for(Customer customer : customers) {
            if(customer.getName().equals(name)) {
                Customer cust = new Customer();
                cust.setId(customer.getId());
                cust.setName(customer.getName());
                cust.setAddress(customer.getAddress());
                cust.setEmail(customer.getEmail());
                list.add(customer);
            }
        }
        return list;
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void delete(long id) {

    }
}
