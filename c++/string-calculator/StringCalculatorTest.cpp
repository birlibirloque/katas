#include <gtest/gtest.h>
#include "StringCalculator.h"

namespace {

class StringCalculatorTest : public ::testing::Test {

protected:

	StringCalculator stringCalculator;
};

TEST_F(StringCalculatorTest, addEmptyString) {
	ASSERT_TRUE(stringCalculator.add("") == 0);
}

TEST_F(StringCalculatorTest, addStringOneNumber) {
	ASSERT_TRUE(stringCalculator.add("1") == 1);
}
TEST_F(StringCalculatorTest, addStringTwoNumbers) {
	ASSERT_TRUE(stringCalculator.add("1,2") == 3);
}

TEST_F(StringCalculatorTest, addStringWithSpace) {
	ASSERT_TRUE(stringCalculator.add("1, 2,3 ") == 6);
}

TEST_F(StringCalculatorTest, addStringWithNewLine) {
	ASSERT_TRUE(stringCalculator.add("1,\n2,4 ") == 7);
}

TEST_F(StringCalculatorTest, addStringWithDelimiters) {
	ASSERT_TRUE(stringCalculator.add("//;\n1;2") == 3);
}

TEST_F(StringCalculatorTest, addStringWithDelimitersAndNewLine) {
	ASSERT_TRUE(stringCalculator.add("//%\n1%2%\n3") == 6);
}
}
