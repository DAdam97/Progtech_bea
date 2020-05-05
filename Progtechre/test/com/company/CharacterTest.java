package com.company;

import com.company.Item.Equipment.*;
import com.company.Item.Equipment.Modifiers.IncreaseDefense;
import com.company.Item.Weapon.BareHand;
import com.company.Item.Weapon.Bow;
import com.company.Item.Weapon.Sword;
import com.company.Item.Weapon.Weapon;
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

        C.equipWeapon( new Sword(1));
        assertNotEquals(new Sword(1), C.getWeapon());
    }

    @Test
    public void testHealthLoss(){
        Character dummy1 = new Character();
        Character dummy2 = new Character();
        assertEquals(100, dummy2.getStat().getHealth());

        dummy1.equipWeapon(new Sword(1));
        dummy1.attack(dummy2);
        assertEquals(true, 100 > dummy2.getStat().getHealth());
    }

    @Test
    public void testIsAlive(){
        Character dummy1 = new Character();
        Character dummy2 = new Character(new Position( 100, 0));
        assertEquals(true, dummy2.isAlive());

        dummy1.equipWeapon(new Bow(2));
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
    public void testWeaponStatAfterEquipmentChange(){
        Character dummy = new Character();
        Weapon sword = new Sword(5);

        dummy.equipWeapon(sword);
        System.out.println( dummy.getWeapon().getWeaponStat() );

        Equipment boots = new Boots(Stat.generateRandomStat(5));
        dummy.equip(boots);
        System.out.println( dummy.getStat() );
        System.out.println( dummy.getWeapon().getWeaponStat() );

        System.out.println();

        boots = new Boots(Stat.generateRandomStat(50));
        dummy.equip(boots);
        System.out.println( dummy.getStat() );
        System.out.println( dummy.getWeapon().getWeaponStat() );
    }
}