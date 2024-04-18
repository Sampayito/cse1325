#include "university.h"

University::University(std::string name = "", int enrollment = 0) 
    : _name{name}, _enrollment{enrollment} {
    validate();
} 

std::string University::name() const {
    return _name;
}
    
int University::enrollment() const {
     return _enrollment;
}
    
std::istream& operator>>(std::istream& ist, University& reading) {
    ist >> reading._name >> reading._enrollment;
    reading.validate();
    return ist;
}
    
std::ostream& operator<<(std::ostream& ost, const University& reading) {
    return ost << reading._name << " has an enrollment of " << reading._enrollment;
}

void University::validate() {
    if (_enrollemnt < 0) {
        throw std::invalid_argument("University enrollment cannot be negative");
    }
    if (_enrollment > 0 && _name.length() == 0) {
        throw std::invalid_argument("University cannot be anonymous");
    }
}
