#include <gtest/gtest.h>
#include "MarsRover.h"

namespace {

class MarsRoverTest : public ::testing::Test {

protected:

	MarsRover robot;
};

TEST_F(MarsRoverTest, canCreateRobotAtInitialPosition) {
	ASSERT_TRUE(robot.areYouAt(0,0,'N'));
}

TEST_F(MarsRoverTest, canCreateRobotAtAnyPosition) {
	MarsRover otherRobot (50,50,'S');
	ASSERT_TRUE(otherRobot.areYouAt(50,50,'S'));
}

TEST_F(MarsRoverTest, canMoveFordwardOneStep) {
	robot.command("f");
	ASSERT_TRUE(robot.areYouAt(0,1,'N'));
}

TEST_F(MarsRoverTest, canMoveFordwardManyStep) {
	robot.command("fffff");
	ASSERT_TRUE(robot.areYouAt(0,5,'N'));
}

TEST_F(MarsRoverTest, canMoveBackwardManyStep) {
	robot.command("bbbbb");
	ASSERT_TRUE(robot.areYouAt(0,-5,'N'));
}

TEST_F(MarsRoverTest, canMoveFordwardAndBackwardManyStep) {
	robot.command("bbfffbbbfff");
	ASSERT_TRUE(robot.areYouAt(0,1,'N'));
}

TEST_F(MarsRoverTest, canTurnRightOne) {
	robot.command("r");
	ASSERT_TRUE(robot.areYouAt(0,0,'E'));
}

TEST_F(MarsRoverTest, canTurnLeftOne) {
	robot.command("l");
	ASSERT_TRUE(robot.areYouAt(0,0,'W'));
}

TEST_F(MarsRoverTest, canTurnLeftRightMany) {
	robot.command("rrllll");
	ASSERT_TRUE(robot.areYouAt(0,0,'S'));
}

TEST_F(MarsRoverTest, canMoveAnyway) {
	robot.command("fflbbb");
	ASSERT_TRUE(robot.areYouAt(3,2,'W'));
}

}
