package Shop.GroceryStore.Calculator;

import Shop.GroceryStore.Products.Product;
import Shop.GroceryStore.Products.Products;

import java.util.Map;

public class CalculatorPrice {
    //following the name convention the name of a method should be a verb
    public double price(Map<String, Integer> shoppingCart) {
        double price = 0;
        //It's actually a bad practice using new Products() inside method. Each time when we need calculate anything you
        //will create a new object. You should avoid it for example get the products list in method argument
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