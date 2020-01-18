package test.com.reagroup.app.model.command;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.reagroup.app.model.ToyRobot;
import com.reagroup.app.model.Direction;
import com.reagroup.app.model.command.LeftCommand;

public class LeftCommandTest {
    private ToyRobot toyRobot = null;
    private LeftCommand left = null;

    @Before
    public void initialize() {
        left = new LeftCommand();
        toyRobot = ToyRobot.getInstance();
        toyRobot.setDirection(Direction.EAST);
        toyRobot.setYIndex(0);
        toyRobot.setXIndex(0);
    }

    @Test
    public void execute() {
        assertEquals("Initial direction is EAST", Direction.EAST, toyRobot.getDirection());

        left.execute();
        assertEquals("After turning left, the toyRobot should be facing NORTH", Direction.NORTH, toyRobot.getDirection());

        left.execute();
        assertEquals("After turning left, the toyRobot should be facing WEST", Direction.WEST, toyRobot.getDirection());

        left.execute();
        assertEquals("After turning left, the toyRobot should be facing SOUTH", Direction.SOUTH, toyRobot.getDirection());

        left.execute();
        assertEquals("After turning left, the toyRobot should be facing EAST", Direction.EAST, toyRobot.getDirection());
    }

}
