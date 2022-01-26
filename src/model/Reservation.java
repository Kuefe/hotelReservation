package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
    private Customer customer;
    private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    @Override
    public final String toString() {
        final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        return "Reservation:\n" +
                customer.getFirstName() + " " + customer.getLastName() + "\n" +
                "roomNumber: " + room.getRoomNumber() + " " +
                "roomType: " + room.getRoomType() + "\n" +
                "checkInDate: " + format.format(checkInDate) + " " +
                "checkOutDate: " + format.format(checkOutDate) + "\n";
    }

    public final Customer getCustomer() {
        return customer;
    }

    public final IRoom getRoom() {
        return room;
    }

    public final Date getCheckInDate() {
        return checkInDate;
    }

    public final Date getCheckOutDate() {
        return checkOutDate;
    }

    public final void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public final void setRoom(IRoom room) {
        this.room = room;
    }

    public final void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public final void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
}
