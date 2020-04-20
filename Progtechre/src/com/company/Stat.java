package com.company;

import com.company.Equipment.Equipment;

public class Stat {
    private int health;
    private int mana;
    private int defense;

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public int getDefense() {
        return defense;
    }

    public void addStat(Equipment... equipments){
        for(Equipment e: equipments) {
            Stat s = e.getStat();
            this.health += s.getHealth();
            this.mana += s.getMana();
            this.defense += s.getDefense();
        }
    }

    @Override
    public String toString() {
        return "{" +
                "health: " + health +
                ", mana: " + mana +
                ", defense: " + defense +
                '}';
    }

    public Stat(int health, int mana, int defense) {
        this.health = health;
        this.mana = mana;
        this.defense = defense;
    }
}
