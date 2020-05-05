package com.company.Item.Equipment.Modifiers;

import com.company.Item.Equipment.Equipment;
import com.company.Stat;

public class IncreaseStrength extends Modifier {

    @Override
    public Stat increaseStat(int level) {
        return new Stat(0,0,
                (rnd.nextInt(11) + 10)  * level,0,0);
    }

    public IncreaseStrength(Equipment equipment, int level) {
        super(equipment, level);
    }
}
