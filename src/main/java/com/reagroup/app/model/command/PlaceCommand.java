package com.reagroup.app.model.command;

import com.reagroup.app.model.Direction;
import com.reagroup.app.model.ToyRobot;

public class PlaceCommand implements Command {

    private ToyRobot toyRobot;
    private int xIndex;
    private int yIndex;
    private Direction direction;

    public PlaceCommand(int x, int y, Direction direction) {
        toyRobot = ToyRobot.getInstance();
        this.xIndex = x;
        this.yIndex = y;
        this.direction = direction;
    }

    @Override
    public void execute() {
        toyRobot.setXIndex(this.xIndex);
        toyRobot.setYIndex(this.yIndex);
        toyRobot.setDirection(this.direction);
        toyRobot.setIsPlacedOnTable(true);
    }
}
