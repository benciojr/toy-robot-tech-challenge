package com.reagroup.app;

import com.reagroup.app.util.logging.Logger;

public class ApplicationMain {

    private static final Logger LOGGER = Logger.getLogger();

    public static void main(String[] args) {
        ToyRobotSimulator simulator = new ToyRobotSimulator();
        simulator.startSimulation();
        LOGGER.info("\nThank you for using the REA Group Toy Robot simulator.");
    }
}
