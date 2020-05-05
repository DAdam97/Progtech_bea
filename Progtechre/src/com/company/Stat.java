package com.company;

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

   public void decreaseHealth(int amount) { this.health -= amount; }
   public void increaseHealth(int amount) { this.health += amount; }

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

    public void removeStat(Stat... stats){
        for(Stat s: stats) {
            this.health -= s.getHealth();
            this.defense -= s.getDefense();
            this.strength -= s.getStrength();
            this.dexterity -= s.getDexterity();
            this.wisdom -= s.getWisdom();
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
    public Stat(){
        this.health = 0;
        this.defense = 0;
        this.strength = 0;
        this.dexterity = 0;
        this.wisdom = 0;
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
