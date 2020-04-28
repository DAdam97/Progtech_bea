package com.company;

import com.company.Equipment.*;
import org.junit.jupiter.api.Test;

class CharacterTest {

    @Test
    public void testCharacterStat(){
        Helmet h = new Helmet(Stat.generateRandomStat(1));
        Chest c = new Chest(Stat.generateRandomStat(1));
        Gloves g = new Gloves(Stat.generateRandomStat(1));
        Pants p = new Pants(Stat.generateRandomStat(1));
        Boots b = new Boots(Stat.generateRandomStat(1));

        Character ch = new Character(h, c, g, p, b);

        System.out.println(ch.toString());
    }

}