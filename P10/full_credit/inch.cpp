#include "inch.h"

#include <numeric>

Inch::Inch(int whole, int numerator, int denominator) 
    : _whole{whole}, _numerator{numerator}, _denominator{denominator} {
        validate();
    }
Inch::Inch() : Inch{0, 0, 2} {}

Inch operator+(const Inch& rhs) {
    int common_denom = std::lcm(_denominator, rhs._denominator);
    int new_num = _whole * _denominator + _numerator * (common_denom / _denominator);
    int rhs_new_num = rhs._whole * rhs._denominator + rhs._numerator * (common_denom / rhs._denominator);
    int total_num = new_num + rhs_new_num;
    return Inch(total_num / common_denom, total_num % common_denom, common_denom);
}



std::ostream& operator<<(std::ostream& ost, const Inch& inch) {
    ost << inch._whole << " " << inch._numerator << "/" << inch._denominator;
    return ost;
}

std::istream& operator>>(std::istream& ist, Inch& inch) { //MIGHT BE WRONG
    ist >> inch._whole;
    ist >> inch._numerator;
    char slash;
    ist >> slash;
    if (slash != '/') {
        throw std::invalid_argument{"Invalid input"};
    }
    ist >> inch._denominator;
    inch.validate();
    return ist;
}

int Inch::compare(const Inch& rhs) const{
    if(_whole < rhs._whole) return -1;
    if(_whole > rhs._whole) return 1;
    if(_numerator < rhs._numerator) return -1;
    if(_numerator > rhs._numerator) return 1;
    if(_denominator < rhs._denominator) return -1;
    if(_denominator > rhs._denominator) return 1;
    return 0;
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
