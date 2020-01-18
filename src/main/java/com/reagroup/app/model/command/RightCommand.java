package com.reagroup.app.model.command;

import com.reagroup.app.model.ToyRobot;

public class RightCommand implements Command {

    private ToyRobot toyRobot;

    public RightCommand() {
        toyRobot = ToyRobot.getInstance();
    }

    @Override
    public void execute() {
        toyRobot.turnRight();
    }
}
