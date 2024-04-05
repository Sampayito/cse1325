#ifndef __QUADRATIC_H
#define __QUADRATIC_H

#include <iostream>
#include <vector>
#include <cmath> # sqrt

class Quadratic : public Polynomial {
  public:
    Quadratic(std::vector<double> coefficients);
    virtual ~Quadratic();
    std::vector<double> solve() override;
};

#endif
