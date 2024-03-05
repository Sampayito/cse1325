package mdi;

import java.util.Scanner;
import store.Store;
import store.Tool;
import store.Exposure;
import store.Plant;
import store.Customer;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

enum View {
    CUSTOMERS, PRODUCTS, ORDERS;
}

public class Controller {
    private Store store;
    private View view = View.CUSTOMERS;
    private Menu mainMenu;
    private String output;
    private boolean isRunning = true;
    private Scanner in = new Scanner(System.in);
    private String filename = "Untitled";
    
    public Controller(String storeName) {
        this.store = new Store(storeName);
        this.output = "";
        this.mainMenu = new Menu();
        
        mainMenu.addMenuItem(new MenuItem("Exit", () -> exit())); //lambda converts a method into a Runnable object
        mainMenu.addMenuItem(new MenuItem("Place Order", () -> placeOrder()));
        mainMenu.addMenuItem(new MenuItem("Add new Customer", () -> newCustomer()));
        mainMenu.addMenuItem(new MenuItem("Define new Tool", () -> newTool()));
        mainMenu.addMenuItem(new MenuItem("Define new Plant", () -> newPlant()));
        mainMenu.addMenuItem(new MenuItem("Switch View", () -> switchView()));
        mainMenu.addMenuItem(new MenuItem("Open a file", () -> open()));
        mainMenu.addMenuItem(new MenuItem("Save as", () -> saveAs()));
        mainMenu.addMenuItem(new MenuItem("Save", () -> save()));
    }
    public void mdi() {
        while(isRunning){
            try {
                Integer i = selectFromMenu();//select from menu
                if(i == null) { //clear output
                    continue;
                }
                mainMenu.run(i); //execute selection
            }
            catch(Exception e) {
                print("### Invalid command");
            }
        }
    }
    private void exit() {
        isRunning = false;
    }
    private void placeOrder() {
        if (store.getCustomerList().isEmpty()) {
            System.out.println("No customers available!");
            
            try{
                Thread.sleep(1500);
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
            return;
        }
        System.out.println(store.getCustomerList());
        int customerIndex = getInt("Select customer placing the order: ");
        int orderIndex = store.newOrder(customerIndex);
        int productIndex = 0;
        while(true) {
            System.out.println(store.getProductList());
            productIndex = getInt("Select the product number (-1 to complete order): ");
            if(productIndex == -1) {
                break;
            }
            int quantity = getInt("Enter quantity (-1 to select a different product): ");
            if(quantity == -1) {
                break;
            }
            store.addToOrder(orderIndex, productIndex, quantity);
        }
        view = View.ORDERS;
    }
    private void newCustomer() {
        String name = getString("Enter customer name: ");
        String email = getString("Enter customer email: ");
        store.addCustomer(new Customer(name, email));
        System.out.println("Sucess!");
        view = View.CUSTOMERS;
    }
    private void newTool() {
        String name = getString("Enter tool name: ");
        double priceDouble = getDouble("Enter tool price: ");
        int price = (int)(priceDouble * 100);
        store.addProduct(new Tool(name, price));
        System.out.println("Sucess!");
        view = View.PRODUCTS;
    }
    private void newPlant() {
        String name = getString("Enter plant name: ");
        System.out.println("Exposures available: SHADE, PARTSUN, SUN");
        String exposureString = getString("Enter plant exposure: ");
        Exposure exposure = Exposure.valueOf(exposureString.toUpperCase());
        double priceDouble = getDouble("Enter plant price: ");
        int price = (int)(priceDouble * 100);
        store.addProduct(new Plant(name, price, exposure));
        System.out.println("Sucess!");
        view = View.PRODUCTS;
    }
    private void switchView() {
        System.out.println("Available views: CUSTOMERS, PRODUCTS, ORDERS");
        String selection = getString("Enter the view to switch to: ");
        view = View.valueOf(selection.toUpperCase());
    }
    
    private void open() {
        System.out.println("Enter a filename to open: ");
        String s = in.nextLine();
        if(!(s.isEmpty())) {
            filename = s;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            store = new Store(br);
        }
        catch (Exception e) {
            System.err.println("Unable to read: " + e);
        }
    }
    
    private void saveAs() {
        System.out.print("Enter a filename to save as: ");
        String s = in.nextLine();
        if(s.isEmpty()) {
            return;
        }
        filename = s;
        save();
    }
    
    private void save() {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            store.save(bw);
        }
        catch(Exception e) {
            System.err.println("Unable to save: " + e);
        }
    }
    
    private String getView() {
        String currentView = view.name();
        switch(currentView) {
            case "CUSTOMERS":
                return store.getCustomerList();
            case "PRODUCTS":
                return store.getProductList();
            case "ORDERS":
                return store.getOrderList();
            default:
                 return "Unknown View";
        }
    }
    
    private static String clearScreen = "\n".repeat(250);
    private Integer selectFromMenu() {
        System.out.println(clearScreen + store.getName() + "\n\n" + mainMenu + "\n\n" + getView() + '\n' + output);
        output = "";
        return getInt("Selection? ");
    }

    private void print(String s) {
        output += s + '\n';
    }

    private String getString(String prompt) {
        String s = null;
        while(true) {
            try{
                System.out.print(prompt);
                s = in.nextLine().trim(); //full line of user input
                break;
            }
            catch(Exception e) {
            }
        }
        return s;
    }

    private Integer getInt(String prompt) {
        Integer i = null;
        while(true) {
            try {
                String s = getString(prompt);
                if(s != null && !s.isEmpty()) {
                    i = Integer.parseInt(s);
                }    
                break;
            }
            catch(Exception e) {
                System.err.println("Invalid Input!");
            }
        }
        return i;
    }

    private Double getDouble(String prompt) {
        Double d = null;
        while(true) {
            try {
                String s = getString(prompt);
                if(s != null && !s.isEmpty()) {
                    d = Double.parseDouble(s);
                }  
                break;  
            }
            catch(Exception e) {
                System.err.println("Invalid Input!");
            }
        }
        return d;
    }
}
