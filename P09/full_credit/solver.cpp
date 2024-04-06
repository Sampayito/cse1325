#include "linear.h"
#include "quadratic.h"

int main(int argc, char* argv[]) {
    if (argc != 3 && argc != 4) {
       std::cerr << "Invalid polynomial size - must be linear or quadratic" << std::endl;
       exit(-1);
    }
    
    Polynomial *p;
    
    if (argc == 3) {
        std::vector<double> coefficients;
        coefficients.push_back(std::stod(argv[1]));
        coefficients.push_back(std::stod(argv[2]));
        p = new Linear(coefficients);
    }
    
    if (argc == 4) {
        std::vector<double> coefficients;
        coefficients.push_back(std::stod(argv[1]));
        coefficients.push_back(std::stod(argv[2]));
        coefficients.push_back(std::stod(argv[3]));
        p = new Quadratic(coefficients);
    }
    
    std::vector<double> roots = p->solve();
    for (const auto& root : roots) {
        std::cout << "Root(s) are " << root << std::endl;
    }
    
    delete p;
    
    return 0;
}
