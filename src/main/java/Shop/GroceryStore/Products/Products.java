package Shop.GroceryStore.Products;

public class Products {
    public Product A = new Product();
    public Product B = new Product();
    public Product C = new Product();
    public Product D = new Product();

    public Products() {
        A.setName("A");
        A.setPrice(1.25);
        A.setQuantitySelling(3);
        A.setPromoPrice(3.00);
        B.setName("B");
        B.setPrice(4.25);
        B.setQuantitySelling(0);
        B.setPromoPrice(0.00);
        C.setName("C");
        C.setPrice(1.00);
        C.setQuantitySelling(6);
        C.setPromoPrice(5.00);
        D.setName("D");
        D.setPrice(0.75);
        D.setQuantitySelling(0);
        D.setPromoPrice(0.00);
    }

    public Product getField(String field) {
        switch (field) {
            case "A": {
                return A;
            }
            case "B": {
                return B;
            }
            case "C": {
                return C;
            }
            case "D": {
                return D;
            }
            default: {
                return new Product();
            }
        }
    }
}