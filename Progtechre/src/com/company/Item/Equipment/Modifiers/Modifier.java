package com.company.Item.Equipment.Modifiers;

import com.company.Item.Equipment.Equipment;
import com.company.Item.Equipment.EquipmentType;
import com.company.Stat;

import java.util.Random;

public abstract class Modifier extends Equipment {
    public static Random rnd = new Random();
    private Equipment equipment;
    private int modifierLevel = 0;

    public Equipment getBaseEquipment(){ return equipment; }
    public int getModifierLevel() { return modifierLevel; }

    @Override
    public EquipmentType getType() { return getBaseEquipment().getType(); }

    @Override
    public int getItemValue() {
        int val = getBaseEquipment().getItemValue();
        return val + (int)(val * 0.10 * getModifierLevel());
    }

    public abstract Stat increaseStat(int level);
    private int checkLevel(int level){
        if (level <= 0){ level = 1; }
        modifierLevel = level;
        return level;
    }

    private Modifier(Stat stat) { super(stat); }

    public Modifier(Equipment equipment, int level){
        this(equipment.getStat());
        this.equipment = equipment;
        equipment.getStat().addStat(increaseStat(checkLevel(level)));
    }
}
