package Shop.GroceryStore.Calculator;

import Shop.GroceryStore.Products.Products;

import java.util.HashMap;
import java.util.Map;

public class CalculatorProducts {

    //following the name convention the name of a method should be a verb
    public Map<String, Integer> numberOfItemsInTheCart(String products) {
        Map<String, Integer> units = new HashMap<>();
        char[] titles = products.toCharArray();
        for (char unit : titles) {
            String title = String.valueOf(unit);
            if (new Products().isProduct(String.valueOf(unit))) {
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
}