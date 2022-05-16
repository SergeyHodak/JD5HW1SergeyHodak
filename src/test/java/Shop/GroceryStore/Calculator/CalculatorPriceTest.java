package Shop.GroceryStore.Calculator;

import Shop.GroceryStore.Products.Product;
import Shop.GroceryStore.Products.Products;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CalculatorPriceTest {

    @Test
    public void priceCalculationTest() {
        CalculatorPrice calculatorPrice = new CalculatorPrice();
        Products products = new Products();
        HashMap<HashMap<String, Integer>, Double> testInput = new HashMap<>();

        HashMap<String, Integer> input0 = new HashMap<>();
        input0.put("A", 1);
        input0.put("B", 1);
        input0.put("C", 1);
        input0.put("D", 1);
        double output0 = 7.25;
        testInput.put(input0, output0);

        HashMap<String, Integer> input1 = new HashMap<>();
        input1.put("A", 2);
        input1.put("B", 30);
        input1.put("C", 5);
        input1.put("D", 22);
        double output1 = 151.5;
        testInput.put(input1, output1);

        HashMap<String, Integer> input2 = new HashMap<>();
        input2.put("A", 2);
        input2.put("B", 1);
        input2.put("C", 7);
        input2.put("D", 1);
        double output2 = 13.5;
        testInput.put(input2, output2);

        HashMap<String, Integer> input3 = new HashMap<>();
        input3.put("A", 4);
        input3.put("B", 1);
        input3.put("C", 12);
        input3.put("D", 1);
        double output3 = 19.25;
        testInput.put(input3, output3);

        testInput.forEach((input, output) -> {
            Assertions.assertEquals(output, calculatorPrice.priceCalculation(input, products));
        });
    }

    @Test
    //actually you don't need to use mockito here because you don't have dependencies, you work in the method
    //with method's attributes. You have just to create the input data and put in the method
    public void priceCalculationTestMockito() {
        CalculatorPrice calculatorPrice = new CalculatorPrice();
        Products products = Mockito.mock(Products.class);

        List<Product> mockOutput = new ArrayList<>();

        Product mockOutputA = new Product();
        mockOutputA.setName("A");
        mockOutputA.setPrice(1.25);
        mockOutputA.setQuantityOfGoodsThatActivateThePromotion(3);
        mockOutputA.setPromoPrice(3);
        mockOutput.add(mockOutputA);

        Product mockOutputB = new Product();
        mockOutputB.setName("B");
        mockOutputB.setPrice(4.25);
        mockOutputB.setQuantityOfGoodsThatActivateThePromotion(0);
        mockOutputB.setPromoPrice(0);
        mockOutput.add(mockOutputB);

        Product mockOutputC = new Product();
        mockOutputC.setName("C");
        mockOutputC.setPrice(1.00);
        mockOutputC.setQuantityOfGoodsThatActivateThePromotion(6);
        mockOutputC.setPromoPrice(5);
        mockOutput.add(mockOutputC);

        Product mockOutputD = new Product();
        mockOutputD.setName("D");
        mockOutputD.setPrice(0.75);
        mockOutputD.setQuantityOfGoodsThatActivateThePromotion(0);
        mockOutputD.setPromoPrice(0);
        mockOutput.add(mockOutputD);
        Mockito.when(products.getProducts()).thenReturn(mockOutput);

        HashMap<HashMap<String, Integer>, Double> testInput = new HashMap<>();

        HashMap<String, Integer> input0 = new HashMap<>();
        input0.put("A", 1);
        input0.put("B", 1);
        input0.put("C", 1);
        input0.put("D", 1);
        double output0 = 7.25;
        testInput.put(input0, output0);

        HashMap<String, Integer> input1 = new HashMap<>();
        input1.put("A", 2);
        input1.put("B", 30);
        input1.put("C", 5);
        input1.put("D", 22);
        double output1 = 151.5;
        testInput.put(input1, output1);

        HashMap<String, Integer> input2 = new HashMap<>();
        input2.put("A", 2);
        input2.put("B", 1);
        input2.put("C", 7);
        input2.put("D", 1);
        double output2 = 13.5;
        testInput.put(input2, output2);

        HashMap<String, Integer> input3 = new HashMap<>();
        input3.put("A", 4);
        input3.put("B", 1);
        input3.put("C", 12);
        input3.put("D", 1);
        double output3 = 19.25;
        testInput.put(input3, output3);

        testInput.forEach((input, output) -> {
            Assertions.assertEquals(output, calculatorPrice.priceCalculation(input, products));
        });
    }
}