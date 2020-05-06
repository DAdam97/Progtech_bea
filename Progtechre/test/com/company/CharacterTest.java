package com.company;

import com.company.Item.Equipment.*;
import com.company.Item.Equipment.Modifiers.IncreaseDefense;
import com.company.Item.Weapon.BareHand;
import com.company.Item.Weapon.Bow;
import com.company.Item.Weapon.Enchantment.NeutralEnchantment;
import com.company.Item.Weapon.Sword;
import com.company.Item.Weapon.Weapon;
import com.sun.jdi.BooleanType;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

class CharacterTest {

    @Test
    public void testCharacterStat(){
        Position pos = new Position(10, 10);
        Helmet h = new Helmet(Stat.generateRandomStat(1));
        Chest c = new Chest(Stat.generateRandomStat(1));
        Gloves g = new Gloves(Stat.generateRandomStat(1));
        Pants p = new Pants(Stat.generateRandomStat(1));
        Boots b = new Boots(Stat.generateRandomStat(1));

        Character ch = new Character(pos, h, c, g, p, b);

        System.out.println( ch.getStat() );
    }

    @Test
    public void testWeaponRangeWithBareHand(){
        Character c0 = new Character();
        Character c1 = new Character(new Position(3,3));
        assertEquals(false, c0.attack(c1));

        c1.getPosition().moveForwardInDirection(Direction.SOUTHWEST, 1);
        assertEquals(true, c0.attack(c1));
    }

    @Test
    public void testWeaponEquip(){
        Character C = new Character();
        assertEquals(new BareHand().toString(), C.getWeapon().toString());
        Weapon sword = new Sword(1, new NeutralEnchantment());

        C.equipWeapon(sword);
        assertNotEquals(new Sword(1, new NeutralEnchantment()), C.getWeapon());
    }

    @Test
    public void testHealthLoss(){
        Character dummy1 = new Character();
        Character dummy2 = new Character();
        assertEquals(100, dummy2.getStat().getHealth());

        dummy1.equipWeapon(new Sword(1, new NeutralEnchantment()));
        dummy1.attack(dummy2);
        assertEquals(true, 100 > dummy2.getStat().getHealth());
    }

    @Test
    public void testIsAlive(){
        Character dummy1 = new Character();
        Character dummy2 = new Character(new Position( 100, 0));
        assertEquals(true, dummy2.isAlive());

        dummy1.equipWeapon(new Bow(2, new NeutralEnchantment()));
        for(int i = 0; i < 10; i++)
            dummy1.attack(dummy2);

        assertEquals(false, dummy2.isAlive());
        assertEquals(0, dummy2.getStat().getHealth());
    }

    @Test
    public void testEquip(){
        Character dummy = new Character();
        Equipment chest = new Chest(Stat.generateRandomStat(2));

        dummy.equip(chest);
        assertEquals(chest, dummy.getChest());

        chest = new IncreaseDefense(chest, 10);
        dummy.equip(chest);
        assertEquals(chest, dummy.getChest());

        Equipment boots = new Boots(Stat.generateRandomStat(8));
        dummy.equip(boots);
        assertEquals(boots, dummy.getBoots());
    }

    @Test
    public void testWeaponStatAfterEquipmentChange() {
        Character dummy = new Character();
        Weapon sword = new Sword(5, new NeutralEnchantment()
        );
        dummy.equipWeapon(sword);
        assertEquals(dummy.getStat().toString(), sword.getWeaponStat().toString());

        System.out.println(dummy.getStat().toString() + "\n"+ sword.getWeaponStat().toString());

        Equipment boots = new Boots(Stat.generateRandomStat(1));
        dummy.equip(boots);
        assertEquals(dummy.getStat().toString(), sword.getWeaponStat().toString());

        System.out.println(dummy.getStat().toString() + "\n"+ sword.getWeaponStat().toString());

        Boots newBoots = new Boots(Stat.generateRandomStat(100));
        dummy.equip(newBoots);
        assertEquals(dummy.getStat().toString(), sword.getWeaponStat().toString());

        System.out.println(dummy.getStat().toString() + "\n"+ sword.getWeaponStat().toString());
    }
}