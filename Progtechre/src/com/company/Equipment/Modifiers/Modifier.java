package com.company.Equipment.Modifiers;

import com.company.Equipment.Equipment;
import com.company.Stat;

import java.util.Random;

public abstract class Modifier extends Equipment {
    private Equipment equipment;
    public Random rnd = new Random();

    public abstract Stat increaseStat(int level);
    private int checkLevel(int level){
        if (level <= 0){ level = 1; }
        return level;
    }

    private Modifier(Stat stat) { super(stat); }

    public Modifier(Equipment equipment, int level){
        this(equipment.getStat());
        this.equipment = equipment;
        equipment.getStat().addStat(increaseStat(checkLevel(level)));
    }
}
