package com.application.model;

import java.util.Date;

/**
 * Represents a reservation of a room in a hotel
 */
public class Reservation {

    /**
     * The customer who made the reservation
     */
    private final Customer customer;

    /**
     * The room that was reserved
     */
    private final IRoom room;

    /**
     * The date the room was checked in
     */
    private final Date checkIn;

    /**
     * The date the room was checked out
     */
    private final Date checkOut;

    /**
     * Creates a new reservation
     * 
     * @param customer The customer who made the reservation
     * @param room The room that was reserved
     * @param checkIn The date the room was checked in
     * @param checkOut The date the room was checked out
     */
    public Reservation(Customer customer, IRoom room, Date checkIn, Date checkOut) {
        this.customer = customer;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    /**
     * Gets the customer who made the reservation
     * 
     * @return The customer who made the reservation
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Gets the room that was reserved
     * 
     * @return The room that was reserved
     */
    public IRoom getRoom() {
        return room;
    }

    /**
     * Gets the date the room was checked in
     * 
     * @return The date the room was checked in
     */
    public Date getCheckIn() {
        return checkIn;
    }

    /**
     * Gets the date the room was checked out
     * 
     * @return The date the room was checked out
     */
    public Date getCheckOut() {
        return checkOut;
    }

    /**
     * Returns a string representation of the Reservation object with customer,
     * room, check in, and check out dates.
     * 
     * @return A string representing the Reservation object
     */
    @Override
    public String toString() {
        return String.format("Reservation={customer=%s, room=%s, checkIn=%s, checkOut=%s}", customer, room, checkIn, checkOut);
    }
}

