#ifndef __INCH_H
#define __INCH_H

class Inch {
  public:
    Inch(int whole, int numerator, int denominator);
    Inch();
    
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
  
    int _whole;
    int _numerator;
    int _denominator;
};
