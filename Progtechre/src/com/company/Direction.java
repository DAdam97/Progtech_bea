package com.company;

import java.util.HashMap;

public enum Direction {
    East(0),
    NorthEast(1),
    North(2),
    NorthWest(3),
    West(4),
    SouthWest(5),
    South(6),
    SouthEast(7);

    private int value;
    private static HashMap map = new HashMap<>();

    private Direction (int val){ this.value = val; }

    static {
        for (Direction dir : Direction.values()){
            map.put(dir.value, dir);
        }
    }

    public static Direction valueOf(int dir){
        return (Direction) map.get(dir);
    }

    public int getValue(){
        return value;
    }
}
