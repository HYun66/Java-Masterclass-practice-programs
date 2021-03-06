package com.huiyun;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description) {
        this.locationID = locationID;
        this.description = description;
        this.exits = new HashMap<String, Integer>();
        exits.put("Q", 0);
    }

    public int getLocationID() {
        return locationID;
    }

    public void addExit(String direction, int location) {
        exits.put(direction, location);
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }

    public String getDescription() {
        return description;
    }

}
