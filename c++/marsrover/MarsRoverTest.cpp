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

}
