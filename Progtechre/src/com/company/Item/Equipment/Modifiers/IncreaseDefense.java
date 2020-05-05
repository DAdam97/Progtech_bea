package com.company.Item.Equipment.Modifiers;

import com.company.Item.Equipment.Equipment;
import com.company.Stat;

public class IncreaseDefense extends Modifier {

    @Override
    public Stat increaseStat(int level) {
        return new Stat(0,(rnd.nextInt(11) + 10)  * level,
                0, 0,0);
    }

    public IncreaseDefense(Equipment equipment, int level) {
        super(equipment, level);
    }

}
