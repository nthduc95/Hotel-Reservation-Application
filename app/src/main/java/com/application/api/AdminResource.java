package com.application.api;

import java.util.Collection;
import java.util.List;

import com.application.model.Customer;
import com.application.model.IRoom;
import com.application.service.CustomerService;
import com.application.service.ReservationService;

/**
 * A class that provides administrative functionality for the application
 */
public class AdminResource {

    private static AdminResource instance = null;
    private CustomerService customerService = CustomerService.getInstance();
    private ReservationService reservationService = ReservationService.getInstance();

    /**
     * Returns the single instance of AdminResource
     * 
     * @return The single instance of AdminResource
     */
    public static AdminResource getInstance() {
        if (instance == null) {
            instance = new AdminResource();
        }
        return instance;
    }

    /**
     * Retrieves a customer by their email address
     * 
     * @param email The email address of the customer
     * @return The customer with the given email address, null if no customer was
     *         found
     */
    public Customer getCustomer(String email) {
        return this.customerService.getCustomer(email);
    }

    /**
     * Adds rooms to the hotel
     * 
     * @param rooms The rooms to be added
     */
    public void addRoom(List<IRoom> rooms) {
        for (IRoom room : rooms) {
            this.reservationService.addRoom(room);
        }
    }

    /**
     * Retrieves all the rooms from the reservation service.
     *
     * @return All the rooms available in the hotel
     */
    public Collection<IRoom> getAllRooms() {
        return this.reservationService.getAllRooms();
    }

    /**
     * Retrieves a room by its room number.
     *
     * @param  roomNumber  The room number of the room to be retrieved
     * @return The room with the given room number
     */
    public IRoom getRoom(String roomNumber) {
        return this.reservationService.getARoom(roomNumber);
    }


    /**
     * Returns a list of all the customers in the hotel
     * 
     * @return All the customers in the hotel
     */
    public Collection<Customer> getAllCustomers() {
        return this.customerService.getAllCustomers();
    }

    /**
     * Prints all the reservations in the hotel
     */
    public void displayAllReservations() {
        this.reservationService.printAllReservations();
    }
}

