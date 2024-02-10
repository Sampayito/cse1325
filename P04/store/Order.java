import store;
import java.util.ArrayList;

public class Order {
    private static int nextOrderNumber;
    private int orderNumber;
    private ArrayList<Item> items;
    private final Customer customer;
    
    public Order(Customer customer) {
        this.customer = customer;
    }
    public additem(Item item) {
        
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
        
    }
}
