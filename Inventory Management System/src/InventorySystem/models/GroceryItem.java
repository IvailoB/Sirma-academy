package InventorySystem.models;

public class GroceryItem extends InventorySuperclass {
    private String expirationDate;

    public GroceryItem(String name, String category, boolean breakable, boolean perishable, double price, int quantity, int id, String expirationDate) {
        super(name, category, breakable, perishable, price, quantity, id);
        this.expirationDate = expirationDate;
    }

    public void cook() {
        System.out.println("Cooking the groceries.");
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
