#include "university.h"
#include <vector>
#include <map>
#include <fstream>

typedef std::string State;
typedef std::vector<University> Universities;

int main (int argc, char* argv[]) {
    if (argc != 2) {
        std::cerr << "usage: ./universities enrollment.txt" << std::endl;
        exit(-1);
    }
    
    std::string file{argv[1]};
    std::ifstream ifs{file};
    if (!ifs) {
        std::cerr << file << ": file not found" << std::endl;
        exit(-2);
    }
    
    std::map<State, Universities> university_map;
    
    State state;
    University university;
    
    while(ifs >> state >> university) {
        if (university_map.find(state) == university_map.end()) {
            university_map[state] = Universities(); //construcs empty vector with default constructor
        }
        university_map[state].push_back(university);
    }
    
    std::string userInput;
    while (true) {
        std::cout << "Which state (2-character abbreviation): ";
        std::getline(std::cin, userInput);
        
        if (userInput.empty()) {
            break;
        }
        
        auto it = university_map.find(userInput);
        if (it == university_map.end()) {
            std::cout << "No universities found in " << userInput << std::endl;
        } else {
            for (const auto& univ : it->second) { //->second gives value from map
                std::cout << univ << std::endl; 
            }
        }       
    }
    
    return 0;
}
