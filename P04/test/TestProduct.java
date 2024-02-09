package test;

import store.Product;

public class TestProduct {
    public static void main(String[] args) {
    	int failures = 0;
    	
    	Product testProduct = new Product("Test Product", 512);
    	//test 1
    	if (testProduct.getStockNumber() != 0) {
	    System.err.println("FAIL: First stock number is not 0 but " + testProduct.getStockNumber());
	    failures++;
    	}
    	Product testProduct2 = new Product("Test Product 2", 956);
    	if (testProduct2.getStockNumber() != 1) {
	    System.err.println("FAIL: Second stock number is not 1 but " + testProduct2.getStockNumber());
	    failures++;
    	}
    	//test 2
    	if (testProduct.getPrice() != 512) {
    	    System.err.println("FAIL: Price not 512 but " + testProduct.getPrice());
    	    failures++;
    	}
    	//test 3
    	String expectedString = "Cactus Cereus Peruvianus       $    49.90";
    	Product testProduct3 = new Product("Cactus Cereus Peruvianus", 4990);
    	if (!(expectedString.equals(testProduct3.toString()))){
    	    System.err.println("FAIL: toString is not 'Cactus Cereus Peruvianus       $   49.90' but " + testProduct3);
    	    failures++;
    	}
    	
        try {
            Product p1 = new Product("Negative Price", -8142);
            System.err.println("No exception thrown for negative price");
            failures++;
        } catch(IllegalArgumentException e) {
        
        } catch(Exception e) {
            System.err.println("Unexpected exception thrown: " + e);
            failures++;
        }
        
        if (failures > 0) {
        System.exit(failures);
        } else {
        System.exit(0);
        }
    }
}
