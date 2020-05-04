package com.company.Item.Equipment.Modifiers;

import com.company.Item.Equipment.Equipment;
import com.company.Stat;

public class IncreaseHealth extends Modifier {

    @Override
    public Stat increaseStat(int level) {
        return new Stat((rnd.nextInt(11) + 10)  * level, 0,
                            0, 0,0);
    }

    public IncreaseHealth(Equipment equipment, int level) {
        super(equipment, level);
    }
}
