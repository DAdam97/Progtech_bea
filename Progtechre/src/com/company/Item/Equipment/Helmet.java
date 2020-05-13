package com.company.Item.Equipment;

import com.company.Stat;

public class Helmet extends Equipment {
    @Override
    public EquipmentType getType() { return EquipmentType.Helmet; }

    @Override
    public int getItemValue() {
        int baseValue = 15;
        return  baseValue;
    }

    public Helmet(Stat stat) {
        super(stat);
    }
}
