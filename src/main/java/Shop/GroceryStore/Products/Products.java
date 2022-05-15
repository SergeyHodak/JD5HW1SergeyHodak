package Shop.GroceryStore.Products;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Products {
    private List<Product> products = new ArrayList<>();

    public Products() {
        addDefaultProductsInShop();
    }

    public void addProductInShop(String nameProduct, double price, int quantityOfGoodsThatActivateThePromotion, double promoPrice) {
        if (isProduct(nameProduct)) {
            System.out.println("Product \"" + nameProduct + "\" is registered. Use the update.");
            return;
        }
        Product product = new Product();
        product.setName(nameProduct);
        product.setPrice(price);
        product.setQuantityOfGoodsThatActivateThePromotion(quantityOfGoodsThatActivateThePromotion);
        product.setPromoPrice(promoPrice);
        products.add(product);
    }

    public void updatePrice(String nameProduct, double price) {
        if (!isProduct(nameProduct)) {
            System.out.println("Product \"" + nameProduct + "\" is not registered. Use the add");
            return;
        }
        Product product = getProductByName(nameProduct);
        product.setPrice(price);
    }

    public void updateQuantityOfGoodsThatActivateThePromotion(String nameProduct, int quantityOfGoodsThatActivateThePromotion) {
        if (!isProduct(nameProduct)) {
            System.out.println("Product \"" + nameProduct + "\" is not registered. Use the add");
            return;
        }
        Product product = getProductByName(nameProduct);
        product.setQuantityOfGoodsThatActivateThePromotion(quantityOfGoodsThatActivateThePromotion);
    }

    public void updatePromoPrice(String nameProduct, double promoPrice) {
        if (!isProduct(nameProduct)) {
            System.out.println("Product \"" + nameProduct + "\" is not registered. Use the add");
            return;
        }
        Product product = getProductByName(nameProduct);
        product.setPromoPrice(promoPrice);
    }

    public void removeProductFromStore(String nameProduct) {
        if (!isProduct(nameProduct)) {
            return;
        }
        products.removeIf(product -> product.getName().equals(nameProduct));
    }

    private boolean isProduct(String name) {
        return getProductByName(name) != null;
    }

    public Product getProductByName(String nameProduct) {
        if (products.size() == 0) {
            return null;
        }
        for (Product product : products) {
            if (product.getName().equals(nameProduct)) {
                return product;
            }
        }
        return null;
    }

    private void addDefaultProductsInShop() {
        addProductInShop("A", 1.25, 3, 3);
        addProductInShop("B", 4.25, 0, 0);
        addProductInShop("C", 1.00, 6, 5);
        addProductInShop("D", 0.75, 0, 0);
    }
}