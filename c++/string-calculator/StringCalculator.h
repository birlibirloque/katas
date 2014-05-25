#include "string"
#include <vector>

using namespace std;

class StringCalculator {

private:
	int count;

public:
	StringCalculator();

	int add(std::string str);

private:
	vector<int> givemeaddend (string str);
	string replaceDelimiterBySpaces (string str, char delimiter);
};
