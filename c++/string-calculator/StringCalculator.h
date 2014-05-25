#include "string"
#include <vector>

using namespace std;

struct NegativeNumbersException : public exception
{
   std::string s;
   NegativeNumbersException(std::string ss) : s(ss) {}
   ~NegativeNumbersException() throw () {} // Updated
   const char* what() const throw() { return s.c_str(); }
   void update(string ss) {s = ss; }
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
	//bool isBigger(int i);
	char giveMeDelimiter (string str);
	string giveMeStringAddend (string str);
	bool hasDelimiter (string str);
	vector<int> convertStringToVectorInt (string str);
	vector<int> eraseBigNumbers (vector<int> v);
	void checkAddend (vector<int> v);
};
