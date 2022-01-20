package model;

public class Room implements IRoom {
    private String roomNumber;
    private Double price;
    private RoomType roomType;

    public Room(String roomNumber, Double price, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "Room number: " + roomNumber + " price: " + price + " room type: " + roomType;
    }

    @Override
    public String getRoomNumber() {
        return null;
    }

    @Override
    public Double getRoomPrice() {
        return null;
    }

    @Override
    public model.RoomType getRoomType() {
        return null;
    }

    @Override
    public boolean isFree() {
        return false;
    }
}
