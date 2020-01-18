package test.com.reagroup.app.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.reagroup.app.model.ToyRobot;
import com.reagroup.app.model.Direction;

public class ToyRobotTest {

    private ToyRobot toyRobot = null;

    @Before
    public void initialize() {
        toyRobot = ToyRobot.getInstance();
        toyRobot.setDirection(Direction.EAST);
        toyRobot.setYIndex(1);
        toyRobot.setXIndex(0);
    }

    @Test
    public void testInitialValues() {
        assertEquals("Initial direction is facing EAST", Direction.EAST, toyRobot.getDirection());
        assertEquals("Initial y index should be 1", 1, toyRobot.getYIndex());
        assertEquals("Initial x index should be 0", 0, toyRobot.getXIndex());
    }

    @Test
    public void testLeftTurn() {
        assertEquals("Initial direction is EAST", Direction.EAST, toyRobot.getDirection());

        toyRobot.turnLeft();
        assertEquals("After turning left, the toyRobot should be facing NORTH", Direction.NORTH, toyRobot.getDirection());

        toyRobot.turnLeft();
        assertEquals("After turning left, the toyRobot should be facing WEST", Direction.WEST, toyRobot.getDirection());

        toyRobot.turnLeft();
        assertEquals("After turning left, the toyRobot should be facing SOUTH", Direction.SOUTH, toyRobot.getDirection());

        toyRobot.turnLeft();
        assertEquals("After turning left, the toyRobot should be facing EAST", Direction.EAST, toyRobot.getDirection());
    }

    @Test
    public void testRightTurn() {
        assertEquals("Initial direction is EAST", Direction.EAST, toyRobot.getDirection());

        toyRobot.turnRight();
        assertEquals("After turning right, the toyRobot should be facing SOUTH", Direction.SOUTH, toyRobot.getDirection());

        toyRobot.turnRight();
        assertEquals("After turning right, the toyRobot should be facing WEST", Direction.WEST, toyRobot.getDirection());

        toyRobot.turnRight();
        assertEquals("After turning right, the toyRobot should be facing NORTH", Direction.NORTH, toyRobot.getDirection());

        toyRobot.turnRight();
        assertEquals("After turning right, the toyRobot should be facing EAST", Direction.EAST, toyRobot.getDirection());
    }

    @Test
    public void testMove() {
        assertEquals("Initial direction is EAST", Direction.EAST, toyRobot.getDirection());
        assertEquals("Initial y index should be 1", 1, toyRobot.getYIndex());
        assertEquals("Initial x index should be 0", 0, toyRobot.getXIndex());

        toyRobot.move();
        assertEquals("After advancing, the toyRobot should be in the new position [1,1]", 1, toyRobot.getXIndex());
        assertEquals("After advancing, the toyRobot should be in the new position [1,1]", 1, toyRobot.getYIndex());

        toyRobot.turnRight();
        toyRobot.move();
        assertEquals("After turning right and advancing, the toyRobot should be in the new position [1,0]", 1, toyRobot.getXIndex());
        assertEquals("After turning right and advancing, the toyRobot should be in the new position [1,0]", 0, toyRobot.getYIndex());

        toyRobot.turnRight();
        toyRobot.move();
        assertEquals("After turning right and advancing, the toyRobot should be in the new position [0,0]", 0, toyRobot.getXIndex());
        assertEquals("After turning right and advancing, the toyRobot should be in the new position [0,0]", 0, toyRobot.getYIndex());

        toyRobot.turnRight();
        toyRobot.move();
        assertEquals("After turning right and advancing, the toyRobot should be in the new position [0,1]", 0, toyRobot.getXIndex());
        assertEquals("After turning right and advancing, the toyRobot should be in the new position [0,1]", 1, toyRobot.getYIndex());
    }

}