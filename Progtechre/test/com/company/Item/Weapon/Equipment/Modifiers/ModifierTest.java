package com.company.Item.Weapon.Equipment.Modifiers;

import com.company.*;
import com.company.Item.Equipment.*;
import com.company.Item.Equipment.Modifiers.IncreaseHealth;
import org.junit.Test;

import static org.junit.Assert.*;

public class ModifierTest {

    @Test
    public void testIncreaseHealth(){
        int hpBefore = 100;
        Stat s = new Stat(hpBefore,100,25,5,5);
        Equipment c = new Chest(s);
        System.out.println(c.getStat());

        int counter = 7;
        int level = 2;
        int minVal = 10;
        int maxVal = 20;
        int minHp = hpBefore + (minVal * level * counter);
        int maxHp = hpBefore + (maxVal * level * counter);

        for (int i = 0; i < counter; i++)
            c = new IncreaseHealth(c, level);

        int hpAfter = c.getStat().getHealth();

        System.out.println(c.getStat());
        System.out.println("MinHP: " + minHp + "\nMaxHp: " + maxHp);

        assertEquals(true, minHp <= hpAfter && hpAfter <= maxHp);
    }

}