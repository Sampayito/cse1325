#include "quadratic.h"

Quadratic::Quadratic(std::vector<double> coefficients) : Polynomial(coefficients) {
    if (coefficients.size() != 3 || coefficients[0] == 0) {
        throw std::runtime_error("a may not be 0");
    }
}

Quadratic::~Quadratic() { }

std::vector<double> Quadratic::solve() {
    double a = _coefficients[0];
    double b = _coefficients[1];
    double c = _coefficients[2];
    
    double discriminant = (b * b) - (4 * a * c);
    
    if (discriminant < 0) {
        throw std::runtime_error("No real roots!");
    }
    
    double root1 = (-b + sqrt(discriminant)) / (2 * a);
    double root1 = (-b - sqrt(discriminant)) / (2 * a);
    
    return root1, root2;
}
