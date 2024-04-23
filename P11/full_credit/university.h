#ifndef __UNIVERSITY_H
#define __UNIVERSITY_H

#include <iostream>

class University {
  public:
    University(std::string name = "", int enrollment = 0);
    
    std::string name() const;
    
    int enrollment() const;
    
    std::istream& operator>>(std::istream& ist, University& reading);
    
    std::ostream& operator<<(std::ostream& ost, const University& reading);
    
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
