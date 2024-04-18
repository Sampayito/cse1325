#ifndef __UNIVERSITY_H
#define __UNIVERSITY_H

#include <iostream>

class University {
  public:
    University(std::string name, int enrollment);
    
    std::string name() const {
        return _name;
    }
    
    int enrollment() const {
        return _enrollment;
    }
    
    std::istream& operator>>(std::istream& ist, University& reading) {
        ist >> reading._name >> reading._enrollment;
        reading.validate();
        return ist;
    }
    
    std::ostream& operator<<(std::ostream& ost, const University& reading) {
        return ost << _name << " has an enrollment of " << _enrollment;
    }
    
    std::string name() const;
    int enrollment() const;
    friend std::istream& operator>>(std::istream& ist, University& reading);
    friend std::ostream& operator<<(std::ostream& ost, const University& reading);
  
  private:
    void validate();
    std::string _name;
    int _enrollment;
};

#endif
