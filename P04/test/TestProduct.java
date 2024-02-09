package test;

import store.Plant;
import store.Tool;
import store.Exposure;

public class TestProduct {
    public static void main(String[] args) {
    	int failures = 0;
    	
    	Plant testPlant = new Plant("Test Product", 512, Exposure.SHADE);
    	//test 1
    	if (testPlant.getStockNumber() != 0) {
	    System.err.println("FAIL: First stock number is not 0 but " + testPlant.getStockNumber());
	    failures++;
    	}
    	Tool testTool = new Tool("Test Tool", 956);
    	if (testTool.getStockNumber() != 1) {
	    System.err.println("FAIL: Second stock number is not 1 but " + testTool.getStockNumber());
	    failures++;
    	}
    	//test 2
    	if (testPlant.getPrice() != 512) {
    	    System.err.println("FAIL: Price not 512 but " + testPlant.getPrice());
    	    failures++;
    	}
	if (testTool.getPrice() != 956) {
    	    System.err.println("FAIL: Price not 956 but " + testTool.getPrice());
    	    failures++;
    	}
    	//test 3
    	String expectedString = "Cactus Cereus Peruvianus       $    49.90";
    	Tool testTool2 = new Tool("Cactus Cereus Peruvianus", 4990);
    	if (!(expectedString.equals(testTool2.toString()))){
    	    System.err.println("FAIL: toString is not 'Cactus Cereus Peruvianus       $   49.90' but " + testTool2);
    	    failures++;
    	}
    	
        try {
            Plant p1 = new Plant("Negative Price", -8142, Exposure.SUN);
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
