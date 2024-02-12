package store;
import java.util.ArrayList;

public class Order {
    private static int nextOrderNumber = 1;
    private int orderNumber;
    private ArrayList<Item> items;
    private final Customer customer;
    
    public Order(Customer customer) {
        orderNumber = nextOrderNumber++;
	this.customer = customer;
	this.items = new ArrayList<>();
    }
    public void addItem(Item item) {
        items.add(item);
    }
    public int getPrice() {
        int sum = 0;
        for (Item i: items) {
            sum += i.getPrice();
        }
        return sum;
    }
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

