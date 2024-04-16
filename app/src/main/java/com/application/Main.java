package com.application;

import com.application.model.Customer;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("first", "second", "j@domain.com");
        System.out.println(customer);         
        Customer customer1 = new Customer("first", "second", "email");
        System.out.println(customer1);
    }
}