package com.company.Item;

import com.company.Item.Equipment.Chest;
import com.company.Item.Equipment.Equipment;
import com.company.Item.Equipment.Modifiers.*;
import com.company.Item.Weapon.Bow;
import com.company.Item.Weapon.Sword;
import com.company.Item.Weapon.Weapon;
import com.company.Stat;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void testItemID() {
        Weapon sword = new Sword(1);
        Weapon bow = new Bow(1);
        Equipment chest = new Chest(Stat.generateRandomStat(1));

        assertEquals("Item0", sword.getItemID());
        assertEquals("Item1", bow.getItemID());
        assertEquals("Item2", chest.getItemID());
    }

    @Test
    public void testItemValue(){
        Equipment e = new Chest(Stat.generateRandomStat(2));
        assertEquals(30, e.getItemValue());

        e = new IncreaseHealth(e, 10);
        e = new IncreaseDefense(e, 10);
        e = new IncreaseStrength(e, 10);
        e = new IncreaseDexterity(e, 10);
        e = new IncreaseWisdom(e, 10);

        assertEquals(960, e.getItemValue());

        System.out.println( e.getStat() );
    }
}