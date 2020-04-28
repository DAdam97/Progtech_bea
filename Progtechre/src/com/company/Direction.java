package com.company;

import java.util.HashMap;

public enum Direction {
    EAST(0),
    NORTHEAST(1),
    NORTH(2),
    NORTHWEST(3),
    WEST(4),
    SOUTHWEST(5),
    SOUTH(6),
    SOUTHEAST(7);

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
