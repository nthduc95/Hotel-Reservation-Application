package com.application;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;

import com.application.api.HotelResource;
import com.application.model.IRoom;
import com.application.model.Reservation;

public class MainMenu {
    private static final HotelResource HOTEL_RESOURCE = HotelResource.getInstance();

    public static MainMenu getInstance() {
        return new MainMenu();
    }

    public void createACustomerUI(Scanner scanner) {
        System.out.println("Enter customer email: ");
        String email = scanner.nextLine();

        if (email.matches("^[\\w-\\.]+@([\\w-]+\\.com)$") && HOTEL_RESOURCE.getCustomer(email) == null) {
            System.out.println("Enter customer first name: ");
            String firstName = scanner.nextLine();

            System.out.println("Enter customer last name: ");
            String lastName = scanner.nextLine();

            try {
                HOTEL_RESOURCE.createCustomer(email, firstName, lastName);
                System.out.println("Customer created successfully.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Customer with this email invalid or already exists.");
        }
    }

    public void findAndReserveARoomUI(Scanner scanner) {
        Date[] dates = getDateRange(scanner);
        Collection<IRoom> rooms = HOTEL_RESOURCE.findAvailableRooms(dates[0], dates[1]);

        if (rooms.size() > 0) {
            System.out.println("List of available rooms: ");
            for (IRoom room : rooms) {
                System.out.println(room);
            }

            System.out.println("Enter room number: ");
            String roomNumber = scanner.nextLine();

            IRoom room = HOTEL_RESOURCE.getRoom(roomNumber);
            if (room != null && rooms.contains(room)) {
                System.out.println("Enter customer email: ");
                String email = scanner.nextLine();

                try {
                    Reservation reservation = HOTEL_RESOURCE.bookRoom(email, room, dates[0], dates[1]);
                    System.out.println("Room booked successfully.");
                    System.out.println(reservation);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Room not found.");
            }
        } else {
            System.out.println("No rooms available for this date range.");
        }
    }

    public void displayMyReservationsUI(Scanner scanner) {
        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();
        Collection<Reservation> reservations = HOTEL_RESOURCE.getReservations(email);
        if (reservations.isEmpty()) {
            System.out.println("No reservations found for this customer.");
        } else {
            System.out.printf("| %-20s | %-20s | %-15s | %-20s | %-15s | %-15s | %-15s | %-30s | %-30s |\n",
                    "First Name", "Last Name", "Email", "Room Number", "Type", "Price", "Free",
                    "Check In", "Check Out");
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
        }
    }

    public void displayMainMenu(Scanner scanner) {
        ArrayList<String> mainMenuItems = new ArrayList<String>() {
            {
                add("Find and reserve a room");
                add("See my reservations");
                add("Create an account");
                add("Admin");
                add("Exit");
            }
        };

        int mainMenuChoice = getMenuChoice("Main Menu", mainMenuItems, scanner);
        System.out.println(mainMenuChoice);
        switch (mainMenuChoice) {
            case 1:
                // Find and reserve a room
                findAndReserveARoomUI(scanner);
                break;
            case 2:
                // See my reservations
                displayMyReservationsUI(scanner);
                break;
            case 3:
                // Create an account
                createACustomerUI(scanner);
                break;
            case 4:
                // Admin
                // AdminMenu adminManager = AdminMenu.getInstance();
                // adminManager.displayAdminMenu(scanner);
                break;
            case 5:
                // Exit the application
                break;
            default:
                break;
        }

        if (mainMenuChoice != 5) {
            // check if user wants to continue using the application
            System.out.println("Do you want to continue using the application (Y/N): ");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("Y")) {
                displayMainMenu(scanner);
            } else {
                System.out.println("Thank you for using our application.");
                scanner.close();
            }
        } else {
            System.out.println("Thank you for using our application.");
            scanner.close();
        }
    }

    private static void displayMenu(List<String> menuOptions, String menuLabel) {
        System.out.printf("================== %s ==================\n", menuLabel);

        for (int i = 0; i < menuOptions.size(); i++) {
            System.out.println((i + 1) + ". " + menuOptions.get(i));
        }
    }

    private static int getMenuChoice(String menuTitle, List<String> menuItems, Scanner scanner) {
        displayMenu(menuItems, menuTitle);
        int choice = 0;
        System.out.println("Enter your choice: ");
        do {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (choice < 0 || choice >= menuItems.size());
        return choice;
    }

    private static Date getDate(Scanner scanner) {
        while (true) {
            String rawDate = scanner.next();
            if (rawDate.matches("\\d{2}/\\d{2}/\\d{4}")) {
                String[] parts = rawDate.split("/");
                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);
                try {
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(year, month - 1, day);
                    return calendar.getTime();
                } catch (Exception e) {
                    System.out.println("Invalid date. Please try again.");
                }                
            }
            System.out.print("Enter a date in dd/mm/yyyy format: ");
            rawDate = scanner.next();
        }
    }

    private static Date[] getDateRange(Scanner scanner) {
        Date checkIn, checkOut;
        while (true) {
            checkIn = getDate(scanner);
            checkOut = getDate(scanner);
            if (checkIn.before(checkOut)) {
                break;
            } else {
                System.out.println("Check-in date must be before check-out date.");
            }
        }
        return new Date[] { checkIn, checkOut };
    }

}
