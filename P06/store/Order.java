package store;
import java.util.ArrayList;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

/**
  * Encapsulation of a Customer and a set of items the Customer wants to buy.
  *
  * @author		Leonardo Sampayo
  * @version		0.2
  * @since		0.2
  */

public class Order {
    private static int nextOrderNumber = 1;
    private int orderNumber;
    private ArrayList<Item> items;
    private final Customer customer;
    
/**
  * @param		the Customer making the order
  * @since		0.2
  */
    public Order(Customer customer) {
        orderNumber = nextOrderNumber++;
	this.customer = customer;
	this.items = new ArrayList<>();
    }
    
    public Order(BufferedReader br) throws IOException {
        int size = Integer.parseInt(br.readLine());
        this.items = new ArrayList<>();
        while(size-- > 0) {
            items.add(new Item(br));
        }
        this.customer = new Customer(br);
        this.orderNumber = Integer.parseInt(br.readLine());
        this.nextOrderNumber = Integer.parseInt(br.readLine());
    }
    
    public void save(BufferedWriter bw) throws IOException {
        bw.write("" + items.size() + "\n");
        for(Item i : items) {
            i.save(bw);
        }
        customer.save(bw);
        bw.write(orderNumber + "\n");
        bw.write(nextOrderNumber + "\n");
    }

/**
  * @param		the item being added to the items ArrayList
  * @since		0.2
  */
    public void addItem(Item item) {
        items.add(item);
    }

/**
  * @returns		sum of the price of all Items in the items ArrayList	
  * @since		0.2
  */
    public int getPrice() {
        int sum = 0;
        for (Item i: items) {
            sum += i.getPrice();
        }
        return sum;
    }

/**
  * @returns		a String formatted like a receipt	
  * @since		0.2
  */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
	int price = getPrice();
	int dollars = price / 100;
        int cents = price % 100;
        String pricestr = String.format("%5d.%02d", dollars, cents);
        for (Item i: items) {
            sb.append(i.toString()).append("\n  ");
        }
        return "Order #" + orderNumber + " for " + customer + "\n  " + sb + "\nOrder total $" + pricestr;
    }
}

