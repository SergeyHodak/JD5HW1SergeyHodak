package Shop.GroceryStore.Products;

import lombok.Data;

@Data
public class Product {
    private String name;
    private double price;
    private int quantityOfGoodsThatActivateThePromotion;
    private double promoPrice;
}