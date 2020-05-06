package com.company.Item.Weapon.Enchantment;

import com.company.Character;
import com.company.Item.Equipment.Boots;
import com.company.Item.Equipment.Equipment;
import com.company.Item.Weapon.Sword;
import com.company.Item.Weapon.TestWeapon;
import com.company.Item.Weapon.Weapon;
import com.company.Stat;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class EnchantmentTest {
    @Test
    public void testTrueDamageEnchantment(){

        Character neutralDummy = new Character();
        Character trueDummy = new Character();

        Equipment b1 = new Boots(new Stat(900, 10, 100,0,0));

        Weapon wNeutral = new TestWeapon(200, 100, 0,0,0, new NeutralEnchantment());
        Weapon wTrue = new TestWeapon(200, 100, 0,0,0, new TrueDamageEnchantment());

        neutralDummy.equip(b1);
        trueDummy.equip(b1);


        System.out.println(neutralDummy.getStat().toString());
        System.out.println(trueDummy.getStat().toString());

        int beforeNeutralDmg = trueDummy.getStat().getHealth();
        int beforeTrueDmg = neutralDummy.getStat().getHealth();

        neutralDummy.equipWeapon(wNeutral);
        trueDummy.equipWeapon(wTrue);

        neutralDummy.attack(trueDummy);
        System.out.println(trueDummy.getStat().toString());


        trueDummy.attack(neutralDummy);
        System.out.println(neutralDummy.getStat().toString());

        int afterNeutralDmg = trueDummy.getStat().getHealth();
        int afterTrueDmg = neutralDummy.getStat().getHealth();

        int sumNeu = beforeNeutralDmg - afterNeutralDmg;
        int sumTru = beforeTrueDmg - afterTrueDmg;

        assertEquals(true, sumTru > sumNeu);

        System.out.println(sumNeu + " | " + sumTru);

        // keresztül ütött az elenfél páncélján

    }


}