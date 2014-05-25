#include <iostream>
#include <sstream>
#include <iterator>
#include <algorithm>
#include <numeric>
#include "StringCalculator.h"

bool isBigger(int i)
{
	return (i > 1000);
}



StringCalculator::StringCalculator()
{
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
	char delimiter = giveMeDelimiter(str);
	string straddend = giveMeStringAddend(str);
	straddend = replaceDelimiterBySpaces(straddend,delimiter);
	vector<int> addend = convertStringToVectorInt (straddend);
	addend = eraseBigNumbers(addend);
	checkAddend(addend);
	return 	addend;
}

char StringCalculator::giveMeDelimiter (string str)
{
	char delimiter = ',';
	if (hasDelimiter(str)) {
		delimiter = str.at(str.find('\n') - 1);
	}
	return delimiter;
}

string StringCalculator::giveMeStringAddend (string str)
{
	string result = str;
	if (hasDelimiter(str)) {
		str.erase (remove(str.begin(), str.end(), '/'), str.end());
		result = str.substr(str.find('\n'), str.length());
	}
	return (result);
}

bool StringCalculator::hasDelimiter (string str)
{
	return str.find("//") != std::string::npos;
}

string StringCalculator::replaceDelimiterBySpaces (string str, char delimiter)
{
	std::replace(str.begin(), str.end(), delimiter, ' ');
	return str;
}

vector<int> StringCalculator::convertStringToVectorInt (string str)
{
	istringstream buf(str);
	return vector<int>(istream_iterator<int>(buf), istream_iterator<int>());
}

vector<int> StringCalculator::eraseBigNumbers (vector<int> v)
{
	v.erase(std::remove_if(v.begin(),v.end(),isBigger), v.end()); 
	return v;
}

void StringCalculator::checkAddend (vector<int> v)
{
	bool throwit = false;
	string message = string("negativos no soportados:");
	for (int i = 0; i < v.size(); ++i)
	{
		if (v.at(i) < 0)
		{
			message += " " + std::to_string(static_cast<long long>(v.at(i)));
			throwit = true;
		}
	}
	if (throwit)
	{
		throw NegativeNumbersException(message);
	}
}