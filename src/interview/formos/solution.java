package interview.formos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class solution {
    // 1. Hardcode the vendor's starting inventory of ingredients
    private static final Map<String, Integer> inventoryOfIngredients = new HashMap<>();

    static {
        inventoryOfIngredients.put("Strawberry", 10000); 
        inventoryOfIngredients.put("Banana", 10000);    
        inventoryOfIngredients.put("Mango", 10000);     
        inventoryOfIngredients.put("Ice", 10000);       
        inventoryOfIngredients.put("Condensed Milk", 10000); 
        inventoryOfIngredients.put("Sugar", 10000);     
    }

    private static final int mlOfIcePer100MlOfFruitDrink = 30;
    private static final int mlOfMilkPer100MlOfFruitDrink = 20;
    private static final int mlOfSugarPer100MlOfFruitDrink = 8;


    private static final int grOfStraberryPer100Ml = 100; 
    private static final int grOfBananaPer100Ml = 120;    
    private static final int grOfMangoPer100Ml = 140;     

    // Drink size
    private static final int sizeOfDrink = 300;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. List Inventory");
            System.out.println("2. Sell Drink");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine()); // Read input as a string first and then convert to an Integer.
            } catch (NumberFormatException e) {
                scanner.close();
                break;
            }

            switch (choice) {
                case 1:
                    listInventory();
                    break;
                case 2:
                    sellDrink(scanner);
                    break;
                default:
                    System.out.println("closing the application.");
                    scanner.close();
                    return;
            }
        }
    }

    // 2. Provide a function to list the vendor's current inventory of ingredients
    private static void listInventory() {
        System.out.println("=========================");
        System.out.println("INVENTORY OF INGREDIENTS:");
        for (Map.Entry<String, Integer> entry : inventoryOfIngredients.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // 3. Allow the vendor to sell a drink and reduce inventory accordingly,
    // 4. Deny a sale when there are not enough ingredients to make the drink
    private static void sellDrink(Scanner scanner) {
        System.out.print("Enter the flavor (Strawberry, Banana, Mango): ");
        String flavor = scanner.nextLine().trim(); // Remove leading/trailing spaces

        if (!flavor.equalsIgnoreCase("Strawberry") && !flavor.equalsIgnoreCase("Banana") && !flavor.equalsIgnoreCase("Mango")) {
            System.out.println("Invalid flavor. Please choose from Strawberry, Banana, or Mango.");
            return;
        }

        // Calculate the required ingredients for the drink
        int requiredFruitGrams = 0;
        switch (flavor.toLowerCase()) {
            case "strawberry":
                requiredFruitGrams = (int) Math.ceil((sizeOfDrink / 100.0) * grOfStraberryPer100Ml);
                break;
            case "banana":
                requiredFruitGrams = (int) Math.ceil((sizeOfDrink / 100.0) * grOfBananaPer100Ml);
                break;
            case "mango":
                requiredFruitGrams = (int) Math.ceil((sizeOfDrink / 100.0) * grOfMangoPer100Ml);
                break;
        }
        int requiredIceMl = (int) Math.ceil((sizeOfDrink / 100.0) * mlOfIcePer100MlOfFruitDrink);
        int requiredMilkMl = (int) Math.ceil((sizeOfDrink / 100.0) * mlOfMilkPer100MlOfFruitDrink);
        int requiredSugarGrams = (int) Math.ceil((sizeOfDrink / 100.0) * mlOfSugarPer100MlOfFruitDrink);

        // Check if there are enough ingredients
        if (inventoryOfIngredients.get(flavor) < requiredFruitGrams ||
                inventoryOfIngredients.get("Ice") < requiredIceMl ||
                inventoryOfIngredients.get("Condensed Milk") < requiredMilkMl ||
                inventoryOfIngredients.get("Sugar") < requiredSugarGrams) {
            System.out.println("Insufficient ingredients to make the drink.");
            System.out.println("Cannot sell " + flavor + " drink.");
            return;
        }

        // Reduce the inventory
        inventoryOfIngredients.put(flavor, inventoryOfIngredients.get(flavor) - requiredFruitGrams);
        inventoryOfIngredients.put("Ice", inventoryOfIngredients.get("Ice") - requiredIceMl);
        inventoryOfIngredients.put("Condensed Milk", inventoryOfIngredients.get("Condensed Milk") - requiredMilkMl);
        inventoryOfIngredients.put("Sugar", inventoryOfIngredients.get("Sugar") - requiredSugarGrams);

        System.out.println("Sold a " + sizeOfDrink + "ml " + flavor + " drink.");
    }   
}
