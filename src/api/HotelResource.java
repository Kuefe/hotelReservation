package api;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.Collection;
import java.util.Date;

public class HotelResource {
    // provide a static reference
    // implementation in the services

    public Customer getCustomer(String email) {
        return null;
    }

    public void createACustomer(String email, String firstName, String lastName){

    }

    public IRoom getRoom(String roomNumber){
        return null;
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        return null;
    }

    public Collection<Reservation> getCustomersReservations(String customerEmail){
        return null;
    }

    public Collection<IRoom> findARoom(Date checkInDate, Date checkOutDate){
        return null;
    }
}
