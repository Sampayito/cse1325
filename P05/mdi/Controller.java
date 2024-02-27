package mdi;

enum View {
    CUSTOMERS, PRODUCTS, ORDERS;
}

public class Controller {
    private Store store;
    private View view;
    private Menu mainMenu;
    private String output;
    private boolean isRunning = true;
    private Scanner in = new Scanner(System.in);
    
    public Controller(String storeName) {
        this.store = new Store(storeName);
        this.output = "";
        this.mainMenu = new Menu(); //?
        
        mainMenu.addMenuItem(new MenuItem("Exit", () -> exit())); //lambda converts a method into a Runnable object
        mainMenu.addMenuItem(new MenuItem("Place Order", () -> placeOrder()));
        mainMenu.addMenuItem(new MenuItem("Welcome new Customer", () -> newCustomer()));
        mainMenu.addMenuItem(new MenuItem("Define new Tool", () -> newTool()));
        mainMenu.addMenuItem(new MenuItem("Define new Plant", () -> newPlant()));
        mainMenu.addMenuItem(new MenuItem("Switch View", () -> switchView()));
    }
    public mdi() {
        try{
            while(isRunning) {
                Integer i = selectFromMenu();//select from menu
                if(i == null) {//clear output
                    continue;
                }
                menu.run(i);//execute selection
            }
            catch (Exception e) {
                print("### Invalid command");
            }
        }
    }
    private exit() {
        isRunning = false;
    }
    private placeOrder() {
        System.out.println(store.getCustomerList());
        int customerIndex = getInt("Select customer placing the order: ");
        int orderIndex = store.newOrder(customerIndex);
        int productIndex;
        while(productIndex != -1) {
            System.out.println(store.getProductList());
            productIndex = getInt("Select the product number (-1 to complete order): ");
            int quantity = getInt("Enter quantity (-1 to select a different product): ");
            store.addToOrder(orderIndex, productIndex, quantity);
        }
    }
    private newCustomer() {
        String name = getString("Enter customer name: ");
        String email = getString("Enter customer email: ");
        store.addCustomer(new Customer(name, email);
        System.out.println("Sucess!");
        view = View.CUSTOMERS;
    }
    private newTool() {
        String name = getString("Enter tool name: ");
        int price = getInt("Enter tool price: ");
        store.addProduct(new Tool(name, price);
        System.out.println("Sucess!");
        view = View.PRODUCTS;
    }
    private newPlant() {
        String name = getString("Enter plant name: ");
        System.out.println("Exposures available: " + Exposure.values());
        String exposureString = getString("Enter plant exposure: ");
        Exposure exposure = Exposure.valueOf(exposureString.toUpperCase());
        int price = getInt("Enter plant price: ");
        store.addProduct(new Plant(name, price, exposure);
        System.out.println("Sucess!");
        view = View.PRODUCTS;
    }
    private switchView() {
        System.out.println("Available views: CUSTOMERS, PRODUCTS, ORDERS");
        String selection = getString("Enter the view to switch to: ");
        view = View.valueOf(selection.toUpperCase());
    }
    
    private String getView {
        return view.name()
    }
    
    private static String clearScreen = "\n".repeat(250);
    private Integer selectFromMenu() {
        System.out.println(clearScreen + store.getName() + "\n\n" + mainMenu + '\n' + output);
        output = "";
        return getInt("Selection? ");
    }
    private print(String s) {
        output += s + '\n';
    }
    private getString(String prompt) {
        String s = null;
        while(true) {
            try{
                System.out.print(prompt);
                s = in.nextLine().trim(); //full line of user input
                break;
            }
            catch(Exception e) {
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
