package com.reagroup.app.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.reagroup.app.exception.AttemptToNavigateBeyondBoundaryException;
import com.reagroup.app.exception.FactoryException;
import com.reagroup.app.factory.AbstractFactory;
import com.reagroup.app.factory.FactoryProvider;
import com.reagroup.app.model.command.Command;
import com.reagroup.app.model.command.PlaceCommand;
import com.reagroup.app.model.ToyRobot;
import com.reagroup.app.util.logging.Logger;

public class CommandManager {

    private static final Logger LOGGER = Logger.getLogger();
    private Scanner inputScanner;
    private String input;
    private ToyRobot toyRobot;

    public CommandManager() {
        inputScanner = new Scanner(System.in);
        toyRobot = ToyRobot.getInstance();
    }

    public void start() {

        LOGGER.info("\nPlease enter commands for the toy robot (PLACE <X,Y,F>, MOVE, LEFT, RIGHT, REPORT, QUIT)\n", false);
        do {
            LOGGER.info(" > ", false);
            input = inputScanner.nextLine();
            String userInput[] = input.trim().split(" ");

            Command command = create(userInput);
            if (null != command) {
                execute(command);
            }

        } while (!input.equalsIgnoreCase("quit"));
        inputScanner.close();

    }

    private Command create(String... commandParameters) {
        AbstractFactory factory = FactoryProvider.getFactory("Command");
        try {
            return (Command) factory.create(commandParameters);
        } catch (FactoryException e) {
            LOGGER.error("Ignoring invalid command - " + e.getMessage());
        } catch (IllegalArgumentException e) {
            LOGGER.error("Ignoring invalid argument - " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            LOGGER.error("Ignoring invalid argument - " + e.getMessage());
        }
        return null;
    }

    private void execute(Command command) {
        try {
            if (!(command instanceof PlaceCommand) && !(toyRobot.getIsPlacedOnTable())) {
                LOGGER.error("Ignoring command. Please enter a PLACE command to put the toy robot on the table.");
            } else {
                command.execute();
            }
        } catch (AttemptToNavigateBeyondBoundaryException e) {
            LOGGER.error(e.getMessage());
        }
    }

}
