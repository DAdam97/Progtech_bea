package com.company;

import com.company.Equipment.*;

public class Character {
    private Helmet helmet;
    private Chest chest;
    private Gloves gloves;
    private Pants pants;
    private Boots boots;

    private Stat stat;

    @Override
    public String toString() {
        return this.stat.toString();
    }

    public Character(Helmet helmet, Chest chest, Gloves gloves, Pants pants, Boots boots) {
        this.stat = new Stat(100,0,
                0,0,0);
        this.helmet = helmet;
        this.chest = chest;
        this.gloves = gloves;
        this.pants = pants;
        this.boots = boots;

        this.stat.addStat(helmet.getStat(), chest.getStat(), gloves.getStat(),
                            pants.getStat(), boots.getStat());
    }
}
