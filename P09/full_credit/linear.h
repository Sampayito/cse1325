#ifndef __POLYNOMIAL_H
#define __POLYNOMIAL_H

#include <iostream>
#include <vector>

class Linear : public Polynomial {
  public:
    Linear(std::vector<double> coefficients);
    virtual ~Linear();
    void solve() override;
};

#endif
