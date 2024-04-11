#ifndef __POLYNOMIAL_H
#define __POLYNOMIAL_H

#include <iostream>
#include <vector>

class Polynomial {
    std::vector<double> _coefficients;
  public:
    Polynomial(std::vector<double> coefficients);
    virtual ~Polynomial();
    virtual std::vector<double> solve() = 0;
    
    friend class Linear;
    friend class Quadratic;
};

#endif
