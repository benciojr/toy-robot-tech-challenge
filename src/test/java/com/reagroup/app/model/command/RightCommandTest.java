package test.com.reagroup.app.model.command;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.reagroup.app.model.ToyRobot;
import com.reagroup.app.model.Direction;
import com.reagroup.app.model.command.RightCommand;

public class RightCommandTest {
    private ToyRobot toyRobot = null;
    private RightCommand right = null;

    @Before
    public void initialize() {
        right = new RightCommand();
        toyRobot = ToyRobot.getInstance();
        toyRobot.setDirection(Direction.EAST);
        toyRobot.setYIndex(0);
        toyRobot.setXIndex(0);
    }

    @Test
    public void execute() {
        assertEquals("Initial direction is EAST", Direction.EAST, toyRobot.getDirection());

        right.execute();
        assertEquals("After turning right, the toyRobot should be facing SOUTH", Direction.SOUTH, toyRobot.getDirection());

        right.execute();
        assertEquals("After turning right, the toyRobot should be facing WEST", Direction.WEST, toyRobot.getDirection());

        right.execute();
        assertEquals("After turning right, the toyRobot should be facing NORTH", Direction.NORTH, toyRobot.getDirection());

        right.execute();
        assertEquals("After turning right, the toyRobot should be facing EAST", Direction.EAST, toyRobot.getDirection());
    }

}
