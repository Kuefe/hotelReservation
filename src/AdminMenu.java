import model.*;

import java.util.*;

public class AdminMenu {
    public static HashMap<String, IRoom> rooms = new HashMap<String, IRoom>();

    public static void runMenu() {
        boolean keepRunning = true;
        Scanner scanner = new Scanner(System.in);
        while (keepRunning) {
            try {
                System.out.println("Admin Menu");
                System.out.println("");
                System.out.println("____________________________________________________");
                System.out.println("1. See all customers");
                System.out.println("2. See all rooms");
                System.out.println("3. See all reservations");
                System.out.println("4. Add a room");
                System.out.println("5. Back to Main Menu");
                System.out.println("____________________________________________________");
                System.out.println("Please select a number for the menu option: ");
                int selection = Integer.parseInt(scanner.nextLine());
                switch (selection) {
                    case 1:
                        seeAllCustomers();
                        break;
                    case 2:
                        seeAllRooms();
                        break;
                    case 3:
                        AdminResource.displayAllReservations();
                        break;
                    case 4:
                        addARoom();
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
    }

    private static void addARoom() {
        String screenText = "";
        String addRoom = "y";
        int roomTypeSelection = 0;

        Scanner scanner = new Scanner(System.in);

        while (addRoom.equals("y")) {
            Room newRoom = new Room("", 0.0, RoomType.SINGLE);
            try {
                // Input room number
                System.out.println("Enter a room number");
                newRoom.setRoomNumber(scanner.nextLine());

                // Input roomPrice per night
                System.out.println("Enter roomPrice per night");
                newRoom.setRoomPrice(Double.parseDouble(scanner.nextLine()));

                // Input room type
                screenText = "Enter room type: 1 for single bed, 2 for double bed";
                do {
                    System.out.println(screenText);
                    screenText = "Please enter 1(single bed) or 2(double bed)";
                    roomTypeSelection = Integer.parseInt(scanner.nextLine());
                } while (roomTypeSelection != 1 && roomTypeSelection != 2);

                // Input add another room?
                screenText = "Would you like to add another room y/n";
                do {
                    System.out.println(screenText);
                    screenText = "Please enter Y(Yes) or N(No)";
                    addRoom = scanner.nextLine().toLowerCase().substring(0, 1);
                } while (!(addRoom.equals("y") || addRoom.equals("n")));

            } catch (Exception ex) {
                System.out.println("Error - Invalid Input\n");
            }
            if (roomTypeSelection == 2) {
                newRoom.setRoomType(RoomType.DOUBLE);
            }
            rooms.put(newRoom.getRoomNumber(), newRoom);
        }
        AdminResource.addRoom(rooms);
    }

    private static void seeAllRooms() {
        Collection<IRoom> rooms = AdminResource.getAllRooms();
        for (IRoom room : rooms) {
            System.out.println(room);
        }
    }

    private static void seeAllCustomers() {
        Collection<Customer> customers = AdminResource.getAllCustomers();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}
