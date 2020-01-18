package com.reagroup.app.model.command;

import com.reagroup.app.util.logging.Logger;

public class QuitCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger();

    @Override
    public void execute() {
        LOGGER.info("Exiting the Toy Robot Simulator...");
    }
}
