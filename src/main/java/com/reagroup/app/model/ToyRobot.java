package com.reagroup.app.model;

import java.util.Arrays;
import java.util.List;

public class ToyRobot {

    private int yIndex;
    private int xIndex;
    private Direction direction;
    private boolean isPlacedOnTable = false;

    private static ToyRobot instance = null;

    public static ToyRobot getInstance() {
        if (instance == null) {
            synchronized(ToyRobot.class) {
                if (instance == null) {
                    instance = new ToyRobot(Direction.NORTH, -1, -1);
                }
            }
        }
        return instance;
    }

    public ToyRobot(Direction direction, int yIndex, int xIndex) {
        this.yIndex = yIndex;
        this.xIndex = xIndex;
        this.direction = direction;
    }

    public int getYIndex() {
        return yIndex;
    }

    public void setYIndex(int yIndex) {
        this.yIndex = yIndex;
    }

    public int getXIndex() {
        return xIndex;
    }

    public void setXIndex(int xIndex) {
        this.xIndex = xIndex;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * Rotates the robot 90 degrees to the left
     * without changing the position of the robot.
     */
    public void turnLeft() {
        this.turnLeft(this.getDirection());
    }

    private void turnLeft(Direction direction) {
        Direction newDirection = Direction.getValues()[(direction.ordinal() + (Direction.getValues().length - 1)) % Direction.getValues().length];
        this.setDirection(newDirection);
    }

    /**
     * Rotates the robot 90 degrees to the right
     * without changing the position of the robot.
     */
    public void turnRight() {
        this.turnRight(this.getDirection());
    }

    private void turnRight(Direction direction) {
        Direction newDirection = Direction.getValues()[(direction.ordinal() + 1) % Direction.getValues().length];
        this.setDirection(newDirection);
    }

    /**
     * Moves the robot one unit forward in the specified direction.
     */
    public void move() {
        this.advance(1);
    }

    private void advance(int moveCount) {
        Direction currentDirection = this.getDirection();
        switch (currentDirection){
            case NORTH: this.setYIndex(this.getYIndex() + moveCount); break;
            case EAST: this.setXIndex(this.getXIndex() + moveCount); break;
            case SOUTH: this.setYIndex(this.getYIndex() - moveCount); break;
            case WEST: this.setXIndex(this.getXIndex() - moveCount); break;
            default: break;
        }
    }

    /**
     * Predicts the coordinates for making a move forward.
     * This is used to check whether the move is valid and to prevent
     * it if it is not.
     */
    public List getExpectedLocationAsKeyList() {
        Direction currentDirection = this.getDirection();
        int xIndex = this.getXIndex();
        int yIndex = this.getYIndex();
        switch (currentDirection) {
            case NORTH: yIndex = this.getYIndex() + 1; break;
            case EAST: xIndex = this.getXIndex() + 1; break;
            case SOUTH: yIndex = this.getYIndex() - 1; break;
            case WEST: xIndex = this.getXIndex() - 1; break;
            default: break;
        }
        return Arrays.asList(xIndex, yIndex);
    }

    public String toString() {
        return getXIndex() + "," + getYIndex() + "," + getDirection();
    }

    public boolean getIsPlacedOnTable() {
        return isPlacedOnTable;
    }

    public void setIsPlacedOnTable(boolean isPlacedOnTable) {
        this.isPlacedOnTable = isPlacedOnTable;
    }
}