package com.application.model;

/**
 * A room in the hotel
 */
public class Room implements IRoom {
    /**
     * The room number
     */
    private String roomNumber;
    
    /**
     * The room price
     */
    private Double roomPrice;
    
    /**
     * The type of room
     */
    private RoomType roomType;
    
    /**
     * If the room is free
     */
    private boolean free;

    /**
     * Constructor for the room
     * @param roomNumber The room number
     * @param roomPrice The room price
     * @param roomType The type of room
     * @param free If the room is free
     */
    public Room(String roomNumber, Double roomPrice, RoomType roomType, boolean free) {
        this.roomNumber = roomNumber;
        this.roomPrice = roomPrice;
        this.roomType = roomType;
        this.free = free;
    }

    /**
     * Get the room number
     * @return The room number
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * Get the room price
     * @return The room price
     */
    public Double getRoomPrice() {
        return roomPrice;
    }

    /**
     * Set the room price
     * @param roomPrice The new room price
     */
    public void setRoomPrice(Double roomPrice) {
        this.roomPrice = roomPrice;
    }

    /**
     * Get the room type
     * @return The type of room
     */
    public RoomType getRoomType() {
        return roomType;
    }

    /**
     * Check if the room is free
     * @return If the room is free
     */
    public boolean isFree() {
        return free;
    }

    /**
     * Returns a formatted string representing the Room object with room number, room price, room type, and free status.
     *
     * @return A string representing the Room object
     */
    @Override
    public String toString() {
        return String.format("Room={number=%s, price=%.2f, type=%s, free=%b}",
                roomNumber, roomPrice, roomType == RoomType.SINGLE ? "SINGLE" : "DOUBLE", free);
    }
}
