package com.application.model;

/**
 * Represents a customer of the hotel.
 */
public class Customer {
    /**
     * The customer's first name.
     */
    private String firstName;

    /**
     * The customer's last name.
     */
    private String lastName;

    /**
     * The customer's email address. It must be in the format 
     * {@code ^[\\w.-]+@([\\w.-]+)\\.com$}.
     */
    private String email;

    /**
     * Creates a new customer.
     * 
     * @param firstName The customer's first name
     * @param lastName The customer's last name
     * @param email The customer's email address
     * @throws IllegalArgumentException If {@code email} is null, empty,
     * or does not match the expected format
     */
    public Customer(String firstName, String lastName, String email) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }

    /**
     * Gets the customer's first name.
     * 
     * @return The customer's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the customer's first name.
     * 
     * @param firstName The new customer's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the customer's last name.
     * 
     * @return The customer's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the customer's last name.
     * 
     * @param lastName The new customer's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the customer's email address.
     * 
     * @return The customer's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the customer's email address. It must be in the format 
     * {@code ^[\\w.-]+@([\\w.-]+)\\.com$}.
     * 
     * @param email The new customer's email address
     * @throws IllegalArgumentException If {@code email} is null, empty,
     * or does not match the expected format
     */
    public void setEmail(String email) {
        if (email == null || email.isEmpty() || !email.matches("^[\\w.-]+@([\\w.-]+)\\.com$")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.email = email;
    }

    /**
     * Returns a string representation of the Customer object with first name,
     * last name, and email address.
     * 
     * @return A string representing the Customer object
     */
    @Override
    public String toString() {
        return String.format("Customer={firstName=%s, lastName=%s, email=%s}", firstName, lastName, email);
    }
}

