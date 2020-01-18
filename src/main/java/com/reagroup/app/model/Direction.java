package com.reagroup.app.model;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    private static Direction[] values = values();

    public static Direction[] getValues() {
        return values;
    }
}