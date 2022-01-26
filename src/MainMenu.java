import model.IRoom;
import model.Reservation;

import java.text.SimpleDateFormat;
import java.util.*;

public class MainMenu {

    public static void main(String[] args) {
        boolean keepRunning = true;
        Scanner scanner = new Scanner(System.in);
        while (keepRunning) {
            try {
                System.out.println("Welcome to the Hotel Reservation Application");
                System.out.println("");
                System.out.println("____________________________________________________");
                System.out.println("1. Find and reserve a room");
                System.out.println("2. See my reservations");
                System.out.println("3. Create an account");
                System.out.println("4. Admin");
                System.out.println("5. Exit");
                System.out.println("____________________________________________________");
                System.out.println("Please select a number for the menu option: ");
                int selection = Integer.parseInt(scanner.nextLine());
                switch (selection) {
                    case 1:
                        findAndReserveARoom();
                        break;
                    case 2:
                        seeMyReservation();
                        break;
                    case 3:
                        createAccount();
                        break;
                    case 4:
                        AdminMenu.runMenu();
                        break;
                    case 5:
                        keepRunning = false;
                        break;
                    default:
                        System.out.println("Please enter a number between 1 and 5");
                        break;
                }
            } catch (Exception ex) {
                System.out.println("Error - Invalid Input\n");
            }
        }
        scanner.close();
    }

    private static void findAndReserveARoom() {
        Scanner scanner = new Scanner(System.in);

        try {
            // input Check-In-Date
            System.out.println("Enter Check-In Date mm/dd/yyyy example: 06/31/2022");
            Date checkInDate = splitStringToDate(scanner.nextLine());

            // input Check-Out-Date
            System.out.println("Enter Check-Out Date mm/dd/yyyy example: 06/31/2022");
            Date checkOutDate = splitStringToDate(scanner.nextLine());

            // search and display free rooms
            Collection<IRoom> freeRooms = HotelResource.findARoom(checkInDate, checkOutDate);

            if (freeRooms.size() == 0) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(checkInDate);
                calendar.add(Calendar.DAY_OF_MONTH, 7);
                checkInDate = calendar.getTime();

                calendar.setTime(checkOutDate);
                calendar.add(Calendar.DAY_OF_MONTH, 7);
                checkOutDate = calendar.getTime();

                freeRooms = HotelResource.findARoom(checkInDate, checkOutDate);
            }

            if (freeRooms.size() > 0) {
                final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
                System.out.println("checkInDate: " + format.format(checkInDate) +
                        " checkOutDate: " + format.format(checkOutDate));

                for (IRoom freeRoom : freeRooms) {
                    System.out.println(freeRoom);
                }

                String screenText = "Would you like to book a room? y/n";
                String bookRoom = "";
                do {
                    System.out.println(screenText);
                    screenText = "Please enter Y(Yes) or N(No)";
                    bookRoom = scanner.nextLine().toLowerCase().substring(0, 1);
                } while (!(bookRoom.equals("y") || bookRoom.equals("n")));

                if (bookRoom.equals("y")) {
                    screenText = "Do you have an account with us? y/n";
                    String accountExist = "";
                    do {
                        System.out.println(screenText);
                        screenText = "Please enter Y(Yes) or N(No)";
                        accountExist = scanner.nextLine().toLowerCase().substring(0, 1);
                    } while (!(accountExist.equals("y") || accountExist.equals("n")));

                    if (accountExist.equals("n")) {
                        createAccount();
                    }

                    System.out.println("Enter Email format: name@domain.com");
                    String email = scanner.nextLine();

                    // Email-Address doesn't exist
                    if (HotelResource.getCustomer(email) == null) {
                        throw new IllegalArgumentException();
                    }

                    System.out.println("What room would you like to reserve?");
                    String roomNumber = scanner.nextLine();
                    IRoom selectedRoom = null;
                    for (IRoom freeRoom : freeRooms) {
                        if (freeRoom.getRoomNumber().equals(roomNumber)) {
                            selectedRoom = freeRoom;
                        }
                    }
                    if (selectedRoom == null) {
                        throw new IllegalArgumentException();
                    }

                    Reservation reservation = HotelResource.bookARoom(email,
                            selectedRoom,
                            checkInDate,
                            checkOutDate);

                    System.out.println(reservation);
                }
            } else {
                System.out.println("Sorry! We are fully booked for this date");
            }
        } catch (Exception ex) {
            System.out.println("Error - Invalid Input\n");
        }
    }

    private static Date splitStringToDate(String inputDateString) {
        Calendar calendar = Calendar.getInstance();
        String[] checkInDateSplit = inputDateString.split("/");
        // month is 0 until 11 and the input is 1 until 12
        int month = Integer.parseInt(checkInDateSplit[0]) - 1;
        int day = Integer.parseInt(checkInDateSplit[1]);
        int year = Integer.parseInt(checkInDateSplit[2]);
        calendar.set(year, month, day);
        return calendar.getTime();
    }

    private static void createAccount() {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input email-address
            System.out.println("Enter Email format: name@domain.com");
            String email = scanner.nextLine();

            // Input first name
            System.out.println("First Name");
            String firstName = scanner.nextLine();

            // Input last name
            System.out.println("Last Name");
            String lastName = scanner.nextLine();

            HotelResource.createACustomer(email, firstName, lastName);
        } catch (Exception ex) {
            System.out.println("Error - Invalid Input\n");
        }

    }


    private static void seeMyReservation() {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input email-address
            System.out.println("Enter Email format: name@domain.com");
            Collection<Reservation> customersReservations = HotelResource.getCustomersReservations(scanner.nextLine());
            for (Reservation customerReservation : customersReservations) {
                System.out.println(customerReservation);
            }
        } catch (Exception ex) {
            System.out.println("Error - Invalid Input\n");
        }
    }
}
