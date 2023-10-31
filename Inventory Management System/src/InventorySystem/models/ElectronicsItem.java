package InventorySystem.models;

public class ElectronicsItem extends InventorySuperclass{
    private String brand;
    private String model;

    public ElectronicsItem(String name, String category, boolean breakable, boolean perishable, double price, int quantity, int id, String brand, String model) {
        super(name, category, breakable, perishable, price, quantity, id);
        this.brand = brand;
        this.model = model;
    }

    public void powerOn() {
        System.out.println("Turning on the electronic device.");
    }

    public void connectToWiFi() {
        System.out.println("Connecting to a WiFi network.");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
