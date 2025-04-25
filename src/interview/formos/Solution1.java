package interview.formos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

enum FRUIT {
    STRAWBERRY(1),
    BANANA(2),
    MANGO(3);

    private final int fruitValue;
    
    FRUIT(int fruitValue) {
        this.fruitValue = fruitValue;
    }

    public int getFruitValue() {
        return fruitValue;
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

    private Map<Integer, String> fruits = new HashMap<>();

     // Constructor
     public Solution1() {
        // 1. Hardcode the vendor's starting inventory of ingredients
        
        inventoryOfIngredients.put("strawberry", 10000); 
        inventoryOfIngredients.put("banana", 10000);    
        inventoryOfIngredients.put("mango", 10000);     
        inventoryOfIngredients.put("ice", 10000);       
        inventoryOfIngredients.put("milk", 10000); 
        inventoryOfIngredients.put("sugar", 10000);  
        
        fruits.put(1, "strawberry");
        fruits.put(2, "banana");
        fruits.put(3, "mango");
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
    // 4. Deny a sale when there are not enough ingredients to make the drink
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

        // Check if there are enough ingredients
        if (inventoryOfIngredients.get(fruits.get(choice)) < requiredFruitGrams ||
                inventoryOfIngredients.get("ice") < requiredIceMl ||
                inventoryOfIngredients.get("milk") < requiredMilkMl ||
                inventoryOfIngredients.get("sugar") < requiredSugarGrams) {
            System.out.println("Insufficient ingredients to make the drink.");
            System.out.println("Cannot sell " + fruits.get(choice) + " drink.");
            return;
        }

        // Reduce the inventory
        inventoryOfIngredients.put(fruits.get(choice), inventoryOfIngredients.get(fruits.get(choice)) - requiredFruitGrams);
        inventoryOfIngredients.put("ice", inventoryOfIngredients.get("ice") - requiredIceMl);
        inventoryOfIngredients.put("milk", inventoryOfIngredients.get("milk") - requiredMilkMl);
        inventoryOfIngredients.put("sugar", inventoryOfIngredients.get("sugar") - requiredSugarGrams);

        System.out.println("Sold a " + sizeOfDrink + "ml " + choice + " drink.");
    }   
    
   
}
