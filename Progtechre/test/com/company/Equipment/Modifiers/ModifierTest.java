package com.company.Equipment.Modifiers;

import com.company.Equipment.*;
import com.company.Stat;
import org.junit.jupiter.api.Test;

class ModifierTest {

    @Test
    public void testIncreaseHealth(){
        Stat s = new Stat(50,100,25,5,5);
        Equipment c = new Chest(s);
        System.out.println(c.getStat());

        Equipment c2 = new IncreaseHealth(c, 100);
        System.out.println(c2.getStat());

        Chest C = (Chest) c2;
    }

}