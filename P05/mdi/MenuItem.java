package mdi;

class MenuItem implements Runnable { //runnable interface requires a run() method
    private Object menuText;
    private Runnable menuResponse;
    
    public MenuItem(Object menuText, Runnable menuResponse) {
        this.menuText = menuText;
        this.menuResponse = menuResponse;
    }
    
    @Override
    public String toString() {
        return menuText.toString();
    }
    
    @Override
    public void run() {
        menuResponse.run();
    }
}
