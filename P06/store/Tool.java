package store;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Tool extends Product {
    public Tool(String name, int price) {
        super(name, price);
    }
    public Tool(BufferedReader br) throws IOException {
        super(br);
    }
}
