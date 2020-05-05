package com.company.Item.Equipment;

import com.company.Stat;

public class Chest extends Equipment {
    @Override
    public EquipmentType getType() { return EquipmentType.CHEST; }

    @Override
    public int getItemValue() {
        int baseValue = 30;
        return  baseValue;
    }

    public Chest(Stat stat) {
        super(stat);
    }
}
