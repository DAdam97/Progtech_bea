package com.company;

import com.company.Equipment.*;

public class Character {
   private Helmet helmet;
   private Chest chest;

    private Stat stat;

    @Override
    public String toString() {
        return this.stat.toString();
    }

    public Character(Helmet helmet, Chest chest) {
        this.stat = new Stat(100,0,0);
        this.helmet = helmet;
        this.chest = chest;

        this.stat.addStat(helmet, chest);
    }
}
