package com.company.Item.Equipment.Modifiers;

import com.company.Item.Equipment.Equipment;
import com.company.Stat;

public class IncreaseDexterity extends Modifier {

    @Override
    public Stat increaseStat(int level) {
        return new Stat(0,0,
               0, (rnd.nextInt(11) + 10)  * level, 0);
    }

    public IncreaseDexterity(Equipment equipment, int level) {
        super(equipment, level);
    }
}
