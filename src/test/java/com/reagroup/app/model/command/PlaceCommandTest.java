package test.com.reagroup.app.model.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.reagroup.app.model.ToyRobot;
import com.reagroup.app.model.Direction;
import com.reagroup.app.model.command.PlaceCommand;

public class PlaceCommandTest {
    private ToyRobot toyRobot = null;
    private PlaceCommand place = null;

    @Before
    public void initialize() {
        toyRobot = ToyRobot.getInstance();
    }

    @Test
    public void execute_SetDirectionToNorth() {
        place = new PlaceCommand(0, 0, Direction.NORTH);
        place.execute();
        assertEquals("Direction is NORTH", Direction.NORTH, toyRobot.getDirection());
        assertEquals("x index is 0", 0, toyRobot.getXIndex());
        assertEquals("y index is 0", 0, toyRobot.getYIndex());
        assertTrue(toyRobot.getIsPlacedOnTable());
    }

    @Test
    public void execute_SetDirectionToSouth() {
        place = new PlaceCommand(1, 1, Direction.SOUTH);
        place.execute();
        assertEquals("Direction is SOUTH", Direction.SOUTH, toyRobot.getDirection());
        assertEquals("x index is 1", 1, toyRobot.getXIndex());
        assertEquals("y index is 1", 1, toyRobot.getYIndex());
        assertTrue(toyRobot.getIsPlacedOnTable());
    }

    @Test
    public void execute_SetDirectionToEast() {
        place = new PlaceCommand(2, 2, Direction.EAST);
        place.execute();
        assertEquals("Direction is EAST", Direction.EAST, toyRobot.getDirection());
        assertEquals("x index is 2", 2, toyRobot.getXIndex());
        assertEquals("y index is 2", 2, toyRobot.getYIndex());
        assertTrue(toyRobot.getIsPlacedOnTable());
    }

    @Test
    public void execute_SetDirectionToWest() {
        place = new PlaceCommand(3, 3, Direction.WEST);
        place.execute();
        assertEquals("Direction is WEST", Direction.WEST, toyRobot.getDirection());
        assertEquals("x index is 3", 3, toyRobot.getXIndex());
        assertEquals("y index is 3", 3, toyRobot.getYIndex());
        assertTrue(toyRobot.getIsPlacedOnTable());
    }

}
