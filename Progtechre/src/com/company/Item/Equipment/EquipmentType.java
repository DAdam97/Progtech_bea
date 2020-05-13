package com.company.Item.Equipment;

import com.company.Item.Equipment.Modifiers.ModifierType;

import java.util.HashMap;

public enum EquipmentType {
    Helmet(0),
    Chest(1),
    Gloves(2),
    Pants(3),
    Boots(4);

    private int slot;
    private static HashMap map = new HashMap<>();

    private EquipmentType(int slot) { this.slot = slot; }

    static {
        for (EquipmentType type : EquipmentType.values()){
            map.put(type.slot, type);
        }
    }

    public static EquipmentType valueOf(int slot){
        return (EquipmentType) map.get(slot);
    }

    public int getValue(){ return slot; }
}
