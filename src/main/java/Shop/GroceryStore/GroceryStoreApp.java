package Shop.GroceryStore;

import Shop.GroceryStore.Calculator.CalculatorPrice;
import Shop.GroceryStore.Calculator.CalculatorProducts;

import java.util.Map;

public class GroceryStoreApp {
    public static double calculateTotalCost(String products) {
        Map<String, Integer> shoppingCart = CalculatorProducts.numberOfItemsInTheCart(products);
        return CalculatorPrice.price(shoppingCart);
    }

    public static void main(String[] args) {
        System.out.println(calculateTotalCost("ABCDABA"));
    }
}