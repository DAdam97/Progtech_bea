package com.company.Item.Equipment.Modifiers;

import com.company.Item.Equipment.Equipment;
import com.company.Stat;

public class IncreaseWisdom extends Modifier {
    @Override
    public Stat increaseStat(int level) {
        return new Stat(0,0,
                0, 0, (rnd.nextInt(11) + 10)  * level);
    }

    public IncreaseWisdom(Equipment equipment, int level) {
        super(equipment, level);
    }
}
