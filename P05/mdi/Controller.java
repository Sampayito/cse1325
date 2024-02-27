package mdi;
public class Controller {
    private Store store;
    private View view; //enum?
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
        j
    }
    private newCustomer() {
        
    }
    private newTool() {
    }
    private newPlant() {
    }
    private switchView() {
    }
    
    private String getView {
    }
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
