package store;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Item {
    private Product product;
    private int quantity;
    
    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    public Item(BufferedReader br) throws IOException {
        String productType = br.readLine();
        if(productType.equals("Plant")) {
            product = new Plant(br);
        }
        else if(productType.equals("Tool")) {
            product = new Tool(br);
        }
        quantity = Integer.parseInt(br.readLine());
    }
    public void save(BufferedWriter bw) throws IOException {
        bw.write(product.getClass().getSimpleName() + "\n");
        product.save(bw);
        bw.write(quantity + "\n");
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
