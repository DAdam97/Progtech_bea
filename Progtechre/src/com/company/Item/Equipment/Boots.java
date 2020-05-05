package com.company.Item.Equipment;

import com.company.Stat;

public class Boots extends Equipment {
    @Override
    public EquipmentType getType() { return EquipmentType.BOOTS; }

    @Override
    public int getItemValue() {
        int baseValue = 10;
        return  baseValue;
    }

    public Boots(Stat stat) {
        super(stat);
    }
}
