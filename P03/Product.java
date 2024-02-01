public class Product {
    private int nextStockNumber;
    private int stockNumber;
    private String name;
    private int price;
    
    public Product(String name, int price) {
        if (price < 0) {
            throw new IllegalArgumentException("Invalid price of " + name + ": " + price);
        }
        //something with the nextStockNumber
        this.name = name;
        this.price = price;
    }
    public int getStockNumber() {
        return stockNumber;
    }
    public int getPrice() {
        return price;
    }
    @Override
    String toString() {
        return "" + name + " $ " + price;
    }
}
