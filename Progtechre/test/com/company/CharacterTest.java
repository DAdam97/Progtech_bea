package com.company;

import com.company.Equipment.Helmet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    @Test
    public void testCharacterStat(){
        Helmet h = new Helmet(new Stat(10, 20,30));
        Character ch = new Character(h);

        System.out.println(ch.toString());
    }

}