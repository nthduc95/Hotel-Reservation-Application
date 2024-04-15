package com.application.model;

/**
 * A free room in the hotel.
 *
 * A free room is a room that is not currently booked and therefore the price
 * is set to 0.0.
 */
public class FreeRoom extends Room {

    /**
     * Creates a new {@code FreeRoom} instance.
     *
     * @param roomNumber the room number
     * @param roomPrice the room price
     * @param roomType the room type
     * @param free whether the room is free or not
     */
    public FreeRoom(String roomNumber, Double roomPrice, RoomType roomType, boolean free) {
        super(roomNumber, roomPrice, roomType, free);
        this.setRoomPrice(0.0);
    }

    /**
     * Returns a string representation of the FreeRoom object with room number, room price, room type, and free status.
     *
     * @return  A formatted string representing the FreeRoom object
     */
    @Override
    public String toString() {
        return String.format("FreeRoom={roomNumber=%s, roomPrice=0.0, roomType=%s, free=%b}", roomNumber, roomType, free);
    }
}
