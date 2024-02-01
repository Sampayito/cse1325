public class Product {
    private static int nextStockNumber = 0;
    private int stockNumber;
    private String name;
    private int price;
    
    public Product(String name, int price) {
        if (price < 0) {
            throw new IllegalArgumentException("Invalid price of " + name + ": " + price);
        }
        stockNumber = nextStockNumber++;
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
        name = String.format("%-30s", name);
        int dollars = price / 100;
        int cents = price % 100;
        String pricestr = String.format("%5d.%02d", dollars, cents);
        return name + " $ " + pricestr;
    }
}
