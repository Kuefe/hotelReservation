import model.Customer;
import model.IRoom;

import java.util.Collection;
import java.util.HashMap;

public class AdminResource {
    private static final CustomerService customerService =
            CustomerService.getInstance();
    private static final ReservationService reservationService =
            ReservationService.getInstance();

    static Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    static void addRoom(HashMap<String, IRoom> rooms) {
        for (IRoom room : rooms.values()) {
            reservationService.addRoom(room);
        }
    }

    static Collection<IRoom> getAllRooms() {
        return reservationService.getAllRooms();
    }

    static Collection<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    static void displayAllReservations(){
        reservationService.printAllReservation();
    }
}
