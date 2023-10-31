package InventorySystem.fileOperations;

import InventorySystem.models.InventorySuperclass;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
    public static void saveInventory(List<InventorySuperclass> inventory, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(inventory);
            System.out.println("Inventory saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<InventorySuperclass> loadInventory(String filename) {
        List<InventorySuperclass> inventory = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    String name = parts[0];
                    String category = parts[1];
                    boolean breakable = Boolean.parseBoolean(parts[2]);
                    boolean perishable = Boolean.parseBoolean(parts[3]);
                    double price = Double.parseDouble(parts[4]);
                    int quantity = Integer.parseInt(parts[5]);
                    int id = Integer.parseInt(parts[6]);

                    InventorySuperclass item = new InventorySuperclass(name, category, breakable, perishable, price, quantity, id);
                    inventory.add(item);
                }
            }
            System.out.println("Inventory loaded from " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inventory;
    }

//    Zashto ne raboti????
//    public static List<InventorySuperclass> loadInventory(String filename) throws FileNotFoundException {
//        final List<InventorySuperclass> inventory = new ArrayList<>();
//
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename)) {
//            inventory.add(ALL)
//            System.out.println("Inventory loaded from " + filename);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        return inventory;
//    }
}
