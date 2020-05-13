package com.company.Item.Equipment;

import com.company.Stat;

public class Pants extends Equipment {
    @Override
    public EquipmentType getType() { return EquipmentType.Pants; }

    @Override
    public int getItemValue() {
        int baseValue = 15;
        return  baseValue;
    }

    public Pants(Stat stat) {
        super(stat);
    }
}
