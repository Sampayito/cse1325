#include "polynomial.h"

class Polynomial {
    Polynomial::Polynomial(std::vector<double> coefficients)
        : _coefficients{coefficients} { }
    virtual ~Polynomial() { }
};
