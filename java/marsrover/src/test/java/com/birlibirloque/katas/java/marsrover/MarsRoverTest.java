package com.birlibirloque.katas.java.marsrover;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MarsRoverTest extends TestCase
{
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
        MarsRover robot = new MarsRover();
        assertTrue(robot.areYouAt(50, 50, "North"));
    }

    public void test_canCreateMarsRover_atAnyPosition_and_atAnyDirection () {
        MarsRover robot = new MarsRover(0, 0, "South");
        assertTrue(robot.areYouAt(0, 0, "South"));
    }

    public void test_canMoveFordward_oneStep () {
        MarsRover robot = new MarsRover ();
        robot.command("f");
        assertTrue(robot.areYouAt(50, 51, "North"));        
    }

    public void test_canMoveFordward_manySteps () {
        MarsRover robot = new MarsRover ();
        robot.command("ffff");
        assertTrue(robot.areYouAt(50, 54, "North"));        
    }

    public void test_canMoveBackward_manyStep () {
        MarsRover robot = new MarsRover ();
        robot.command("bbb");
        assertTrue(robot.areYouAt(50, 47, "North"));        
    }

    public void test_canMoveFordwardAndBackward_manyStep () {
        MarsRover robot = new MarsRover ();
        robot.command("fffbbffbbb");
        assertTrue(robot.areYouAt(50, 50, "North"));        
    }

    public void test_canTurnRight_oneTime() {
        MarsRover robot = new MarsRover();
        robot.command("r");
        assertTrue(robot.areYouAt(50, 50, "East"));
    }

    public void test_canTurnRight_manyTimes() {
        MarsRover robot = new MarsRover();
        robot.command("rrr");
        assertTrue(robot.areYouAt(50, 50, "West"));
    }

    public void test_canTurnLeft_manyTimes() {
        MarsRover robot = new MarsRover();
        robot.command("lll");
        assertTrue(robot.areYouAt(50, 50, "East"));
    }

    public void test_canMoveAndTurnManyTimes () {
        MarsRover robot = new MarsRover();
        robot.command("fffrfflbbblfffff");
        assertTrue(robot.areYouAt(47, 50, "West"));
    }
}
