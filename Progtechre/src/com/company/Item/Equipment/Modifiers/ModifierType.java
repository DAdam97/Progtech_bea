package com.company.Item.Equipment.Modifiers;

import java.util.HashMap;

public enum ModifierType {
    IncreaseHealth(0),
    IncreaseDefense(1),
    IncreaseStrength(2),
    IncreaseDexterity(3),
    IncreaseWisdom(4);

    private int value;
    private static HashMap map = new HashMap<>();

    private ModifierType(int val) { this.value = val; }

    static {
        for (ModifierType type : ModifierType.values()){
            map.put(type.value, type);
        }
    }

    public static ModifierType valueOf(int type){
        return (ModifierType) map.get(type);
    }

    public int getValue(){ return value; }
}
