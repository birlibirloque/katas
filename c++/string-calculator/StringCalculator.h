#include "string"
#include <vector>

using namespace std;

struct NegativeNumbersException : public std::exception
{
   std::string s;
   NegativeNumbersException(std::string ss) : s(ss) {}
   ~NegativeNumbersException() throw () {} // Updated
   const char* what() const throw() { return s.c_str(); }
};

class StringCalculator {

private:
	int count;

public:
	StringCalculator();

	int add(std::string str);

private:
	vector<int> giveMeAddend (string str);
	string replaceDelimiterBySpaces (string str, char delimiter);
	void checkAddend (vector<int> addend);
};
