package Shop.GroceryStore.Calculator;

import Shop.GroceryStore.Products.Products;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class CalculatorProducts {
    public static Map<String, Integer> numberOfItemsInTheCart(String products) {
        Map<String, Integer> units = new HashMap<>();
        char[] titles = products.toCharArray();
        for (char unit : titles) {
            String title = String.valueOf(unit);
            if (isItAProduct(String.valueOf(unit))) {
                if (units.containsKey(title)) {
                    Integer amount = units.get(title);
                    units.put(title, amount + 1);
                } else {
                    units.put(title, 1);
                }
            }
        }
        return units;
    }

    public static boolean isItAProduct(String data) {
        boolean result = false;
        Field[] products = Products.class.getDeclaredFields();
        for (Field product : products) {
            if (product.getName().equals(data)) {
                result = true;
                break;
            }
        }
        return result;
    }
}