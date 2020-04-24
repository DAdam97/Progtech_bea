package com.company;

import com.company.Equipment.*;
import org.junit.jupiter.api.Test;

class CharacterTest {

    @Test
    public void testCharacterStat(){
        Helmet h = new Helmet(Stat.getRandomStat());
        Chest c = new Chest(Stat.getRandomStat());
        Gloves g = new Gloves(Stat.getRandomStat());
        Pants p = new Pants(Stat.getRandomStat());
        Boots b = new Boots(Stat.getRandomStat());

        Character ch = new Character(h, c, g, p, b);

        System.out.println(ch.toString());
    }

}