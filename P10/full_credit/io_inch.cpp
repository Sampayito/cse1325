#include <iostream>
#include "inch.h"

int main() {
    Inch in, last_in, sum;
    
    while (std::cin) {
        try {
            std::cout << "Enter one or more measurements (in inches): ";
            std::cin >> in;

            sum = sum + in; // Add the entered Inch to the running total

            std::cout << "You entered: " << in << std::endl;
            
            //std::cout << "Comparison with the last entry:" << std::endl;
            if (in == last_in)
                std::cout << "  Same length as last time!" << std::endl;
            if (in != last_in)
                std::cout << "  NOT the same length as last time." << std::endl;
            if (in > last_in)
                std::cout << "  Bigger length than last time." << std::endl;
            if (in >= last_in)
                std::cout << "  Bigger or same length as last time." << std::endl;
            if (in < last_in)
                std::cout << "  Smaller length than last time." << std::endl;
            if (in <= last_in)
                std::cout << "  Smaller or same length as last time." << std::endl;
            
            std::cout << "Sum so far: " << sum << std::endl;

            last_in = in;
        } catch (const std::exception& e) {
            std::cerr << "Error: " << e.what() << std::endl;
        }
    }
    
    return 0;
}

