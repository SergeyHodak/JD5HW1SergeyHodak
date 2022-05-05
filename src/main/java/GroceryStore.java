import java.util.*;

public class GroceryStore {
    public static double calculateTotalCost(String data) {
        Map<Character, Integer> units = new LinkedHashMap<>();
        char[] products = data.toCharArray();
        for (char unit:products) {
            if (isPresent(String.valueOf(unit))) {
                if (units.containsKey(unit)) {
                    Integer amount = units.get(unit);
                    units.put(unit, amount + 1);
                } else {
                    units.put(unit, 1);
                }
            }
        }

        double result = 0;
        Set<Character> characters = units.keySet();
        for (Character character:characters) {
            Products unit = Products.valueOf(String.valueOf(character));
            if (unit.getAmount() == 0) {
                result += units.get(character)*unit.getPrice();
            } else if (units.get(character) < unit.getAmount()){
                result += units.get(character)*unit.getPrice();
            } else {
                int whole = (int) (units.get(character)/unit.getAmount());
                int remainder = (int) (units.get(character)%unit.getAmount());
                result += whole * unit.getPromoPrice() + remainder * unit.getPrice();
            }
        }
        return  result;
    }

    private static boolean isPresent(String data) {
        try {
            Enum.valueOf(Products.class, data);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(calculateTotalCost("ABCDABA"));
    }
}