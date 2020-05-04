package com.company;

import com.company.Item.Equipment.*;
import org.junit.jupiter.api.Test;

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

        System.out.println(ch.toString());
    }

}