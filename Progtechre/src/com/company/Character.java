package com.company;

import com.company.Equipment.*;

public class Character {
   private Helmet _helmet;

    private Stat stat;

    @Override
    public String toString() {
        return this.stat.toString();
    }

    public Character(Helmet helmet) {
        this.stat = new Stat(100,0,0);
        _helmet = helmet;
        this.stat.addStat(_helmet.getStat());
    }
}
