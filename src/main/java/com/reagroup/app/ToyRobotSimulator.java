package com.reagroup.app;

import java.io.File;

import java.util.List;
import java.util.Map;

import com.reagroup.app.util.CommandManager;
import com.reagroup.app.util.logging.Logger;

public class ToyRobotSimulator {

    private static final Logger LOGGER = Logger.getLogger();

    public ToyRobotSimulator() {
    }

    public void startSimulation() {
        LOGGER.info("Welcome to the REA Group Toy Robot Simulator!");
        CommandManager commandManager = new CommandManager();
        commandManager.start();
    }
}
