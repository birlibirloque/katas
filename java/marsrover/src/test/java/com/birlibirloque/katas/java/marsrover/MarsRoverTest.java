package com.birlibirloque.katas.java.marsrover;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MarsRoverTest extends TestCase
{
    private MarsRover robot = new MarsRover(50,50,"North",new Grid(100,100));

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MarsRoverTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MarsRoverTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void test_canCreateMarsRover_atInitialPosition_and_atInitialDirection()
    {
        assertTrue(robot.areYouAt(50, 50, "North"));
    }

    public void test_canCreateMarsRover_atAnyPosition_and_atAnyDirection () {
        MarsRover robot = new MarsRover(0, 0, "South", new Grid(100,100));
        assertTrue(robot.areYouAt(0, 0, "South"));
    }

    public void test_canMoveFordward_oneStep () {
        robot.command("f");
        assertTrue(robot.areYouAt(50, 51, "North"));        
    }

    public void test_canMoveFordward_manySteps () {
        robot.command("ffff");
        assertTrue(robot.areYouAt(50, 54, "North"));        
    }

    public void test_canMoveBackward_manyStep () {
        robot.command("bbb");
        assertTrue(robot.areYouAt(50, 47, "North"));        
    }

    public void test_canMoveFordwardAndBackward_manyStep () {
        robot.command("fffbbffbbb");
        assertTrue(robot.areYouAt(50, 50, "North"));        
    }

    public void test_canTurnRight_oneTime() {
        robot.command("r");
        assertTrue(robot.areYouAt(50, 50, "East"));
    }

    public void test_canTurnRight_manyTimes() {
        robot.command("rrr");
        assertTrue(robot.areYouAt(50, 50, "West"));
    }

    public void test_canTurnLeft_manyTimes() {
        robot.command("lll");
        assertTrue(robot.areYouAt(50, 50, "East"));
    }

    public void test_canMoveAndTurnManyTimes () {
        robot.command("fffrfflbbblfffff");
        assertTrue(robot.areYouAt(47, 50, "West"));
    }

    public void test_canWrappingFrom_Y_Min_EdgeOfTheGrid () {
        MarsRover robot = new MarsRover (0,0, "North", new Grid(100,100));
        robot.command("b");
        assertTrue(robot.areYouAt(0, 99, "North"));
    }

    public void test_canWrappingFrom_X_Min_EdgeOfTheGrid () {
        MarsRover robot = new MarsRover (0,0, "West", new Grid(100,100));
        robot.command("f");
        assertTrue(robot.areYouAt(99, 0, "West"));
    }

    public void test_canWrappingFrom_Y_Max_EdgeOfTheGrid () {
        MarsRover robot = new MarsRover (99,99, "North", new Grid(100,100));
        robot.command("f");
        assertTrue(robot.areYouAt(99, 0, "North"));
    }

    public void test_canWrappingFrom_X_Max_EdgeOfTheGrid () {
        MarsRover robot = new MarsRover (99,99, "West", new Grid(100,100));
        robot.command("b");
        assertTrue(robot.areYouAt(0, 99, "West"));
    }
}
