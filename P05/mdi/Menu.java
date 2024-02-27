package mdi;

public class Menu {
    private ArrayList<MenuItem> items = new ArrayList<>();//items contains pairs of menu text and their associated run() methods
    
    public void addMenuItem(MenuItem item) { //add a menu item with associated run() method
        items.add(item);
    }
    
    @Override
    public String toString() { //print the menu as: index] menuItem.toString()
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < items.size(); ++index) {
            sb.append("" + index + "] " + items.get(index) + "\n");
        }
        return sb.toString()
    }
    
    public void run(int index) {
        items.get(index).run(); //call the associated method for index
    }
}
