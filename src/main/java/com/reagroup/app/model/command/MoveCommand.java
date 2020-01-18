package com.reagroup.app.model.command;

import java.util.Arrays;
import java.util.List;

import com.reagroup.app.exception.AttemptToNavigateBeyondBoundaryException;
import com.reagroup.app.model.ToyRobot;
import com.reagroup.app.model.TableMap;

public class MoveCommand implements Command {

    private ToyRobot toyRobot = null;
    private TableMap tableMap = null;

    public MoveCommand() {
        toyRobot = ToyRobot.getInstance();
        tableMap = TableMap.getInstance();
    }

    @Override
    public void execute() throws AttemptToNavigateBeyondBoundaryException {
        List key = toyRobot.getExpectedLocationAsKeyList();
        if (tableMap.getMap().containsKey(key)) {
            toyRobot.move();
        } else {
            throw new AttemptToNavigateBeyondBoundaryException("An attempt to navigate beyond the table has occurred. Ignoring command.");
        }
    }
}
