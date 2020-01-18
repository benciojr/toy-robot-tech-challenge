package com.reagroup.app.model.command;

import com.reagroup.app.model.ToyRobot;
import com.reagroup.app.util.logging.Logger;

public class ReportCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger();
    private ToyRobot toyRobot;

    public ReportCommand() {
        toyRobot = ToyRobot.getInstance();
    }

    @Override
    public void execute() {
        LOGGER.info("\nToy Robot Location: " + toyRobot.toString());
    }
}
