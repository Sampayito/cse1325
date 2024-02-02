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
        String itemprice = String.format("%5d", getPrice());
        return "" + quantitystr + " " + productstr + " $ " + itemprice;
    }
}
