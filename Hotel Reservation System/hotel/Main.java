package projects.hotel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);


        String username;
        String password;
        boolean flag = true;
        int choice = -1;

        while (flag) {
            System.out.println("Hello to continue please log in");
            System.out.println("1. Log in");
            System.out.println("2. Register");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter username ");
                    username = scanner.next();
                    System.out.println("Enter password ");
                    password = scanner.next();
                    String loginUser = hotel.login(username, password);
                    if (loginUser.contains("Hello")){
                        flag = false;
                    }
                    System.out.println(loginUser);
                }
                case 2 -> {
                    System.out.println("Enter username ");
                    username = scanner.next();
                    System.out.println("Enter password ");
                    password = scanner.next();
                    hotel.register(username, password);
                    System.out.println("Your registration is successful");
                }
                default -> System.out.println("Invalid username or password");
            }
        }
        while (true) {
            System.out.println("\n1. Display available rooms");
            System.out.println("2. Book a room");
            System.out.println("3. Cancel Book");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> hotel.viewRooms();
                case 2 -> {
                    System.out.println("---Please enter room number for reservation: ");
                    int reservationNumber = scanner.nextInt();
                    System.out.println(hotel.bookRoom(reservationNumber));
                }
                case 3 -> {
                    System.out.println("---Please enter room number for cancel: ");
                    int cancelNumber = scanner.nextInt();
                    System.out.println(hotel.cancelBooking(cancelNumber));
                }
                case 4 -> {
                    System.out.println("---Thank you for using the Hotel Reservation System!---");
                    System.exit(0);
                }
                default -> System.out.println("---Invalid choice. Please try again.---");
            }
        }
    }
}