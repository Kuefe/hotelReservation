import model.Customer;
import model.IRoom;
import model.Reservation;
import java.util.Collection;
import java.util.Date;

public class HotelResource {
    private static final CustomerService customerService =
            CustomerService.getInstance();
    private static final ReservationService reservationService =
            ReservationService.getInstance();

    public static Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public static void createACustomer(String email, String firstName, String lastName) {
        customerService.addCustomer(email, firstName, lastName);
    }

    public static Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        return reservationService.reserveARoom(getCustomer(customerEmail), room, checkInDate, checkOutDate);
    }

    public static Collection<Reservation> getCustomersReservations(String customerEmail) {
        return reservationService.getCustomerReservations(getCustomer(customerEmail));
    }

    public static Collection<IRoom> findARoom(Date checkInDate, Date checkOutDate) {
        return reservationService.findRooms(checkInDate,checkOutDate);
    }
}
