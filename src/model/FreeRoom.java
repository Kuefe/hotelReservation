package model;

public class FreeRoom extends Room{

    public FreeRoom(String roomNumber, Double roomPrice, RoomType roomType) {
        super(roomNumber, 0.0, roomType);
    }

    @Override
    public final String toString() {
        return super.toString();
    }

    @Override
    public final boolean isFree() {
        return true;
    }
}
