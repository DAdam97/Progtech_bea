package com.company.Item.Equipment;

import com.company.Stat;

public class Gloves extends Equipment {
    @Override
    public EquipmentType getType() { return EquipmentType.BOOTS; }

    @Override
    public int getItemValue() {
        int baseValue = 20;
        return  baseValue;
    }

    public Gloves(Stat stat) {
        super(stat);
    }
}
