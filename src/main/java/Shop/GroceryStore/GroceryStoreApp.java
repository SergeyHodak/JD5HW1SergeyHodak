package Shop.GroceryStore;

import Shop.GroceryStore.Calculator.CalculatorPrice;
import Shop.GroceryStore.Calculator.CalculatorProducts;
import Shop.GroceryStore.Products.Products;

import java.util.HashMap;

public class GroceryStoreApp {
    private final CalculatorProducts calculatorProducts = new CalculatorProducts();
    private final CalculatorPrice calculatorPrice = new CalculatorPrice();
    private final Products productsInShop = new Products();

    public double calculateTotalCost(String products) {
        HashMap<String, Integer> shoppingCart =
                calculatorProducts.productsCountingInCart(products, productsInShop);
        return calculatorPrice.priceCalculation(shoppingCart, productsInShop);
    }

    public static void main(String[] args) {
        System.out.println(new GroceryStoreApp().calculateTotalCost("ABCDABA"));
    }
}