package Shop.GroceryStore.Calculator;

import Shop.GroceryStore.Products.Products;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class CalculatorProductsTest {

    @Test
    public void productsCountingInCartTest() {
        CalculatorProducts calculatorProducts = new CalculatorProducts();
        Products products = new Products();
        HashMap<String, Integer> input = calculatorProducts.productsCountingInCart(" A A A D d d W K J L B C ", products);
        HashMap<String, Integer> output = new HashMap<>();
        output.put("A", 3);
        output.put("B", 1);
        output.put("C", 1);
        output.put("D", 1);
        Assertions.assertEquals(output, input);
    }
}