#include "inch.h"

#include <stdexcept>
#include <numeric>

Inch::Inch(int whole, int numerator, int denominator) 
    : _whole{whole}, _numerator{numerator}, _denominator{denominator} {
    
    }
Inch::Inch() : Inch{0, 0, 2} {}

std::ostream& operator<<(std::ostream& ost, const Inch& inch) {
    ost << inch._whole << " " << inch._numerator << "/" << inch._denominator;
    return ost;
}

std::istream& operator>>(std::istream& ist, Inch& inch) { //MIGHT BE WRONG
    ist >> inch._whole;
    ist >> inch._numerator;
    ist >> "/";
    ist >> inch._denominator;
    validate();
    return ist;
}

void Inch::validate() {
    if (_denominator != 2 && _denominator != 4 && _denominator != 8 && 
    _denominator != 16 && _denominator != 32 && _denominator != 64) {
        throw std::invalid_argument{"Denominator must be 2, 4, 8, 16, 32, or 64."};
    }
    while (_numerator > _denominator) {
        _numerator -= _denominator;
        _whole++;
    }
    int gcd = std:gcd(_numerator, _denominator);
    _numerator /= gcd;
    _denominator /= gcd;
}

  public:
    Inch();
    Inch(int whole, int numerator, int denominator);
    Inch operator+(const Inch& rhs);
    bool operator==(const Inch& rhs);
    bool operator!=(const Inch& rhs);
    bool operator<(const Inch& rhs);
    bool operator<=(const Inch& rhs);
    bool operator>(const Inch& rhs);
    bool operator>=(const Inch& rhs);
    friend std::ostream& operator<<(std::ostream& ost, const Inch& inch);
    friend std::istream& operator>>(std::istream& ist, Inch& inch);
  private:
    const int compare(const Inch& rhs);
    void validate();
};
