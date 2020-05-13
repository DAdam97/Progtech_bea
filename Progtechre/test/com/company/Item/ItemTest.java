package com.company.Item;

import com.company.Character;
import com.company.Item.Equipment.Boots;
import com.company.Item.Equipment.Chest;
import com.company.Item.Equipment.Equipment;
import com.company.Item.Equipment.EquipmentFactory;
import com.company.Item.Equipment.Modifiers.*;
import com.company.Item.Weapon.Bow;
import com.company.Item.Weapon.Enchantment.NeutralEnchantment;
import com.company.Item.Weapon.Sword;
import com.company.Item.Weapon.Weapon;
import com.company.Stat;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void testItemID() {
        Weapon sword = new Sword(1, new NeutralEnchantment());
        Weapon bow = new Bow(1, new NeutralEnchantment());
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

    @Test
    public void test(){
        EquipmentFactory ef = new EquipmentFactory();

        Character c = new Character();
        Character e = new Character();

        while (e.isAlive()){
            System.out.println("your health:" + c.getStat().getHealth());
            System.out.println("enemy health:" + e.getStat().getHealth());

            e.attack(c);
            c.attack(e);
        }


    }
}