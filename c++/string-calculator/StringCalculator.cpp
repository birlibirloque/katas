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

	std::vector<int> addend = giveMeAddend(str);
	int sum = std::accumulate(addend.begin(), addend.end(), 0);
	return sum;
}

vector<int> StringCalculator::giveMeAddend (string str)
{
	char delimiter = ',';
	if (str.find("//") != std::string::npos) {
		str.erase (remove(str.begin(), str.end(), '/'), str.end());
		int f = str.find('\n');
		delimiter = str.at(f-1);
		str = str.substr(f,str.length());
	}
	string straddend = replaceDelimiterBySpaces(str,delimiter);
	istringstream buf(straddend);
	vector<int> addend = vector<int>(istream_iterator<int>(buf), istream_iterator<int>());
	checkAddend(addend);
	return 	addend;
}

string StringCalculator::replaceDelimiterBySpaces (string str, char delimiter)
{
	std::replace(str.begin(), str.end(), delimiter, ' ');
	return str;
}

void StringCalculator::checkAddend (vector<int> addend)
{
	string negativeNumbers = "";
	for (int i = 0; i < addend.size(); ++i)
	{
		if (addend.at(i) < 0)
		{
			negativeNumbers += " ";
			negativeNumbers += std::to_string(static_cast<long long>(addend.at(i)));
		}
	}
	if (negativeNumbers.size() > 0)
	{
		string message = string("negativos no soportados:") + negativeNumbers;
		throw NegativeNumbersException(message);
	}
}