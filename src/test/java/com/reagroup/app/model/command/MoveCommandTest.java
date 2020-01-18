package test.com.reagroup.app.model.command;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.reagroup.app.exception.AttemptToNavigateBeyondBoundaryException;
import com.reagroup.app.model.ToyRobot;
import com.reagroup.app.model.Direction;
import com.reagroup.app.model.command.MoveCommand;

public class MoveCommandTest {
    private ToyRobot toyRobot = null;
    private MoveCommand move = null;

    @Before
    public void initialize() {
        move = new MoveCommand();
        toyRobot = ToyRobot.getInstance();
        toyRobot.setDirection(Direction.SOUTH);
        toyRobot.setYIndex(0);
        toyRobot.setXIndex(0);
    }

    @Test(expected = AttemptToNavigateBeyondBoundaryException.class)
    public void execute_whenAttemptToNavigateBeyondBoundaryOccurred() throws AttemptToNavigateBeyondBoundaryException {
        move.execute();
    }

    @Test
    public void execute() throws AttemptToNavigateBeyondBoundaryException {
        assertEquals("Initial direction is SOUTH", Direction.SOUTH, toyRobot.getDirection());

        toyRobot.turnLeft();
        assertEquals("After turning left, the toyRobot should be facing EAST", Direction.EAST, toyRobot.getDirection());
        move.execute();
        move.execute();
        move.execute();
        move.execute();

        assertEquals("X index is now 4", 4, toyRobot.getXIndex());
        assertEquals("Y index is now 0", 0, toyRobot.getYIndex());

        toyRobot.turnLeft();
        assertEquals("After turning left, the toyRobot should be facing NORTH", Direction.NORTH, toyRobot.getDirection());

        move.execute();
        move.execute();
        move.execute();
        move.execute();

        assertEquals("X index is now 4", 4, toyRobot.getXIndex());
        assertEquals("Y index is now 4", 4, toyRobot.getYIndex());

        toyRobot.turnLeft();
        assertEquals("After turning left, the toyRobot should be facing WEST", Direction.WEST, toyRobot.getDirection());

        move.execute();
        move.execute();
        move.execute();
        move.execute();

        assertEquals("X index is now 0", 0, toyRobot.getXIndex());
        assertEquals("Y index is now 4", 4, toyRobot.getYIndex());

        toyRobot.turnLeft();
        assertEquals("After turning left, the toyRobot should be facing SOUTH", Direction.SOUTH, toyRobot.getDirection());

        move.execute();
        move.execute();
        move.execute();
        move.execute();

        assertEquals("X index is now 0", 0, toyRobot.getXIndex());
        assertEquals("Y index is now 0", 0, toyRobot.getYIndex());
    }

}
