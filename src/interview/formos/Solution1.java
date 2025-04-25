package interview.formos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

enum FRUIT {
    STRAWBERRY(1),
    BANANA(2),
    MANGO(3),
    ICE(4),
    MILK(5),
    SUGAR(6);


    private final int fruitValue;

    FRUIT(int fruitValue) {
        this.fruitValue = fruitValue;
    }

    public int getFruitValue() {
        return fruitValue;
    }

    public static FRUIT fromValue(int value) {
        for (FRUIT fruit : FRUIT.values()) {
            if (fruit.getFruitValue() == value) {
                return fruit;
            }
        }
        throw new IllegalArgumentException("Invalid fruit value: " + value);
    }
}

public class Solution1 {


    //variables
    private int mlOfIcePer100MlOfFruitDrink = 30;
    private int mlOfMilkPer100MlOfFruitDrink = 20;
    private int mlOfSugarPer100MlOfFruitDrink = 8;
    private int grOfStraberryPer100Ml = 100; 
    private int grOfBananaPer100Ml = 120;    
    private int grOfMangoPer100Ml = 140; 
    private int sizeOfDrink = 300;
    
    private Map<String, Integer> inventoryOfIngredients = new HashMap<>();

     // Constructor
     public Solution1() {
        // 1. Hardcode the vendor's starting inventory of ingredients
        
        inventoryOfIngredients.put(FRUIT.STRAWBERRY.toString(), 10000); 
        inventoryOfIngredients.put(FRUIT.BANANA.toString(), 10000);    
        inventoryOfIngredients.put(FRUIT.MANGO.toString(), 10000);     
        inventoryOfIngredients.put(FRUIT.ICE.toString(), 10000);       
        inventoryOfIngredients.put(FRUIT.MILK.toString(), 10000); 
        inventoryOfIngredients.put(FRUIT.SUGAR.toString(), 10000);  
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Solution1 vendingMachine = new Solution1();

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. List Inventory");
            System.out.println("2. Sell Drink");
            System.out.print("Please select an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine()); 
            } catch (NumberFormatException e) {
                scanner.close();
                break;
            }

            switch (choice) {
                case 1:
                    vendingMachine.listInventory();
                    break;
                case 2:
                    vendingMachine.sellDrink(scanner);
                    break;
                default:
                    System.out.println("closing the application.");
                    scanner.close();
                    return;
            }
        }
    }

    // 2. Provide a function to list the vendor's current inventory of ingredients
    private void listInventory() {
        System.out.println("=========================");
        System.out.println("INVENTORY OF INGREDIENTS:");
        for (Map.Entry<String, Integer> entry : inventoryOfIngredients.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // 3. Allow the vendor to sell a drink and reduce inventory accordingly,
    private void sellDrink(Scanner scanner) {
        System.out.print("Enter the number of the fruit: 1 -> Strawberry, 2 -> Banana, 3 ->  Mango): ");
        int choice = Integer.parseInt(scanner.nextLine()); 

        // Calculate the required ingredients for the drink
        int requiredFruitGrams = 0;
        if (choice == FRUIT.STRAWBERRY.getFruitValue()) {
            requiredFruitGrams = (int) Math.ceil((sizeOfDrink / 100.0) * grOfStraberryPer100Ml);
        } else if (choice == FRUIT.BANANA.getFruitValue()) {
            requiredFruitGrams = (int) Math.ceil((sizeOfDrink / 100.0) * grOfBananaPer100Ml);
        } else if (choice == FRUIT.MANGO.getFruitValue()) {
            requiredFruitGrams = (int) Math.ceil((sizeOfDrink / 100.0) * grOfMangoPer100Ml);
        } else {
            System.out.println("Invalid choice. Please select a valid fruit.");
            return;
        }
        int requiredIceMl = (int) Math.ceil((sizeOfDrink / 100.0) * mlOfIcePer100MlOfFruitDrink);
        int requiredMilkMl = (int) Math.ceil((sizeOfDrink / 100.0) * mlOfMilkPer100MlOfFruitDrink);
        int requiredSugarGrams = (int) Math.ceil((sizeOfDrink / 100.0) * mlOfSugarPer100MlOfFruitDrink);

        System.out.println("Required ingredients for " + FRUIT.fromValue(choice).toString().toLowerCase() + " drink:");


    // 4. Deny a sale when there are not enough ingredients to make the drink
        // Check if there are enough ingredients
        if (inventoryOfIngredients.get(FRUIT.fromValue(choice).toString()) < requiredFruitGrams ||
                inventoryOfIngredients.get(FRUIT.ICE.toString()) < requiredIceMl ||
                inventoryOfIngredients.get(FRUIT.MILK.toString()) < requiredMilkMl ||
                inventoryOfIngredients.get(FRUIT.SUGAR.toString()) < requiredSugarGrams) {
            System.out.println("Insufficient ingredients to make the drink.");
            System.out.println("Cannot sell " + FRUIT.fromValue(choice) + " drink.");
            return;
        }

        // Reduce the inventory
        inventoryOfIngredients.put(FRUIT.fromValue(choice).toString(), inventoryOfIngredients.get(FRUIT.fromValue(choice).toString()) - requiredFruitGrams);
        inventoryOfIngredients.put(FRUIT.ICE.toString(), inventoryOfIngredients.get(FRUIT.ICE.toString()) - requiredIceMl);
        inventoryOfIngredients.put(FRUIT.MILK.toString(), inventoryOfIngredients.get(FRUIT.MILK.toString()) - requiredMilkMl);
        inventoryOfIngredients.put(FRUIT.SUGAR.toString(), inventoryOfIngredients.get(FRUIT.SUGAR.toString()) - requiredSugarGrams);

        System.out.println("Sold a " + sizeOfDrink + "ml " + choice + " drink.");
    }   
    
   
}
