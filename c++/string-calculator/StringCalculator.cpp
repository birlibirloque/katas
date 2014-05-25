#include <iostream>
#include <sstream>
#include <iterator>
#include <algorithm>
#include <numeric>
#include "StringCalculator.h"

StringCalculator::StringCalculator()
{
	count = 0;
}

int StringCalculator::add (string str)
{
	if (str.length() == 0)
		return 0;

	std::vector<int> addend = givemeaddend(str);
	int sum = std::accumulate(addend.begin(), addend.end(), 0);
	return sum;
}

vector<int> StringCalculator::givemeaddend (string str)
{
	char delimiter = ',';
	if (str.find("//") != std::string::npos) {
		str.erase (remove(str.begin(), str.end(), '/'), str.end());
		int f = str.find('\n');
		delimiter = str.at(f-1);
		str = str.substr(f,str.length());
	}
	string addend = replaceDelimiterBySpaces(str,delimiter);
	istringstream buf(addend);
	return vector<int>(istream_iterator<int>(buf), istream_iterator<int>());	
}

string StringCalculator::replaceDelimiterBySpaces (string str, char delimiter)
{
	std::replace(str.begin(), str.end(), delimiter, ' ');
	return str;
}