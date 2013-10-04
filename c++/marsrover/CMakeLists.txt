cmake_minimum_required(VERSION 2.8)
project (MarsRover)

include_directories ($ENV{GTEST_HOME}/include)
add_executable (marsrover_test MarsRover.cpp MarsRoverTest.cpp)
target_link_libraries (marsrover_test pthread $ENV{GTEST_HOME}/build/libgtest.a $ENV{GTEST_HOME}/build/libgtest_main.a)
