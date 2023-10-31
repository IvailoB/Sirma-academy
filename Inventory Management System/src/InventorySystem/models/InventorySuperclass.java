package InventorySystem.models;

public class InventorySuperclass extends AbstractItem {
    private int id;
    private int quantity;

    public InventorySuperclass(String name, String category, boolean breakable, boolean perishable, double price, int quantity, int id) {
        super(name, category, breakable, perishable, price, quantity);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void handleBreakage() {

    }

    @Override
    public void handleExpiration() {

    }
}
