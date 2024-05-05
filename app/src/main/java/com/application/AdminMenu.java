package com.application;

import java.util.*;

import com.application.api.AdminResource;
import com.application.model.Customer;
import com.application.model.IRoom;
import com.application.model.Room;
import com.application.model.FreeRoom;
import com.application.model.RoomType;

public class AdminMenu {
    private static AdminMenu adminManager = null;

    private AdminResource adminResource = AdminResource.getInstance();

    public static AdminMenu getInstance() {
        if (adminManager == null) {
            adminManager = new AdminMenu();
        }
        return adminManager;
    }

    public void addRoomUI(Scanner scanner) {
        List<IRoom> newRooms = new ArrayList<>();

        do {
            newRooms.add(this.addRoom(scanner));
            System.out.println("Do you want to add another room (Y/N): ");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("N")) {
                break;
            } else if (choice.equalsIgnoreCase("Y")) {
                continue;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (true);

        adminResource.addRoom(newRooms);
    }

  
    public IRoom addRoom(Scanner scanner) {
        System.out.println("=================== Add Room - Admin Manager ===================");

        String roomNumber = getValidRoomNumber(scanner);

        int roomTypeIdx = getValidRoomTypeIdx(scanner);
        RoomType roomType = RoomType.values()[roomTypeIdx - 1];

        boolean isFree = getValidIsFree(scanner);

        double price = getValidPrice(scanner);
        if (isFree) {
            return new FreeRoom(roomNumber, price, roomType, isFree);
        } else {
            return new Room(roomNumber, price, roomType, isFree);
        }
    }

    /**
     * A function that prompts the user to enter a valid room number.
     *
     * @param  scanner  the Scanner object used for user input
     * @return  the valid room number entered by the user
     */
    private String getValidRoomNumber(Scanner scanner) {
        while (true) {
            System.out.println("Please enter room number: ");
            String roomNumber = scanner.next();

            if (adminResource.getRoom(roomNumber) != null) {
                System.out.println("Room number already exists. Please try again.");
            } else {
                return roomNumber;
            }
        }
    }

    /**
     * Retrieves a valid room type index from the user input.
     *
     * @param  scanner  the Scanner object used for user input
     * @return the valid room type index entered by the user
     */
    private int getValidRoomTypeIdx(Scanner scanner) {
        while (true) {
            System.out.println("Please enter room type (1: SINGLE, 2: DOUBLE): ");
            if (scanner.hasNextInt()) {
                int roomTypeIdx = scanner.nextInt();
                if (roomTypeIdx > 0 && roomTypeIdx <= RoomType.values().length) {
                    return roomTypeIdx;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                    scanner.next();
                }
            } else {
                System.out.println("Invalid choice. Please try again.");
                scanner.next();
            }
        }
    }

    /**
     * Retrieves a valid input from the user to determine if a room is free or not.
     *
     * @param  scanner  the Scanner object used for user input
     * @return true if the room is free, false otherwise
     */
    private boolean getValidIsFree(Scanner scanner) {
        while (true) {
            System.out.println("Please enter if room is free (0: False, 1: True): ");

            if (scanner.hasNextInt()) {
                int isFree = scanner.nextInt();
                if (isFree == 0 || isFree == 1) {
                    return isFree == 1;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } else {
                System.out.println("Invalid choice. Please try again.");
                scanner.next();
            }
        }
    }

    private double getValidPrice(Scanner scanner) {
        while (true) {
            System.out.println("Please enter price per night (price > 0): ");

            if (scanner.hasNextDouble()) {
                double price = scanner.nextDouble();
                if (price > 0) {
                    return price;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } else {
                System.out.println("Invalid choice. Please try again.");
                scanner.next();
            }
        }
    }

    public void displayAllRooms() {
        System.out.println("=================== All Rooms - Admin Manager ===================");
        Collection<IRoom> rooms = adminResource.getAllRooms();
        System.out.printf("| %-15s | %-15s | %-15s | %-15s |\n",
                "Room Number", "Price", "Room Type", "Free");
        for (IRoom room : rooms) {
            System.out.println(room);
        }
    }

    public void displayAllReservations() {
        System.out.println("=================== All Reservations - Admin Manager ===================");
        adminResource.displayAllReservations();
    }

    public void displayAllCustomers() {
        System.out.println("=================== All Customers - Admin Manager ===================");
        Collection<Customer> customers = adminResource.getAllCustomers();
        System.out.printf("| %-20s | %-20s | %-30s |\n",
                "First Name", "Last Name", "Email");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

}
