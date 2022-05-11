import Shop.GroceryStore.Calculator.CalculatorPrice;
import Shop.GroceryStore.Calculator.CalculatorProducts;
import Shop.GroceryStore.GroceryStoreApp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

public class GroceryStoreAppTestMockito {
    private final GroceryStoreApp app = new GroceryStoreApp();

    @Test
    public void shoppingCartCountTest() {
        CalculatorProducts calculatorProducts = Mockito.mock(CalculatorProducts.class);
        app.calculatorProducts = calculatorProducts;
        app.calculatorPrice = new CalculatorPrice();

        Map<String, Integer> mockOutput = new HashMap<>();
        mockOutput.put("A", 3);
        mockOutput.put("B", 2);
        mockOutput.put("C", 1);
        mockOutput.put("D", 1);

        String input = "ABCDABA";
        double output = 13.25;

        Mockito.when(calculatorProducts.numberOfItemsInTheCart(input)).thenReturn(mockOutput);
        Assertions.assertEquals(output, app.calculateTotalCost(input));
    }

    @Test
    public void totalPurchaseCostTest() {
        CalculatorPrice calculatorPrice = Mockito.mock(CalculatorPrice.class);
        app.calculatorProducts = new CalculatorProducts();
        app.calculatorPrice = calculatorPrice;

        Map<String, Integer> mockInput = new HashMap<>();
        mockInput.put("A", 3);
        mockInput.put("B", 2);
        mockInput.put("C", 1);
        mockInput.put("D", 1);

        String input = "ABCDABA";
        double output = 13.25;

        Mockito.when(calculatorPrice.price(mockInput)).thenReturn(output);
        Assertions.assertEquals(output, app.calculateTotalCost(input));
    }
}