package api;

import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.HashMap;

public class AdminResource {
    private static final CustomerService customerService =
            CustomerService.getInstance();
    private static final ReservationService reservationService =
            ReservationService.getInstance();

    public static Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public static void addRoom(HashMap<String , IRoom> rooms) {
        for (IRoom room : rooms.values()) {
            reservationService.addRoom(room);
        }
    }

    public static Collection<IRoom> getAllRooms() {
        return reservationService.getAllRooms();
    }

    public static Collection<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

}
