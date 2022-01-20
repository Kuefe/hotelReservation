import java.util.Scanner;

public class AdminMenu {
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
                if (selection == 1) {
                    keepRunning = false;
                } else if (selection == 2) {
                    keepRunning = false;
                } else if (selection == 3) {
                    keepRunning = false;
                } else if (selection == 4) {
                    addRoomMenu();
                } else if (selection == 5) {
                    keepRunning = false;
                } else {
                    System.out.println("Please enter a number between 1 and 5");
                }
            } catch (Exception ex) {
                System.out.println("Error - Invalid Input\n");
            }
        }
    }

    private static void addRoomMenu() {
        String screenText = "";
        String addRoom = "y";
        Scanner scanner = new Scanner(System.in);
        while (addRoom.equals("y")) {
            try {
                // Input room number
                System.out.println("Enter a room number");
                String roomNumber = scanner.nextLine();

                // Input price per night
                System.out.println("Enter price per night");
                double price = Double.parseDouble(scanner.nextLine());

                // Input room type
                screenText = "Enter room type: 1 for single bed, 2 for double bed";
                int roomType;
                do {
                    System.out.println(screenText);
                    screenText = "Please enter 1(single bed) or 2(double bed)";
                    roomType = Integer.parseInt(scanner.nextLine());
                } while (roomType != 1 && roomType != 2);

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
        }

    }
}
