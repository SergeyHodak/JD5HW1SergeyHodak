package Shop.GroceryStore;

import Shop.GroceryStore.Calculator.CalculatorPrice;
import Shop.GroceryStore.Calculator.CalculatorProducts;

import java.util.Map;

public class GroceryStoreApp {
    public CalculatorProducts calculatorProducts = new CalculatorProducts();
    public CalculatorPrice calculatorPrice = new CalculatorPrice();

    public double calculateTotalCost(String products) {
        Map<String, Integer> shoppingCart = calculatorProducts.numberOfItemsInTheCart(products);
        return calculatorPrice.price(shoppingCart);
    }

    public static void main(String[] args) {
        System.out.println(new GroceryStoreApp().calculateTotalCost("ABCDABA"));
    }
}