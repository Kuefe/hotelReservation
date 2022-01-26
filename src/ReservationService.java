import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.*;

public class ReservationService {
    Map<String, ArrayList<Reservation>> reservations = new HashMap<String, ArrayList<Reservation>>();
    Map<String, IRoom> rooms = new HashMap<String, IRoom>();

    private static ReservationService INSTANCE;

    private ReservationService() {
    }

    static ReservationService getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ReservationService();

        return INSTANCE;
    }

    public void addRoom(IRoom room) {
        rooms.put(room.getRoomNumber(), room);
    }

    IRoom getARoom(String roomId) {
        return rooms.get(roomId);
    }

    Collection<IRoom> getAllRooms() {
        return rooms.values();
    }

    Reservation reserveARoom(Customer customer,
                             IRoom room,
                             Date checkInDate,
                             Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        String customerEmail = customer.getEmail();
        reservations.putIfAbsent(customerEmail, new ArrayList<>());
        reservations.get(customerEmail).add(reservation);
        return reservation;
    }

    Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        List<IRoom> freeRooms = new ArrayList<IRoom>();

        for (IRoom room : rooms.values()) {
            freeRooms.add(room);
        }

        for (ArrayList<Reservation> customerReservations : reservations.values()) {
            for (Reservation reservation : customerReservations) {
                if (checkOutDate.after(reservation.getCheckInDate())
                        && checkInDate.before(reservation.getCheckOutDate())) {
                    freeRooms.remove(reservation.getRoom());
                }
            }
        }

        freeRooms.sort(Comparator.comparing(IRoom::getRoomNumber));
        return freeRooms;
    }

    Collection<Reservation> getCustomerReservations(Customer customer) {
        return reservations.get(customer.getEmail());
    }

    void printAllReservation() {
        for (ArrayList<Reservation> customerReservations : reservations.values()) {
            for (Reservation reservation : customerReservations) {
                System.out.println(reservation);
            }
        }

    }
}
