import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        boolean keepRunning = true;
        Scanner scanner = new Scanner(System.in);
        while (keepRunning) {
            try {
                System.out.println("Welcome to the Hotel Reservation1 Application");
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
                if (selection == 1) {
                    keepRunning = false;
                } else if (selection == 2) {
                    keepRunning = false;
                } else if (selection == 3) {
                    keepRunning = false;
                } else if (selection == 4) {
                    AdminMenu.runMenu();
                } else if (selection == 5) {
                    keepRunning = false;
                } else {
                    System.out.println("Please enter a number between 1 and 5");
                }
            } catch (Exception ex) {
                System.out.println("Error - Invalid Input\n");
            }
        }
        scanner.close();
    }
}
