package Shop.GroceryStore.Calculator;

import Shop.GroceryStore.Products.Product;
import Shop.GroceryStore.Products.Products;

import java.lang.reflect.Field;
import java.util.Map;

public class CalculatorPrice {
    public static double price(Map<String, Integer> shoppingCart) {
        double price = 0;
        Products data = new Products();
        Field[] products = Products.class.getDeclaredFields();
        for (Field field : products) {
            Product product = data.getField(field.getName());
            int action = product.getQuantitySelling();
            int amountProduct = shoppingCart.get(field.getName());
            if (action == 0 | action > amountProduct) {
                price += amountProduct * product.getPrice();
            } else {
                int whole = amountProduct / action;
                int remainder = amountProduct % action;
                price += whole * product.getPromoPrice() + remainder * product.getPrice();
            }
        }
        return price;
    }
}