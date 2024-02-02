public class Item {
    private Product product;
    private int quantity;
    
    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    public int getPrice() {
        return quantity * product.getPrice();
    }
    @Override
    public String toString() {
        String quantitystr = String.format("%3d", quantity);
        String productstr = String.format("%-40s", product);
        int price = getPrice();
        int dollars = price / 100;
        int cents = price % 100;
        String itemprice = String.format("%5d.%02d", dollars, cents);
        return "" + quantitystr + " " + productstr + " $ " + itemprice;
    }
}
