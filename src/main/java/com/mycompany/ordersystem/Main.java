package com.mycompany.ordersystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CustomerService customerService = context.getBean("customerService", CustomerService.class);
        List<Customer> customers = customerService.getCustomers();
        for (Customer customer : customers)
            System.out.println(customer);
        Customer newCustomer = new Customer();
        newCustomer.setId(6);
        newCustomer.setName("김육");
        newCustomer.setAddress("마포구");
        newCustomer.setEmail("kim6@gmail.com");
        customerService.saveCustomer(newCustomer);
        Customer customer6 = customerService.getCustomer(6);
        System.out.println(customer6);

        Customer nnewCustomer = new Customer();
        nnewCustomer.setId(7);
        nnewCustomer.setName("김칠");
        nnewCustomer.setAddress("서대문구");
        nnewCustomer.setEmail("kim7@gmail.com");
        customerService.saveCustomer(nnewCustomer);
        Customer customer7 = customerService.getCustomer(7);
        System.out.println(customer7);

        Customer mableCustomer = new Customer();
        mableCustomer.setId(8);
        mableCustomer.setName("김팔");
        mableCustomer.setAddress("연제구");
        mableCustomer.setEmail("kim8@gmail.com");
        customerService.saveCustomer(mableCustomer);
        Customer customer8 = customerService.getCustomer(8);
        System.out.println(customer8);

        Customer superCustomer = new Customer();
        superCustomer.setId(9);
        superCustomer.setName("김구");
        superCustomer.setAddress("금천구");
        superCustomer.setEmail("kim9@gmail.com");
        customerService.saveCustomer(superCustomer);
        Customer customer9 = customerService.getCustomer(9);
        System.out.println(customer9);

        customerService.deleteCustomer(1);
        List<Customer> customerList = customerService.getCustomers();
        for(Customer customer : customerList)
            System.out.println(customer);




    }
}
