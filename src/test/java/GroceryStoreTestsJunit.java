import Shop.GroceryStore.Calculator.CalculatorPrice;
import Shop.GroceryStore.Calculator.CalculatorProducts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


//As I mentioned in GroceryStore class it would be great to create more classes and use Mockito library here
public class GroceryStoreTestsJunit {

    @Test
    public void isThisItemRegistered() {
        Map<String, Boolean> products = new LinkedHashMap<>();
        products.put("A", true);
        products.put("B", true);
        products.put("C", true);
        products.put("D", true);
        products.put(" ", false);
        products.put("", false);
        products.put("E", false);
        products.put("\n", false);
        products.forEach((input, output) -> {
            Assertions.assertEquals(output, CalculatorProducts.isItAProduct(input));
        });
    }

    @Test
    public void counterOfItemsInTheCart() {
        Map<String, Integer> products = new LinkedHashMap<>();
        products.put("A", 1);
        products.put("A".repeat(10), 10);
        products.put("A B C D E", 4);
        products.put("", 0);
        products.put("A s d f e 0 9 B", 2);
        products.forEach((input, output) -> {
            int sum = 0;
            for (java.lang.Integer integer : CalculatorProducts.numberOfItemsInTheCart(input).values()) {
                int valueOf = integer;
                sum += valueOf;
            }
            Assertions.assertEquals(output, sum);
        });
    }

    @Test
    public void priceOfOneUniOfGoodsSum() {
        Map<String, Integer> input = new HashMap<>();
        input.put("A", 1);
        input.put("B", 1);
        input.put("C", 1);
        input.put("D", 1);
        double output = 7.25;
        Assertions.assertEquals(output, CalculatorPrice.price(input));
    }

    @Test
    public void theCostOfGoodsNotActivatingThePromotion() {
        Map<String, Integer> input = new HashMap<>();
        input.put("A", 2);
        input.put("B", 30);
        input.put("C", 5);
        input.put("D", 22);
        double output = 151.5;
        Assertions.assertEquals(output, CalculatorPrice.price(input));
    }


    @Test
    public void actionOfPromotionsOnProducts() {
        Map<Map<String, Integer>, Double> testInput = new HashMap<>();

        Map<String, Integer> inputA = new HashMap<>();
        inputA.put("A", 2);
        inputA.put("B", 1);
        inputA.put("C", 7);
        inputA.put("D", 1);
        double outputA = 13.5;
        testInput.put(inputA, outputA);

        Map<String, Integer> inputB = new HashMap<>();
        inputB.put("A", 4);
        inputB.put("B", 1);
        inputB.put("C", 12);
        inputB.put("D", 1);
        double outputB = 19.25;
        testInput.put(inputB, outputB);

        testInput.forEach((input, output) -> {
            Assertions.assertEquals(output, CalculatorPrice.price(input));
        });
    }
}