public enum Products {
    A(1.25, 3, 3),
    B(4.25, 0, 0),
    C(1,    6, 5),
    D(0.75, 0, 0);

    private final double price;
    private final int amount;
    private final double promoPrice;

    Products(double price, int amount, double promoPrice) {
        this.price = price;
        this.amount = amount;
        this.promoPrice = promoPrice;
    }

    public double getPrice() {
        return price;
    }
    public double getAmount() {
        return amount;
    }
    public double getPromoPrice() {
        return promoPrice;
    }
}