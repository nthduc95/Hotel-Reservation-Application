package com.application.model;

/**
 * Interface that represents a room in the hotel
 */
public interface IRoom {
    /**
     * Get the room number
     * @return Room number
     */
    public String getRoomNumber();

    /**
     * Get the room price
     * @return Room price
     */
    public Double getRoomPrice();

    /**
     * Get the room type
     * @return Room type
     */
    public RoomType getRoomType();

    /**
     * Check if the room is free
     * @return If the room is free
     */
    public boolean isFree();
}

