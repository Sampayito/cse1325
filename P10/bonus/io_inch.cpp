#include <iostream>
#include <fstream>
#include "inch.h"

int main(int argc, char *argv[]) {
    std::ifstream ifs{std::string{argv[1]}};
    if (!ifs) throw std::runtime_error{"unable to open input file"};

    std::ofstream ofs {std::string{argv[2]}};
    if (!ofs) throw std::runtime_error{"unable to open output file"};
    
    Inch in, last_in, sum;
    
    while (ifs >> in) {
        sum = sum + in;
        

        std::cout << "Read " << in << " from " << argv[1] << std::endl;
            
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
        
        ofs << in << std::endl;

        last_in = in;
    }
    
    while (std::cin) {
        try {
            std::cout << "Enter one or more measurements (in inches): ";
            std::cin >> in;

            sum = sum + in;

            std::cout << "You entered: " << in << std::endl;
            
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
                
            ofs << in << std::endl;
            
            std::cout << "Sum so far: " << sum << std::endl;

            last_in = in;
        } catch (const std::exception& e) {
            std::cerr << "Error: " << e.what() << std::endl;
        }
    }
    
    ifs.close();
    ofs.close();
    
    return 0;
}

