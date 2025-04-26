package interview.formos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

enum INGREDIENTS {
    STRAWBERRY(1),
    BANANA(2),
    MANGO(3),
    MIXED(4),
    ICE(5),
    MILK(6),
    SUGAR(7);

    private final int ingredientValue;

    INGREDIENTS(int ingredientValue) {
        this.ingredientValue = ingredientValue;
    }

    public int getIngredientValue() {
        return ingredientValue;
    }

    public static INGREDIENTS fromValue(int value) {
        for (INGREDIENTS ingredient : INGREDIENTS.values()) {
            if (ingredient.getIngredientValue() == value) {
                return ingredient;
            }
        }
        throw new IllegalArgumentException("Invalid fruit value: " + value);
    }
}

enum SIZE {
    SMALL(1),
    MEDIUM(2),
    LARGE(3);

    private final int sizeValue;

    SIZE(int sizeValue) {
        this.sizeValue = sizeValue;
    }

    public int getSizeValue() {
        return sizeValue;
    }

    public static SIZE fromValue(int value) {
        for (SIZE size : SIZE.values()) {
            if (size.getSizeValue() == value) {
                return size;
            }
        }
        throw new IllegalArgumentException("Invalid size value: " + value);
    }
}

public class Solution1 {

    // variables
    private int mlOfIcePer100MlOfFruitDrink = 30;
    private int mlOfMilkPer100MlOfFruitDrink = 20;
    private int mlOfSugarPer100MlOfFruitDrink = 8;
    private int grOfStraberryPer100Ml = 100;
    private int grOfBananaPer100Ml = 120;
    private int grOfMangoPer100Ml = 140;
    private int sizeOfDrink = 300;

    private Map<String, Integer> inventoryOfIngredients = new HashMap<>();

    // (optional) 3. Allow the vendor to sell 3 sizes (small, medium, and large)
    private static final Map<String, Integer> drinkSizes = new HashMap<>();

    // (optional) 4. Provide costs for each ingredient and set prices for each drink
    // to ensure she makes a profit
    private static final Map<String, Double> drinkPrices = new HashMap<>();

    // 5. Allow sales over time and provide a report of daily sales
    private static final Map<String, Integer> dailySales = new HashMap<>(); // <Flavor, Quantity>
    private static String currentDate = java.time.LocalDate.now().toString();

    // Constructor
    public Solution1() {
        // 1. Hardcode the vendor's starting inventory of ingredients

        inventoryOfIngredients.put(INGREDIENTS.STRAWBERRY.toString(), 10000);
        inventoryOfIngredients.put(INGREDIENTS.BANANA.toString(), 10000);
        inventoryOfIngredients.put(INGREDIENTS.MANGO.toString(), 10000);
        inventoryOfIngredients.put(INGREDIENTS.ICE.toString(), 10000);
        inventoryOfIngredients.put(INGREDIENTS.MILK.toString(), 10000);
        inventoryOfIngredients.put(INGREDIENTS.SUGAR.toString(), 100);

        drinkSizes.put(SIZE.SMALL.toString(), 200);
        drinkSizes.put(SIZE.MEDIUM.toString(), 300);
        drinkSizes.put(SIZE.LARGE.toString(), 400);

        drinkPrices.put(SIZE.SMALL.toString(), 2.50);
        drinkPrices.put(SIZE.MEDIUM.toString(), 3.50);
        drinkPrices.put(SIZE.LARGE.toString(), 4.50);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Solution1 vendingMachine = new Solution1();

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. List Inventory");
            System.out.println("2. Sell Drink");
            System.out.println("3. Show Daily Sales");
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
                case 3:
                    vendingMachine.showDailySales();
                    break;
                default:
                    System.out.println("closing the application.");
                    scanner.close();
                    return;
            }
            String today = java.time.LocalDate.now().toString();
            if (!today.equals(currentDate)) {
                dailySales.clear();
                currentDate = today;
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

        checkLowInventory();
    }

    // 3. Allow the vendor to sell a drink and reduce inventory accordingly,
    private void sellDrink(Scanner scanner) {
        System.out.print("Enter the number of the fruit (1 -> Strawberry, 2 -> Banana, 3 ->  Mango, 4 -> Mixed): ");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice != INGREDIENTS.STRAWBERRY.getIngredientValue() && choice != INGREDIENTS.BANANA.getIngredientValue()
                &&
                choice != INGREDIENTS.MANGO.getIngredientValue() && choice != INGREDIENTS.MIXED.getIngredientValue()) {
            System.out.println("Invalid flavor. Please choose from Strawberry, Banana, Mango, or Mixed.");
            return;
        }

        System.out.print("Enter the size (1 -> small, 2 -> medium, 3 -> large): ");
        int size = Integer.parseInt(scanner.nextLine().trim());

        if (size != SIZE.SMALL.getSizeValue() && size != SIZE.MEDIUM.getSizeValue() &&
                size != SIZE.LARGE.getSizeValue()) {
            System.out.println("Invalid size. Please choose from small, medium or large.");
            return;
        }

        double drinkPrice = drinkPrices.get(SIZE.fromValue(size).toString());

        List<Integer> flavors = new ArrayList<>();
        if (choice == INGREDIENTS.MIXED.getIngredientValue()) {
            System.out.print(
                    "Enter the flavors for the mixed drink (1 -> Strawberry, 2 -> Banana, 3 ->  Mango. Example: 1,2): ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(",");
            for (String part : parts) {
                int trimmedPart = Integer.valueOf(part.trim());
                if (trimmedPart == INGREDIENTS.STRAWBERRY.getIngredientValue()
                        || trimmedPart == INGREDIENTS.BANANA.getIngredientValue()
                        || trimmedPart == INGREDIENTS.MANGO.getIngredientValue()) {
                    flavors.add(trimmedPart);
                } else {
                    System.out.println(
                            "Invalid flavor: " + INGREDIENTS.fromValue(trimmedPart)
                                    + ".  Only 1 -> Strawberry, 2 -> Banana, 3 ->  Mango are allowed.");
                    return;
                }
            }
            if (flavors.isEmpty()) {
                System.out.println("At least one valid flavor must be entered for a mixed drink.");
                return;
            }

        } else {
            flavors.add(choice);
        }

        Map<Integer, Integer> requiredIngredients = new HashMap<>();

        for (Integer f : flavors) {
            int requiredFruitGrams = 0;
            if (f == INGREDIENTS.STRAWBERRY.getIngredientValue()) {
                requiredFruitGrams = (int) Math.ceil((sizeOfDrink / 100.0) * grOfStraberryPer100Ml);
            } else if (f == INGREDIENTS.BANANA.getIngredientValue()) {
                requiredFruitGrams = (int) Math.ceil((sizeOfDrink / 100.0) * grOfBananaPer100Ml);
            } else if (f == INGREDIENTS.MANGO.getIngredientValue()) {
                requiredFruitGrams = (int) Math.ceil((sizeOfDrink / 100.0) * grOfMangoPer100Ml);
            } else {
                System.out.println("Invalid choice. Please select a valid fruit.");
                return;
            }
            requiredIngredients.put(f, requiredFruitGrams);
        }

        int requiredIceMl = (int) Math.ceil((sizeOfDrink / 100.0) * mlOfIcePer100MlOfFruitDrink);
        int requiredMilkMl = (int) Math.ceil((sizeOfDrink / 100.0) * mlOfMilkPer100MlOfFruitDrink);
        int requiredSugarGrams = (int) Math.ceil((sizeOfDrink / 100.0) * mlOfSugarPer100MlOfFruitDrink);

        requiredIngredients.put(INGREDIENTS.ICE.getIngredientValue(), requiredIceMl);
        requiredIngredients.put(INGREDIENTS.MILK.getIngredientValue(), requiredMilkMl);
        requiredIngredients.put(INGREDIENTS.SUGAR.getIngredientValue(), requiredSugarGrams);

        for (Map.Entry<Integer, Integer> entry : requiredIngredients.entrySet()) {
            Integer ingredient = entry.getKey();
            Integer requiredAmount = entry.getValue();
            if (ingredient == INGREDIENTS.STRAWBERRY.getIngredientValue()
                    || ingredient == INGREDIENTS.BANANA.getIngredientValue()
                    || ingredient == INGREDIENTS.MANGO.getIngredientValue()
                    || ingredient == INGREDIENTS.ICE.getIngredientValue()
                    || ingredient == INGREDIENTS.MILK.getIngredientValue()
                    || ingredient == INGREDIENTS.SUGAR.getIngredientValue()) {
                if (inventoryOfIngredients.get(INGREDIENTS.fromValue(ingredient).toString()) < requiredAmount) {
                    System.out.println("Insufficient " + INGREDIENTS.fromValue(ingredient) + " to make the drink.");
                    return;
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : requiredIngredients.entrySet()) {
            Integer ingredient = entry.getKey();
            Integer requiredAmount = entry.getValue();
            inventoryOfIngredients.put(INGREDIENTS.fromValue(ingredient).toString(),
                    inventoryOfIngredients.get(INGREDIENTS.fromValue(ingredient).toString()) - requiredAmount);
        }

        System.out.println("Sold a " + drinkSizes.get(SIZE.fromValue(size).toString()) + "ml of "
                + INGREDIENTS.fromValue(choice) + " drink("
                + SIZE.fromValue(size) + ")");
        System.out.println("Price:" + drinkPrice);

        String salesKey = INGREDIENTS.fromValue(choice).toString() + " (" + SIZE.fromValue(size).toString() + ")";
        dailySales.put(salesKey, dailySales.getOrDefault(salesKey, 0) + 1);

    }

    // (optional) Provide a warning when any ingredient gets below the level
    // required to make 4 more drinks
    private void checkLowInventory() {
        System.out.println("\nChecking for low inventory...");
        final int MIN_DRINKS = 4;
        Map<String, Integer> requiredFor4Drinks = new HashMap<>();

        // Calculate ingredients needed for 4 drinks of the largest size.
        requiredFor4Drinks.put(INGREDIENTS.ICE.toString(),
                (int) Math.ceil((sizeOfDrink / 100.0) * mlOfIcePer100MlOfFruitDrink) * MIN_DRINKS);
        requiredFor4Drinks.put(INGREDIENTS.MILK.toString(),
                (int) Math.ceil((sizeOfDrink / 100.0) * mlOfMilkPer100MlOfFruitDrink) * MIN_DRINKS);
        requiredFor4Drinks.put(INGREDIENTS.SUGAR.toString(),
                (int) Math.ceil((sizeOfDrink / 100.0) * mlOfSugarPer100MlOfFruitDrink) * MIN_DRINKS);
        requiredFor4Drinks.put(INGREDIENTS.STRAWBERRY.toString(),
                (int) Math.ceil((sizeOfDrink / 100.0) * grOfStraberryPer100Ml) * MIN_DRINKS);
        requiredFor4Drinks.put(INGREDIENTS.BANANA.toString(),
                (int) Math.ceil((sizeOfDrink / 100.0) * grOfBananaPer100Ml) * MIN_DRINKS);
        requiredFor4Drinks.put(INGREDIENTS.MANGO.toString(),
                (int) Math.ceil((sizeOfDrink / 100.0) * grOfMangoPer100Ml) * MIN_DRINKS);

        for (Map.Entry<String, Integer> entry : inventoryOfIngredients.entrySet()) {
            String ingredient = entry.getKey();
            Integer currentAmount = entry.getValue();
            if (requiredFor4Drinks.containsKey(ingredient)) {
                if (currentAmount < requiredFor4Drinks.get(ingredient)) {
                    System.out.println(
                            "Warning: " + ingredient + " is below the level required to make 4 more drinks!  Current: "
                                    + currentAmount + ", Required: " + requiredFor4Drinks.get(ingredient));
                }
            }
        }
    }

    private void showDailySales() {
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
