#ifndef __LINEAR_H
#define __LINEAR_H

#include <iostream>
#include <vector>
#include <exception>
#include "polynomial.h"

class Linear : public Polynomial {
  public:
    Linear(std::vector<double> coefficients);
    virtual ~Linear();
    std::vector<double> solve() override;
};

#endif
