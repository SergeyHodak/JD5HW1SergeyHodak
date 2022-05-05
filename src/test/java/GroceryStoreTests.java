import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.LinkedHashMap;
import java.util.Map;

public class GroceryStoreTests {

    @Test
    public void priceOfOneUniOfGoods() {
        String actual = "ABCD";
        double expected = 1.25 + 4.25 + 1.0 + 0.75;
        Assertions.assertEquals(expected, GroceryStore.calculateTotalCost(actual));
    }

    @Test
    public void costOfGoodsFor1Unit() {
        Map<String, Double> units = new LinkedHashMap<>();
        units.put("A", 1.25);
        units.put("B", 4.25);
        units.put("C", 1.0);
        units.put("D", 0.75);
        units.forEach((String, Double) -> {
            Assertions.assertEquals(Double, GroceryStore.calculateTotalCost(String));
        });
    }

    @Test
    public void costOfGoodsFor2Units () {
        Map<String, Double> units = new LinkedHashMap<>();
        units.put("AA", 1.25*2);
        units.put("BB", 4.25*2);
        units.put("CC", 1.0*2);
        units.put("DD", 0.75*2);
        units.forEach((String, Double) -> {
            Assertions.assertEquals(Double, GroceryStore.calculateTotalCost(String));
        });
    }

    @Test
    public void actionOfThePromotionOnProductA() {
        Map<String, Double> units = new LinkedHashMap<>();
        units.put("A".repeat(3), 3.0);
        units.put("A".repeat(4), 3.0+1.25);
        units.forEach((String, Double) -> {
            Assertions.assertEquals(Double, GroceryStore.calculateTotalCost(String));
        });
    }

    @Test
    public void actionOfThePromotionOnProductC() {
        Map<String, Double> units = new LinkedHashMap<>();
        units.put("C".repeat(6), 5.0);
        units.put("C".repeat(7), 5.0+1.0);
        units.forEach((String, Double) -> {
            Assertions.assertEquals(Double, GroceryStore.calculateTotalCost(String));
        });
    }
}