package Shop.GroceryStore.Calculator;

import Shop.GroceryStore.Products.Product;
import Shop.GroceryStore.Products.Products;

import java.util.HashMap;

public class CalculatorProducts {

    public HashMap<String, Integer> productsCountingInCart(String basket, Products products) {
        HashMap<String, Integer> units = new HashMap<>();
        char[] titles = basket.toCharArray();
        for (char unit : titles) {
            String title = String.valueOf(unit);
            Product product = products.getProductByName(title);
            if (product != null) {
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