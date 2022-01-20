package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.Collection;
import java.util.Date;

public class ReservationService {
    private static ReservationService INSTANCE;

    public ReservationService() {
    }

    public static ReservationService getInstance()
    {
        if (INSTANCE == null)
            INSTANCE = new ReservationService();

        return INSTANCE;
    }

    public void addRoom(IRoom room){

    }

    public IRoom getARoom(String roomId){
        return null;
    }

    public Reservation reserveARoom(Customer customer,
                                    IRoom room,
                                    Date checkInDate,
                                    Date checkOutDate) {
        return null;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        return null;
    }

    public Collection<Reservation> getCustomerReservations(Customer customer){
        return null;
    }

    public void printAllReservation(){

    }

    // Create Collections to store and retrieve a Reservation

}
