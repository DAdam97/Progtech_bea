package com.company;

import com.company.Equipment.Equipment;

import java.util.Random;

public class Stat {
    private int health;
    private int defense;
    private int strength;
    private int dexterity;
    private int wisdom;

    public int getHealth() {
        return health;
    }
    public int getDefense() {
        return defense;
    }
    public int getStrength() { return strength; }
    public int getDexterity() { return dexterity; }
    public int getWisdom() { return wisdom; }

    private void setHealth(int health) {
        if(health > 0)
            this.health = health;
    }
    private void setDefense(int defense) { this.defense = defense; }
    private void setStrength(int strength) { this.strength = strength; }
    private void setDexterity(int dexterity) { this.dexterity = dexterity; }
    private void setWisdom(int wisdom) { this.wisdom = wisdom; }

    public static Stat generateRandomStat(int level){
        int[] rndStat = new int[6];
        Random rnd = new Random();

        if (1 > level) { level = 1; }

        for (int i = 0; i < 5; i++)
            rndStat[i] = rnd.nextInt(11) * level;

        return new Stat(rndStat[0], rndStat[1], rndStat[2],
                        rndStat[3], rndStat[4]);
    }

    public void addStat(Stat... stats){
        for(Stat s: stats) {
            this.health += s.getHealth();
            this.defense += s.getDefense();
            this.strength += s.getStrength();
            this.dexterity += s.getDexterity();
            this.wisdom += s.getWisdom();
        }
    }

    @Override
    public String toString() {
        return "{" +
                "health: " + health +
                ", defense: " + defense +
                ", strength: " + strength +
                ", dexterity: " + dexterity +
                ", wisdom: " + wisdom +
                '}';
    }

    public Stat(int health, int defense, int strength, int dexterity, int wisdom) {
        this.health = health;
        this.defense = defense;
        this.strength = strength;
        this.dexterity = dexterity;
        this.wisdom = wisdom;
    }

    public Stat(Stat stat){
        this.health = stat.getHealth();
        this.defense = stat.getDefense();
        this.strength = stat.getStrength();
        this.dexterity = stat.getDexterity();
        this.wisdom = stat.getWisdom();
    }
}
