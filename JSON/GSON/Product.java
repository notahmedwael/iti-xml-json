public class Product {
    private String name;
    private double price;
    private boolean inStock;

    // No-argument constructor for Gson
    public Product() {}

    public Product(String name, double price, boolean inStock) {
        this.name = name;
        this.price = price;
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "Product [Name=" + name + ", Price=" + price + ", InStock=" + inStock + "]";
    }
}