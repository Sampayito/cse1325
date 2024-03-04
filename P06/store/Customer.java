package store;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

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
    
    public Customer(BufferedReader br) throws IOException {
        this.name = br.readLine();
        this.email = br.readLine();
    }
    
    public void save(BufferedWriter bw) throws IOException {
        bw.write(name + "/n");
        bw.write(email + "/n");
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    @Override
    public String toString() {
        return "" + name + " (" + email + ")";
    }
}
