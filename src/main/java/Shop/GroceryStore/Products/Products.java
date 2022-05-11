package Shop.GroceryStore.Products;

import java.util.List;

public class Products {
    //we have to use the private access type and getters/setters for access
    //80% on your job interview someone will ask you about OOP paradigm, encapsulation is one of them
    public List<Product> products;

    public Products() {
        products = List.of(
                new Product() {{
                    setName("A");
                    setPrice(1.25);
                    setQuantitySelling(3);
                    setPromoPrice(3.00);
                }},
                new Product() {{
                    setName("B");
                    setPrice(4.25);
                    setQuantitySelling(0);
                    setPromoPrice(0.00);
                }},
                new Product() {{
                    setName("C");
                    setPrice(1.00);
                    setQuantitySelling(6);
                    setPromoPrice(5.00);
                }},
                new Product() {{
                    setName("D");
                    setPrice(0.75);
                    setQuantitySelling(0);
                    setPromoPrice(0.00);
                }}
        );
    }

    public Product getProduct(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public boolean isProduct(String name) {
        if (getProduct(name) != null) {
            return true;
        } else {
            return false;
        }
    }
}