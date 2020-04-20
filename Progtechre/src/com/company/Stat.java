package com.company;

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

    public void addStat(Stat stat){
        this.health += stat.getHealth();
        this.mana += stat.getMana();
        this.defense += stat.getDefense();
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
