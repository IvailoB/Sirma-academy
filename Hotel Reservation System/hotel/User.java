package projects.hotel;

import java.util.List;

public class User {
    private String username;
    private String password;
    private List<Integer> bookingHistory;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Integer> getBookingHistory() {
        return bookingHistory;
    }

    public void setBookingHistory(List<Integer> bookingHistory) {
        this.bookingHistory = bookingHistory;
    }

    public void readUserDataFromFile(String line, User user) {
        String[] data = line.split(",");
        String username = data[0];
        String password = data[1];

        user.setUsername(username);
        user.setPassword(password);
    }
}
