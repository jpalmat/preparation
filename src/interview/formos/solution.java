package interview.formos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class solution {
   // 1. Hardcode the vendor's starting inventory of ingredients
    private static final Map<String, Integer> inventory = new HashMap<>();

    static {
        inventory.put("Strawberry", 5000); // in grams
        inventory.put("Banana", 5000);    // in grams
        inventory.put("Mango", 5000);     // in grams
        inventory.put("Ice", 10000);       // in ml
        inventory.put("Condensed Milk", 5000); // in ml
        inventory.put("Sugar", 1000);     // in grams
    }

    // Recipe for 100ml of blended fruit drink
    private static final int BASE_FRUIT_ML = 50;
    private static final int BASE_ICE_ML = 30;
    private static final int BASE_MILK_ML = 20;
    private static final int BASE_SUGAR_GRAMS = 8;

    // Amount of fruit required for 100ml of blended fruit
    private static final int STRAWBERRY_PER_100ML = 100; // grams
    private static final int BANANA_PER_100ML = 120;    // grams
    private static final int MANGO_PER_100ML = 140;     // grams

    // 3. Allow the vendor to sell 3 sizes (small, medium, and large)
    private static final Map<String, Integer> drinkSizes = new HashMap<>();

    static {
        drinkSizes.put("Small", 200);   // in ml
        drinkSizes.put("Medium", 300);  // in ml
        drinkSizes.put("Large", 400);   // in ml
    }

    // 4. Provide costs for each ingredient and set prices for each drink to ensure she makes a profit
    private static final Map<String, Double> ingredientCosts = new HashMap<>();

    static {
        ingredientCosts.put("Strawberry", 0.05); // per gram
        ingredientCosts.put("Banana", 0.04);    // per gram
        ingredientCosts.put("Mango", 0.06);     // per gram
        ingredientCosts.put("Ice", 0.001);       // per ml
        ingredientCosts.put("Condensed Milk", 0.005); // per ml
        ingredientCosts.put("Sugar", 0.002);     // per gram
    }

    private static final Map<String, Double> drinkPrices = new HashMap<>();

    static {
        drinkPrices.put("Small", 2.50);
        drinkPrices.put("Medium", 3.50);
        drinkPrices.put("Large", 4.50);
    }

    // 5. Allow sales over time and provide a report of daily sales
    private static final Map<String, Integer> dailySales = new HashMap<>(); // <Flavor, Quantity>
    private static String currentDate = java.time.LocalDate.now().toString();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Main loop to interact with the vendor
        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. List Inventory");
            System.out.println("2. Sell Drink");
            System.out.println("3. Exit");
            System.out.println("4. Show Daily Sales"); // Added option
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    listInventory();
                    break;
                case 2:
                    sellDrink(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    return;
                case 4:
                    showDailySales();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            // 5. Daily sales
            String today = java.time.LocalDate.now().toString();
            if (!today.equals(currentDate)) {
                dailySales.clear();
                currentDate = today;
            }
        }
    }

    // 2. Provide a function to list the vendor's current inventory of ingredients
    private static void listInventory() {
        System.out.println("\nCurrent Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        // 1. Provide a warning when any ingredient gets below the level required to make 4 more drinks
        checkLowInventory();
    }

    // 3. Allow the vendor to sell a drink and reduce inventory accordingly,
    // 4. Deny a sale when there are not enough ingredients to make the drink
    private static void sellDrink(Scanner scanner) {
        System.out.print("Enter the flavor (Strawberry, Banana, Mango, Mixed): ");
        String flavor = scanner.nextLine().trim();

        if (!flavor.equalsIgnoreCase("Strawberry") && !flavor.equalsIgnoreCase("Banana") && !flavor.equalsIgnoreCase("Mango") && !flavor.equalsIgnoreCase("Mixed")) {
            System.out.println("Invalid flavor. Please choose from Strawberry, Banana, Mango, or Mixed.");
            return;
        }

        System.out.print("Enter the size (Small, Medium, Large): ");
        String size = scanner.nextLine().trim();
        if (!drinkSizes.containsKey(size)) {
            System.out.println("Invalid size. Please choose from Small, Medium, or Large.");
            return;
        }

        int drinkSize = drinkSizes.get(size);
        double drinkPrice = drinkPrices.get(size);

        List<String> flavors = new ArrayList<>();
        if (flavor.equalsIgnoreCase("Mixed")) {
            System.out.print("Enter the flavors for the mixed drink (e.g., Strawberry,Banana): ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(",");
            for (String part : parts) {
                String trimmedPart = part.trim();
                if (trimmedPart.equalsIgnoreCase("Strawberry") || trimmedPart.equalsIgnoreCase("Banana") || trimmedPart.equalsIgnoreCase("Mango")) {
                    flavors.add(trimmedPart);
                } else {
                    System.out.println("Invalid flavor: " + trimmedPart + ".  Only Strawberry, Banana, and Mango are allowed.");
                    return; // Stop the sale if an invalid flavor is entered
                }
            }
            if (flavors.isEmpty()) {
                System.out.println("At least one valid flavor must be entered for a mixed drink.");
                return;
            }

        } else {
            flavors.add(flavor);
        }

        Map<String, Integer> requiredIngredients = new HashMap<>();

        // Calculate ingredients, handle mixed drinks
        double totalFruitGrams = 0;
        for (String f : flavors) {
            int fruitGrams = 0;
            switch (f.toLowerCase()) {
                case "strawberry":
                    fruitGrams = (int) Math.ceil((drinkSize / 100.0) * STRAWBERRY_PER_100ML);
                    break;
                case "banana":
                    fruitGrams = (int) Math.ceil((drinkSize / 100.0) * BANANA_PER_100ML);
                    break;
                case "mango":
                    fruitGrams = (int) Math.ceil((drinkSize / 100.0) * MANGO_PER_100ML);
                    break;
            }
            totalFruitGrams += fruitGrams;
            requiredIngredients.put(f, fruitGrams); // Store for checking
        }

        int requiredIceMl = (int) Math.ceil((drinkSize / 100.0) * BASE_ICE_ML);
        int requiredMilkMl = (int) Math.ceil((drinkSize / 100.0) * BASE_MILK_ML);
        int requiredSugarGrams = (int) Math.ceil((drinkSize / 100.0) * BASE_SUGAR_GRAMS);

        requiredIngredients.put("Ice", requiredIceMl);
        requiredIngredients.put("Condensed Milk", requiredMilkMl);
        requiredIngredients.put("Sugar", requiredSugarGrams);

        // Check if there are enough ingredients
        for (Map.Entry<String, Integer> entry : requiredIngredients.entrySet()) {
            String ingredient = entry.getKey();
            Integer requiredAmount = entry.getValue();
            if (ingredient.equalsIgnoreCase("Strawberry") || ingredient.equalsIgnoreCase("Banana") || ingredient.equalsIgnoreCase("Mango")) {
                if (inventory.get(ingredient) < requiredAmount) {
                    System.out.println("Insufficient " + ingredient + " to make the drink.");
                    return;
                }
            }
            else if (inventory.get(ingredient) < requiredAmount) {
                System.out.println("Insufficient " + ingredient + " to make the drink.");
                return;
            }
        }

        // Reduce the inventory
        for (Map.Entry<String, Integer> entry : requiredIngredients.entrySet()) {
            String ingredient = entry.getKey();
            Integer requiredAmount = entry.getValue();
             if (ingredient.equalsIgnoreCase("Strawberry") || ingredient.equalsIgnoreCase("Banana") || ingredient.equalsIgnoreCase("Mango")){
                 inventory.put(ingredient, inventory.get(ingredient) - requiredAmount);
             }
             else{
                inventory.put(ingredient, inventory.get(ingredient) - requiredAmount);
             }
        }

        // 5. Daily sales tracking
        String salesKey = flavor + " (" + size + ")"; // e.g., "Strawberry (Medium)"
        dailySales.put(salesKey, dailySales.getOrDefault(salesKey, 0) + 1);

        System.out.println("Sold a " + drinkSize + "ml " + flavor + " drink (" + size + ").");
        System.out.println("Price: $" + drinkPrice);
        System.out.println("Remaining ingredients:");
        listInventory();
    }

    // 1. Provide a warning when any ingredient gets below the level required to make 4 more drinks
    private static void checkLowInventory() {
        System.out.println("\nChecking for low inventory...");
        final int MIN_DRINKS = 4;
        Map<String, Integer> requiredFor4Drinks = new HashMap<>();

        // Calculate ingredients needed for 4 drinks of the largest size.
        int maxDrinkSize = Collections.max(drinkSizes.values());

        requiredFor4Drinks.put("Ice", (int) Math.ceil((maxDrinkSize / 100.0) * BASE_ICE_ML) * MIN_DRINKS);
        requiredFor4Drinks.put("Condensed Milk", (int) Math.ceil((maxDrinkSize / 100.0) * BASE_MILK_ML) * MIN_DRINKS);
        requiredFor4Drinks.put("Sugar", (int) Math.ceil((maxDrinkSize / 100.0) * BASE_SUGAR_GRAMS) * MIN_DRINKS);
        requiredFor4Drinks.put("Strawberry", (int) Math.ceil((maxDrinkSize / 100.0) * STRAWBERRY_PER_100ML) * MIN_DRINKS);
        requiredFor4Drinks.put("Banana", (int) Math.ceil((maxDrinkSize / 100.0) * BANANA_PER_100ML) * MIN_DRINKS);
        requiredFor4Drinks.put("Mango", (int) Math.ceil((maxDrinkSize / 100.0) * MANGO_PER_100ML) * MIN_DRINKS);

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            String ingredient = entry.getKey();
            Integer currentAmount = entry.getValue();
            if (requiredFor4Drinks.containsKey(ingredient)) {
                if (currentAmount < requiredFor4Drinks.get(ingredient)) {
                    System.out.println("Warning: " + ingredient + " is below the level required to make 4 more drinks!  Current: " + currentAmount + ", Required: " + requiredFor4Drinks.get(ingredient));
                }
            }
        }
    }

    // 5. Allow sales over time and provide a report of daily sales
    private static void showDailySales() {
        System.out.println("\nDaily Sales Report for " + currentDate + ":");
        if (dailySales.isEmpty()) {
            System.out.println("No drinks sold today.");
        } else {
            for (Map.Entry<String, Integer> entry : dailySales.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " drinks");
            }
        }
    } 
}
