package com.company;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;


public class PositionTest {

    @Test
    public void testFaceTo() {
        Character c0 = new Character(new Position(5,5));
        Character c1 = new Character(new Position(34,-7));

        /*      EAST        */
        c0.getPosition().faceTo(Direction.WEST);
        c0.getPosition().faceTo(c1);
        assertEquals(Direction.EAST, c0.getPosition().getFacing());
        c1.getPosition().moveTo(new Position(44, 21));
        c0.getPosition().faceTo(Direction.WEST);
        c0.getPosition().faceTo(c1);
        assertEquals(Direction.EAST, c0.getPosition().getFacing());

        /*      NORTHEAST        */
        c1.getPosition().moveTo(new Position(43, 21));
        c0.getPosition().faceTo(Direction.WEST);
        c0.getPosition().faceTo(c1);
        assertEquals(Direction.NORTHEAST, c0.getPosition().getFacing());
        c1.getPosition().moveTo(new Position(19, 38));
        c0.getPosition().faceTo(Direction.WEST);
        c0.getPosition().faceTo(c1);
        assertEquals(Direction.NORTHEAST, c0.getPosition().getFacing());

        /*      NORTH        */
        c1.getPosition().moveTo(new Position(18, 38));
        c0.getPosition().faceTo(Direction.WEST);
        c0.getPosition().faceTo(c1);
        assertEquals(Direction.NORTH, c0.getPosition().getFacing());
        c1.getPosition().moveTo(new Position(-10, 42));
        c0.getPosition().faceTo(Direction.WEST);
        c0.getPosition().faceTo(c1);
        assertEquals(Direction.NORTH, c0.getPosition().getFacing());

        /*      NORTHWEST        */
        c1.getPosition().moveTo(new Position(-11, 42));
        c0.getPosition().faceTo(Direction.WEST);
        c0.getPosition().faceTo(c1);
        assertEquals(Direction.NORTHWEST, c0.getPosition().getFacing());
        c1.getPosition().moveTo(new Position(-40, 24));
        c0.getPosition().faceTo(Direction.WEST);
        c0.getPosition().faceTo(c1);
        assertEquals(Direction.NORTHWEST, c0.getPosition().getFacing());

        /*      WEST        */
        c1.getPosition().moveTo(new Position(-41, 24));
        c0.getPosition().faceTo(Direction.EAST);
        c0.getPosition().faceTo(c1);
        assertEquals(Direction.WEST, c0.getPosition().getFacing());
        c1.getPosition().moveTo(new Position(-72, -26));
        c0.getPosition().faceTo(Direction.EAST);
        c0.getPosition().faceTo(c1);
        assertEquals(Direction.WEST, c0.getPosition().getFacing());

        /*      SOUTHWEST        */
        c1.getPosition().moveTo(new Position(-72, -27));
        c0.getPosition().faceTo(Direction.EAST);
        c0.getPosition().faceTo(c1);
        assertEquals(Direction.SOUTHWEST, c0.getPosition().getFacing());
        c1.getPosition().moveTo(new Position(-39, -101));
        c0.getPosition().faceTo(Direction.EAST);
        c0.getPosition().faceTo(c1);
        assertEquals(Direction.SOUTHWEST, c0.getPosition().getFacing());

        /*      SOUTH        */
        c1.getPosition().moveTo(new Position(-38, -101));
        c0.getPosition().faceTo(Direction.EAST);
        c0.getPosition().faceTo(c1);
        assertEquals(Direction.SOUTH, c0.getPosition().getFacing());
        c1.getPosition().moveTo(new Position(65, -140));
        c0.getPosition().faceTo(Direction.EAST);
        c0.getPosition().faceTo(c1);
        assertEquals(Direction.SOUTH, c0.getPosition().getFacing());

        /*      SOUTHEAST        */
        c1.getPosition().moveTo(new Position(66, -140));
        c0.getPosition().faceTo(Direction.EAST);
        c0.getPosition().faceTo(c1);
        assertEquals(Direction.SOUTHEAST, c0.getPosition().getFacing());
        c1.getPosition().moveTo(new Position(186, -70));
        c0.getPosition().faceTo(Direction.EAST);
        c0.getPosition().faceTo(c1);
        assertEquals(Direction.SOUTHEAST, c0.getPosition().getFacing());
    }

    public void testFaceToDir(){
        Random rnd = new Random();
        Character c = new Character(new Position(0,0, Direction.EAST));

        int count = 100;

        for (int i = 0; i < count; i++){
            Direction dir = Direction.valueOf(rnd.nextInt(8));
            c.getPosition().faceTo(dir);
            assertEquals(dir, c.getPosition().getFacing());
        }
    }
}