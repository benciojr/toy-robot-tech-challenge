package com.reagroup.app.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class represents the table surface. Coordinates are assigned
 * to the table surface (squares) and they are stored in a hash map.
 * The coordinates are used to determine where the toy robot is and
 * if it is already out of bounds.
 */
public class TableMap {

    private static TableMap instance = null;
    private Map<List, Object> map = null;
    private static final int DIMENSION_X = 5;
    private static final int DIMENSION_Y = 5;

    private TableMap() {
        this.initializeMap();
    }

    public static TableMap getInstance() {
        if (instance == null) {
            synchronized(TableMap.class) {
                if (instance == null) {
                    instance = new TableMap();
                }
            }
        }
        return instance;
    }

    public Map<List, Object> getMap() {
        return map;
    }

    public void setMap(Map<List, Object> map) {
        this.map = map;
    }

    /**
     * Initializes the table area coordinates and stores them into a hash map.
     * Coordinates not found in the map are considered out of bounds.
     **/
    private void initializeMap() {
        map = new HashMap<List, Object>();
        for (int x = 0; x < DIMENSION_X; x++) {
            for (int y = 0; y < DIMENSION_Y; y++) {
                List keyList = Arrays.asList(x, y);
                map.put(keyList, "");
            }
        }
    }
}
