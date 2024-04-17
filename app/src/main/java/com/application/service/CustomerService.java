package com.application.service;

import java.util.ArrayList;
import java.util.Collection;

import com.application.model.Customer;

/**
 * Service for managing customers
 */
public class CustomerService {
    
    /**
     * The singleton instance of the service
     */
    private static CustomerService instance = null;
    
    /**
     * The list of customers
     */
    private final Collection<Customer> customers = new ArrayList<>();
    
    /**
     * Get the singleton instance of the service
     * 
     * @return The instance of the service
     */
    public static CustomerService getInstance() {
        if (instance == null) {
            instance = new CustomerService();
        }
        return instance;
    }
    
    /**
     * Add a customer to the list of customers
     * 
     * @param email The customer's email address
     * @param firstName The customer's first name
     * @param lastName The customer's last name
     */
    public void addCustomer(String email, String firstName, String lastName) {
        this.customers.add(new Customer(firstName, lastName, email));
    }
    
    /**
     * Find a customer by their email address
     * 
     * @param customerEmail The customer's email address
     * @return The customer with the given email address or null if no customer
     *         was found
     */
    public Customer getCustomer(String customerEmail) {
        return this.customers.stream()
                        .filter(c -> c.getEmail().equals(customerEmail))
                        .findFirst()
                        .orElse(null);
    }
    
    /**
     * Get a list of all customers
     * 
     * @return A list of all customers
     */
    public Collection<Customer> getAllCustomers() {
        return this.customers;
    }
}

