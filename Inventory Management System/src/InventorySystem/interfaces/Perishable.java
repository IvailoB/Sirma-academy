package InventorySystem.interfaces;

public interface Perishable {
    boolean isPerishable();

    void handleExpiration();
}
