package com.reagroup.app.model.command;

import com.reagroup.app.model.ToyRobot;

public class LeftCommand implements Command {

    private ToyRobot toyRobot;

    public LeftCommand() {
        toyRobot = ToyRobot.getInstance();
    }

    @Override
    public void execute() {
        toyRobot.turnLeft();
    }
}
