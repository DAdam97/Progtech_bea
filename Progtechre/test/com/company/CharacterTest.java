package com.company;

import com.company.Equipment.Chest;
import com.company.Equipment.Helmet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    @Test
    public void testCharacterStat(){
        Helmet h = new Helmet(new Stat(10, 20,30));
        Chest c = new Chest(new Stat(0,0, 100));

        Character ch = new Character(h, c);

        System.out.println(ch.toString());
    }

}