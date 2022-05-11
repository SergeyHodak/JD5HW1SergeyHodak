package Shop.GroceryStore.Calculator;

import Shop.GroceryStore.Products.Product;
import Shop.GroceryStore.Products.Products;

import java.util.Map;

public class CalculatorPrice {
    public double price(Map<String, Integer> shoppingCart) {
        double price = 0;
        for (Product product : new Products().products) {
            if (shoppingCart.containsKey(product.getName())) {
                int action = product.getQuantitySelling();
                int amountProduct = shoppingCart.get(product.getName());
                if (action == 0 | action > amountProduct) {
                    price += amountProduct * product.getPrice();
                } else {
                    int whole = amountProduct / action;
                    int remainder = amountProduct % action;
                    price += whole * product.getPromoPrice() + remainder * product.getPrice();
                }
            }
        }
        return price;
    }
}