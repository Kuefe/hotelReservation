package model;

import java.util.Objects;

public class Room implements IRoom {
    private String roomNumber;
    private Double roomPrice;
    private RoomType roomType;

    public Room(String roomNumber, Double roomPrice, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.roomPrice = roomPrice;
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "Room number: " + roomNumber + " room type: " + roomType + " price: " + roomPrice;
    }

    @Override
    public final String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public final Double getRoomPrice() {
        return roomPrice;
    }

    @Override
    public final RoomType getRoomType() {
        return roomType;
    }

    public final void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public final void setRoomPrice(Double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public final void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @Override
    public boolean isFree() {
        return false;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(roomNumber);
    }

    @Override
    public final boolean equals(Object obj) {
        Room room = (Room) obj;
        if (room.roomNumber.equals(roomNumber)) {
            return true;
        } else{
            return false;
        }
    }
}
