#include "university.h"

std::string State;
typedef std::vector<University> Universities;

int main (int argc, char* argv[]) {
    if (argc != 2) {
        std::err << "usage: ./universities enrollment.txt" << std::endl;
        exit(-1);
    }
    
    std::ifstream ifs;
    std::string infile = std::string{argv[1]};
    ifs = std::ifstream{infile};
    
    if (!ifs) {
        std::cerr << infile << ": file not found" << std::endl;
        exit(-2);
    }
    
    std::map<State, Universities> _map;
}
