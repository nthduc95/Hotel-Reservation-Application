package com.application.api;

import java.util.Collection;
import java.util.Date;

import com.application.model.Customer;
import com.application.model.IRoom;
import com.application.model.Reservation;
import com.application.service.CustomerService;
import com.application.service.ReservationService;

/**
 * A class that provides a RESTful API for managing hotel reservations. Provides
 * methods to get and create customers, get and book rooms, and get a customer's
 * reservations.
 */
public class HotelResource {

    /**
     * The single instance of the HotelResource.
     */
    private static HotelResource instance = null;

    /**
     * The CustomerService used by this HotelResource.
     */
    private CustomerService customerService = CustomerService.getInstance();

    /**
     * The ReservationService used by this HotelResource.
     */
    private ReservationService reservationService = ReservationService.getInstance();

    /**
     * Returns the single instance of HotelResource.
     * 
     * @return The single instance of HotelResource
     */
    public static HotelResource getInstance() {
        if (instance == null) {
            instance = new HotelResource();
        }
        return instance;
    }

    /**
     * Retrieves a customer by their email address.
     * 
     * @param email The email address of the customer
     * @return The customer with the given email address, null if no customer was
     *         found
     */
    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    /**
     * Creates a new customer.
     * 
     * @param email    The customer's email address
     * @param firstName The customer's first name
     * @param lastName The customer's last name
     */
    public void createCustomer(String email, String firstName, String lastName) {
        customerService.addCustomer(email, firstName, lastName);
    }

    /**
     * Retrieves a room by its room number.
     * 
     * @param roomNumber The room number of the room to be retrieved
     * @return The room with the given room number, null if no such room exists
     */
    public IRoom getRoom(String roomNumber) {
        return reservationService.getARoom(roomNumber);
    }

    /**
     * Books a room for a customer.
     * 
     * @param customerEmail The email address of the customer making the reservation
     * @param room          The room that is being reserved
     * @param checkInDate   The date the room is being checked in
     * @param checkOutDate  The date the room is being checked out
     * @return The reservation that was created
     */
    public Reservation bookRoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        Customer customer = customerService.getCustomer(customerEmail);
        return reservationService.reserveARoom(customer, room, checkInDate, checkOutDate);
    }

    /**
     * Retrieves all the reservations made by a customer.
     * 
     * @param customerEmail The email address of the customer
     * @return All the reservations made by the customer
     */
    public Collection<Reservation> getReservations(String customerEmail) {
        Customer customer = customerService.getCustomer(customerEmail);
        return reservationService.getCustomersReservations(customer);
    }

    /**
     * Finds all the rooms that are available for the given dates.
     * 
     * @param checkInDate The date the room is being checked in
     * @param checkOutDate The date the room is being checked out
     * @return All the rooms that are available for the given dates
     */
    public Collection<IRoom> findAvailableRooms(Date checkIn, Date checkOut) {
        return reservationService.findRooms(checkIn, checkOut);
    }

}

