#include "linear.h"

Linear::Linear(std::vector<double> coefficients) : Polynomial(coefficients) {
    if (coefficients.size() != 2 || coefficients[0] == 0) {
        throw std::runtime_error("a may not be 0");
    }
}

Linear::~Linear() { }

std::vector<double> Linear::solve() {
    double a = _coefficients[0];
    double b = _coefficients[1];
    
    double solution = -b / a;
    
    std::cout << "Solution: " << solution << std::endl;
}
