package projects.hotel;

import java.io.*;
import java.util.*;

class Hotel {
    //    ToDo change path for Room DB and users DB
    final String pathToRoom = "src/projects/hotel/rooms_info.txt";
    final String pathToUser = "src/projects/hotel/users_info.txt";

    private List<Room> rooms;
    private List<User> users;

    public Hotel() {
        this.rooms = initRoom();
        this.users = initUsers();
    }

    private List<User> initUsers() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToUser))) {
            String line = reader.readLine();

            while (line != null) {
                User user = new User();
                user.readUserDataFromFile(line, user);
                users.add(user);
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }


    private List<Room> initRoom() {
        List<Room> rooms = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToRoom))) {
            String line = reader.readLine();

            while (line != null) {
                Room room = new Room();
                room.readRoomDataFromFile(line, room);
                rooms.add(room);
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return rooms;
    }


    public void viewRooms() {
        rooms.stream()
                .filter(r -> r.getStatus().equals("Available"))
                .forEach(r -> System.out.println(r.toString() + System.lineSeparator()));
    }

    public String bookRoom(int roomNumber) {
        Room room = findRoomByNumber(roomNumber);
        if (null == room) {
            return "\nInvalid Room number. Please select correct room number";
        }
        room.setStatus("Booked");

        writeToTheRooms(roomNumber, "Available", "Booked", pathToRoom);
        return "You booked successful";

    }

    private Room findRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


    private User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public String cancelBooking(int bookingID) {
        Room room = findRoomByNumber(bookingID);
        if (null == room) {
            return "\nInvalid Room number. Please select correct room number";
        }
        room.setStatus("Available");
        writeToTheRooms(bookingID, "Booked", "Available", pathToRoom);
        return "You cancel the order.";
    }

    private void writeToTheRooms(int bookingID, String replace, String replacement, String path) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();

            while (line != null) {
                String[] split = line.split(",");
                content.append(line).append(System.lineSeparator());
                int number = Integer.parseInt(split[0]);
                if (number == bookingID) {
                    content = new StringBuilder(content.toString().replaceAll(replace, replacement));
                }
                line = reader.readLine();
            }
            FileOutputStream writer = new FileOutputStream(path);
            writer.write(content.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public String login(String username, String password) {
        User user = findUserByUsername(username);
        if (null == user) {
            return "Invalid username or password";
        }

        user.setPassword(password);
        user.setUsername(username);
        return "Hello, " + username;
    }

    public void register(String username, String password) {
        User user = new User(username, password);
        writeToTheUsers(user.getUsername(), user.getPassword(), pathToUser);

    }

    private void writeToTheUsers(String username, String password, String path) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();

            while (line != null) {
                content.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }
            content.append(username).append(",").append(password);
            FileOutputStream writer = new FileOutputStream(path);
            writer.write(content.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
