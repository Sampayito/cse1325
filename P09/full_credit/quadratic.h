#ifndef __QUADRATIC_H
#define __QUADRATIC_H

#include <iostream>
#include <vector>
#include <cmath>
#include <exception>
#include "polynomial.h"

class Quadratic : public Polynomial {
  public:
    Quadratic(std::vector<double> coefficients);
    virtual ~Quadratic();
    std::vector<double> solve() override;
};

#endif
