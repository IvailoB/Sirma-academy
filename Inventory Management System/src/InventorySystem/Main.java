package InventorySystem;

import InventorySystem.models.ElectronicsItem;
import InventorySystem.models.FragileItem;
import InventorySystem.models.GroceryItem;
import InventorySystem.models.InventorySuperclass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<InventorySuperclass> inventory = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addItemToInventory(inventory, scanner);
                    break;
                case 2:
                    removeItemFromInventory(inventory, scanner);
                    break;
                case 3:
                    listInventory(inventory);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Inventory Management System Menu:");
        System.out.println("1. Add Item to Inventory");
        System.out.println("2. Remove Item from Inventory");
        System.out.println("3. List Inventory");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addItemToInventory(List<InventorySuperclass> inventory, Scanner scanner) {
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter item category: ");
        String category = scanner.nextLine();
        System.out.print("Is the item breakable (true/false): ");
        boolean breakable = scanner.nextBoolean();
        System.out.print("Is the item perishable (true/false): ");
        boolean perishable = scanner.nextBoolean();
        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter item quantity: ");
        int quantity = scanner.nextInt();

        System.out.println("Select the item type:");
        System.out.println("1. Electronics");
        System.out.println("2. Grocery");
        System.out.println("3. Fragile");
        int itemTypeChoice = scanner.nextInt();

        switch (itemTypeChoice) {
            case 1:
                System.out.print("Enter the brand for Electronics: ");
                String brand = scanner.next();
                System.out.print("Enter the model for Electronics: ");
                String model = scanner.next();
                inventory.add(new ElectronicsItem(name, category, breakable, perishable, price, quantity, inventory.size(), brand, model));
                break;
            case 2:
                System.out.print("Enter the expiration date for Grocery: ");
                String expirationDate = scanner.next();
                inventory.add(new GroceryItem(name, category, breakable, perishable, price, quantity, inventory.size(), expirationDate));
                break;
            case 3:
                System.out.print("Enter the weight for Fragile item: ");
                double weight = scanner.nextDouble();
                inventory.add(new FragileItem(name, category, breakable, perishable, price, quantity, inventory.size(), weight));
                break;
            default:
                System.out.println("Invalid item type choice.");
        }
        System.out.println("Item added to inventory.");
    }

    private static void removeItemFromInventory(List<InventorySuperclass> inventory, Scanner scanner) {
        System.out.print("Enter the item name to remove: ");
        String name = scanner.nextLine();

        for (InventorySuperclass item : inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                inventory.remove(item);
                System.out.println("Item removed from inventory.");
                return;
            }
        }

        System.out.println("Item not found in inventory.");
    }

    private static void listInventory(List<InventorySuperclass> inventory) {
        System.out.println("Inventory Items:");
        for (InventorySuperclass item : inventory) {
            System.out.println(item.getItemDetails());
        }
    }
}
