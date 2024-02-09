package store;

public class Customer {
    private String name;
    private String email;
    
    public Customer(String name, String email) {
        this.name = name;
        if (!(email.contains("@") && email.contains(".") && (email.indexOf("@") < email.lastIndexOf(".")))) {
            throw new IllegalArgumentException("Invalid email address: " + email);
        }
        else {
            this.email = email;
        }
    }
    @Override
    public String toString() {
        return "" + name + " (" + email + ")";
    }
}
