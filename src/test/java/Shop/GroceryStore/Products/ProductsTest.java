package Shop.GroceryStore.Products;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductsTest {

    @Test
    public void addProductInShopTest() {
        Products products = new Products();
        products.addProductInShop("E", 10, 0, 0);
        products.addProductInShop("A",3,30,300);

        Product output0 = new Product();
        output0.setName("E");
        output0.setPrice(10);
        output0.setQuantityOfGoodsThatActivateThePromotion(0);
        output0.setPromoPrice(0);

        Product output1 = new Product();
        output1.setName("A");
        output1.setPrice(1.25);
        output1.setQuantityOfGoodsThatActivateThePromotion(3);
        output1.setPromoPrice(3);

        Assertions.assertEquals(output0, products.getProductByName("E"));
        Assertions.assertEquals(output1, products.getProductByName("A"));
    }

    @Test
    public void updatePriceTest() {
        Products products = new Products();
        products.updatePrice("A", 2);

        Product output = new Product();
        output.setName("A");
        output.setPrice(2);
        output.setQuantityOfGoodsThatActivateThePromotion(3);
        output.setPromoPrice(3);

        Assertions.assertEquals(output, products.getProductByName("A"));

        products.updatePrice("E", 2);
        Assertions.assertNull(products.getProductByName("E"));
    }

    @Test
    public void updateQuantityOfGoodsThatActivateThePromotionTest() {
        Products products = new Products();
        products.updateQuantityOfGoodsThatActivateThePromotion("A", 2);

        Product output = new Product();
        output.setName("A");
        output.setPrice(1.25);
        output.setQuantityOfGoodsThatActivateThePromotion(2);
        output.setPromoPrice(3);

        Assertions.assertEquals(output, products.getProductByName("A"));

        products.updateQuantityOfGoodsThatActivateThePromotion("E", 2);
        Assertions.assertNull(products.getProductByName("E"));
    }

    @Test
    void updatePromoPriceTest() {
        Products products = new Products();
        products.updatePromoPrice("A", 20);

        Product output = new Product();
        output.setName("A");
        output.setPrice(1.25);
        output.setQuantityOfGoodsThatActivateThePromotion(3);
        output.setPromoPrice(20);

        Assertions.assertEquals(output, products.getProductByName("A"));

        products.updatePromoPrice("E", 20);
        Assertions.assertNull(products.getProductByName("E"));
    }

    @Test
    void removeProductFromStoreTest() {
        Products products = new Products();
        products.removeProductFromStore("A");

        Product output = new Product();
        output.setName("B");
        output.setPrice(4.25);
        output.setQuantityOfGoodsThatActivateThePromotion(0);
        output.setPromoPrice(0);

        Assertions.assertEquals(output, products.getProductByName("B"));
        Assertions.assertNull(products.getProductByName("A"));
    }

    @Test
    void getProductByNameTest() {
        Products products = new Products();
        Assertions.assertNotEquals(null, products.getProductByName("C"));
        Assertions.assertNull(products.getProductByName("H"));
    }
}