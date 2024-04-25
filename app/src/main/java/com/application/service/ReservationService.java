package com.application.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.application.model.Customer;
import com.application.model.IRoom;
import com.application.model.Reservation;

/**
 * A service class that manages reservations and rooms in the hotel application.
 */
public class ReservationService {

    private static ReservationService instance = null;

    /**
     * A collection of all the reservations in the hotel
     */
    private Collection<Reservation> reservations = new ArrayList<>();

    /**
     * A collection of all the rooms in the hotel
     */
    private Collection<IRoom> rooms = new ArrayList<>();


    /**
     * Returns the single instance of ReservationService
     * 
     * @return The single instance of ReservationService
     */
    public static ReservationService getInstance() {
        if (instance == null) {
            instance = new ReservationService();
        }
        return instance;
    }

    /**
     * Adds a room to the hotel
     * 
     * @param room The room to be added
     */
    public void addRoom(IRoom room) {
        this.rooms.add(room);
    }

    /**
     * Returns a room with the given room number from the hotel
     * 
     * @param roomNumber The room number of the room to be returned
     * @return The room with the given room number, null if no such room exists
     */
    public IRoom getARoom(String roomNumber) {
        return this.rooms.stream().filter(room -> room.getRoomNumber().equalsIgnoreCase(roomNumber)).findFirst()
                .orElse(null);
    }

    /**
     * return all room in the hotel
     */
    public Collection<IRoom> getAllRooms() {
        return this.rooms;
    }

    /**
     * Adds a reservation to the hotel
     * 
     * @param customer  The customer making the reservation
     * @param room      The room that is being reserved
     * @param checkInDate The date the room is being checked in
     * @param checkOutDate The date the room is being checked out
     * @return The reservation that was created
     */
    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        this.reservations.add(reservation);
        return reservation;
    }

    /**
     * Finds all the rooms that are available for the given dates
     * 
     * @param checkInDate The date the room is being checked in
     * @param checkOutDate The date the room is being checked out
     * @return All the rooms that are available for the given dates
     */
    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        Collection<IRoom> availableRooms = new ArrayList<IRoom>();
        for (IRoom room : this.rooms) {
            boolean isReserved = false;
            for (Reservation reservation : this.reservations) {
                if (reservation.getRoom().getRoomNumber().equals(room.getRoomNumber())) {
                    if (checkInDate.after(reservation.getCheckInDate())
                            && checkInDate.before(reservation.getCheckOutDate())) {
                        isReserved = true;
                        break;
                    } else if (checkOutDate.after(reservation.getCheckInDate())
                            && checkOutDate.before(reservation.getCheckOutDate())) {
                        isReserved = true;
                        break;
                    }
                }
            }
            if (!isReserved) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    /**
     * Returns all the reservations made by a customer
     * 
     * @param customer The customer who made the reservation
     * @return All the reservations made by the customer
     */
    public Collection<Reservation> getCustomersReservations(Customer customer) {
        Collection<Reservation> reservations = new ArrayList<Reservation>();
        for (Reservation reservation : this.reservations) {
            if (reservation.getCustomer().getEmail().equalsIgnoreCase(customer.getEmail())) {
                reservations.add(reservation);
            }
        }
        return reservations;
    }

    /**
     * Prints all the reservations in the hotel
     */
    public void printAllReservations() {
        for (Reservation reservation : this.reservations) {
            System.out.println(reservation);
        }
    }
}

