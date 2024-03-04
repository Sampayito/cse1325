package store;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public abstract class Product {
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
    public Product(BufferedReader br) throws IOException {
        this.name = br.readLine();
        this.price = Integer.parseInt(br.readLine());
        this.stockNumber = Integer.parseInt(br.readLine());
        this.nextStockNumber = Integer.parseInt(br.readLine());
    }
    public void save(BufferedWriter bw) throws IOException {
        bw.write(name + "\n");
        bw.write(price + "\n");
        bw.write(stockNumber + "\n");
        bw.write(nextStockNumber + "\n");
    }
    public int getStockNumber() {
        return stockNumber;
    }
    public int getPrice() {
        return price;
    }
    @Override
    public String toString() {
        name = String.format("%-40s", name);
        int dollars = price / 100;
        int cents = price % 100;
        String pricestr = String.format("%5d.%02d", dollars, cents);
        return name + " $ " + pricestr;
    }
}
