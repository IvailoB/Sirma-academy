package InventorySystem.models;

import InventorySystem.interfaces.*;

public abstract class AbstractItem implements Item, Breakable, Categorizable, Perishable, Sellable {
    private String name;
    private String category;
    private boolean breakable;
    private boolean perishable;
    private double price;
    private int quantity;

    public AbstractItem(String name, String category, boolean breakable, boolean perishable, double price, int quantity) {
        this.name = name;
        this.category = category;
        this.breakable = breakable;
        this.perishable = perishable;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String getItemDetails() {
        return "Name: " + name + ", Category: " + category + ", Price: $" + price + ", Quantity: " + quantity;
    }

    @Override
    public double calculateValue() {
        return price * quantity;
    }

    @Override
    public String getDescription() {
        return "This is an item of category " + category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean isBreakable() {
        return breakable;
    }

    public void setBreakable(boolean breakable) {
        this.breakable = breakable;
    }

    @Override
    public boolean isPerishable() {
        return perishable;
    }

    public void setPerishable(boolean perishable) {
        this.perishable = perishable;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
