package com.reagroup.app.model.command;

import com.reagroup.app.exception.FactoryException;
import com.reagroup.app.factory.AbstractFactory;
import com.reagroup.app.model.Direction;

public class CommandFactory implements AbstractFactory<Command> {

    @Override
    public Command create(String... parameters) throws FactoryException, IllegalArgumentException {
        String commandType = parameters[0];
        if ("place".equalsIgnoreCase(commandType)) {
            validatePlaceParameterCount(parameters);
            String [] params = parameters[1].split(",");
            int xIndex = parseIndexParameter(params[0]);
            int yIndex = parseIndexParameter(params[1]);
            Direction direction = Direction.valueOf(params[2].toUpperCase());
            return new PlaceCommand(xIndex, yIndex, direction);
        } else if ("move".equalsIgnoreCase(commandType)) {
            return new MoveCommand();
        } else if ("left".equalsIgnoreCase(commandType)) {
            return new LeftCommand();
        } else if ("right".equalsIgnoreCase(commandType)) {
            return new RightCommand();
        } else if ("report".equalsIgnoreCase(commandType)) {
            return new ReportCommand();
        } else if ("quit".equalsIgnoreCase(commandType)) {
            return new QuitCommand();
        } else {
            throw new FactoryException("Invalid command - " + commandType);
        }
    }

    public void validatePlaceParameterCount(String... parameter) throws FactoryException {
        if (parameter.length != 2) {
            throw new FactoryException("Invalid number of parameters.");
        }
    }

    public int parseIndexParameter(String input) throws FactoryException {
        int index = 0;
        try {
            index = Integer.parseInt(input);
            if (index < 0 || index > 4) {
                throw new FactoryException("Parameter not allowed (" + index + ")");
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException | NullPointerException e) {
            throw new FactoryException("Invalid parameter (" + input + ")");
        }
        return index;
    }

}
