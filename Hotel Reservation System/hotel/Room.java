package projects.hotel;

class Room {
    private int roomNumber;
    private String type;
    private double pricePerNight;
    private double cancellationFee;
    private String status;

    public Room() {

    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public double getCancellationFee() {
        return cancellationFee;
    }

    public void setCancellationFee(double cancellationFee) {
        this.cancellationFee = cancellationFee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Room readRoomDataFromFile(String roomDataFile, Room room) {

        String[] data = roomDataFile.split(",");
        int roomNumber = Integer.parseInt(data[0]);
        String type = data[1];
        double pricePerNight = Double.parseDouble(data[2]);
        double cancellationFee = Double.parseDouble(data[3]);
        String status = data[4];
        createRoom(room, roomNumber, type, pricePerNight, cancellationFee, status);

        return room;
    }

    private void createRoom(Room room, int roomNumber, String type, double pricePerNight, double cancellationFee, String status) {
        room.setRoomNumber(roomNumber);
        room.setType(type);
        room.setPricePerNight(pricePerNight);
        room.setStatus(status);
        room.setCancellationFee(cancellationFee);
    }

    @Override
    public String toString() {
        return
                "Room " + roomNumber +
                        "\ntype " + type +
                        "\nprice per night " + pricePerNight +
                        "\ncancellationFee " + cancellationFee +
                        "\nstatus " + status;
    }
}
