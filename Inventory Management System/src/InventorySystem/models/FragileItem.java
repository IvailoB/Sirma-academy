package InventorySystem.models;

public class FragileItem extends InventorySuperclass {
    private double weight;

    public FragileItem(String name, String category, boolean breakable, boolean perishable, double price, int quantity, int id, double weight) {
        super(name, category, breakable, perishable, price, quantity, id);
        this.weight = weight;
    }

    public void handleWithCare() {
        System.out.println("Handle this fragile item with care.");
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
