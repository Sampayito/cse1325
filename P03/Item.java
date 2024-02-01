public class Item {
    private Product product;
    private int quantity;
    
    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    public int getPrice() {
        return quantity * product.price;
    }
    @Override
    public String toString() {
        String quantitystr = String.format("%3d", quantity);
        product = String.format("-40s", product);
        String itemprice = String.format("%") //finish this later, im tired
    }
}
