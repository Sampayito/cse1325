package store;
import java.util.ArrayList;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Store {
    private String name;
    private ArrayList<Customer> customers;
    private ArrayList<Product> products;
    private ArrayList<Order> orders;
    
    public Store(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
        this.products = new ArrayList<>();
        this.orders = new ArrayList<>();
    }
    
    public Store(BufferedReader br) throws IOException {
        this.name = br.readLine();
        int size = Integer.parseInt(br.readLine());
        this.customers = new ArrayList<>();
        while(size-- > 0) {
            customers.add(new Customer(br));
        }
        size = Integer.parseInt(br.readLine());
        this.products = new ArrayList<>();
        while(size-- > 0) {
            String productType = br.readLine();
            if(productType.equals("Plant")) {
                products.add(new Plant(br));
            }
            else if(productType.equals("Tool")) {
                products.add(new Tool(br));
            }
        }
        size = Integer.parseInt(br.readLine());
        this.orders = new ArrayList<>();
        while(size-- > 0) {
            orders.add(new Order(br));
        } 
    }
    
    public void save(BufferedWriter bw) throws IOException {
        bw.write(name + "\n");
        bw.write("" + customers.size() + "\n");
        for(Customer c : customers) {
            c.save(bw);
        }
        bw.write("" + products.size() + "\n");
        for(Product p : products) {
            bw.write(p.getClass().getSimpleName() + "\n");
            p.save(bw);
        }
        bw.write("" + orders.size() + "\n");
        for(Order o : orders) {
            o.save(bw);
        }
    }
    
    public String getName() {
        return name;
    }
    
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    public String getCustomerList() {
        StringBuilder customerList = new StringBuilder();
        for (int i = 0; i < customers.size(); i++) {
            customerList.append(i).append("] ").append(customers.get(i).toString()).append("\n");
	    //could have just done customerList.append("" + i + "] " + ...)
        }
        return customerList.toString();
    }
    
    public void addProduct(Product product) {
        products.add(product);
    }
    public String getProductList() {
        StringBuilder productList = new StringBuilder();
        for (int i = 0; i < products.size(); i++) {
            productList.append(i).append("] ").append(products.get(i).toString()).append("\n");
        }
        return productList.toString();
    }
    
    public int newOrder(int customerIndex) {
        Customer customer = customers.get(customerIndex);
        Order order = new Order(customer);
        orders.add(order);
        return orders.indexOf(order);     
    }
    public void addToOrder(int orderIndex, int productIndex, int quantity) {
        Product product = products.get(productIndex);
        Item item = new Item(product, quantity);
        Order order = orders.get(orderIndex);
        order.addItem(item);
    }
    public String getOrderList() {
        StringBuilder orderList = new StringBuilder();
        for (int i = 0; i < orders.size(); i++) {
            orderList.append(i).append("] ").append(orders.get(i).toString()).append("\n");
        }
        return orderList.toString();
    }
}
