package com.application.model;

import java.util.Date;

/**
 * Represents a reservation of a room in a hotel
 */
public class Reservation {

    /**
     * The customer who made the reservation
     */
    private Customer customer;

    /**
     * The room that was reserved
     */
    private IRoom room;

    /**
     * The date the room was checked in
     */
    private Date checkInDate;

    /**
     * The date the room was checked out
     */
    private Date checkOutDate;

    /**
     * Creates a new reservation
     * 
     * @param customer The customer who made the reservation
     * @param room The room that was reserved
     * @param checkInDate The date the room was checked in
     * @param checkOutDate The date the room was checked out
     */
    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
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
    public Date getCheckInDate() {
        return checkInDate;
    }

    /**
     * Gets the date the room was checked out
     * 
     * @return The date the room was checked out
     */
    public Date getCheckOutDate() {
        return checkOutDate;
    }

    /**
     * Returns a string representation of the Reservation object with customer,
     * room, check in, and check out dates.
     * 
     * @return A string representing the Reservation object
     */
    @Override
    public String toString() {
        return String.format("Reservation={customer=%s, room=%s, checkInDate=%s, checkOutDate=%s}", customer, room, checkInDate, checkOutDate);
    }
}

