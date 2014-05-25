cmake_minimum_required(VERSION 2.8)
project (tdd)

add_definitions(-std=c++0x)
include_directories ($ENV{GTEST_HOME}/include)
add_executable (string_calculator_test StringCalculator.cpp StringCalculatorTest.cpp)
target_link_libraries (string_calculator_test pthread $ENV{GMOCK_HOME}/build/gtest/libgtest.a $ENV{GMOCK_HOME}/build/gtest/libgtest_main.a)
