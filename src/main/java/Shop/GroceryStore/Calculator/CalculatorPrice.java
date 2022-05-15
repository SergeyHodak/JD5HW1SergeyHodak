package Shop.GroceryStore.Calculator;

import Shop.GroceryStore.Products.Product;
import Shop.GroceryStore.Products.Products;

import java.util.HashMap;

public class CalculatorPrice {
    public double priceCalculation(HashMap<String, Integer> shoppingCart, Products products) {
        double price = 0;
        for (Product product : products.getProducts()) {
            String nameProduct = product.getName();
            if (shoppingCart.containsKey(nameProduct)) {
                int action = product.getQuantityOfGoodsThatActivateThePromotion();
                int amountProduct = shoppingCart.get(nameProduct);
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