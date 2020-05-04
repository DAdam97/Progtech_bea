package com.company.Item.Weapon;

import com.company.Character;
import com.company.Stat;

import java.util.Random;

public abstract class Weapon {
    public static Random rnd = new Random();

    private int weaponLevel;
    private int weaponDamage;
    private int WeaponRange;
    private float criticalChance;
    private float criticalDamage;
    private Stat weaponStat = new Stat();

    public int getWeaponLevel() { return weaponLevel; }
    public int getWeaponDamage() { return weaponDamage; }
    public int getWeaponRange() { return WeaponRange; }
    public float getCriticalChance() { return criticalChance; }
    public float getCriticalDamage() { return criticalDamage; }
    public Stat getWeaponStat() { return weaponStat; }
    public float getDamageScalar() { return 0.15f; }


    public void attack(Character enemy){
        int damage = (int) (this.getWeaponDamage() + (int)(getDamageModifier() * getDamageScalar())
                                                    /
                                    enemy.getStat().getDefense());

        if(Weapon.rnd.nextFloat() < this.getCriticalChance()){
            damage += getWeaponDamage() * getCriticalDamage();
        }

        enemy.damage(damage);
    }

    public abstract int getDamageModifier();

    public void setWeaponStat(Stat characterStat) {
        this.weaponStat = characterStat;
    }

    public static int getRandomDamage(int min, int max){
        if (min >= max) {
            int temp = max;
            max = min;
            min = temp;
        }

        return rnd.nextInt((max - min) + 1) + min;
    }

    public Weapon(int weaponDamage, int weaponRange, float criticalChance,float criticalDamage, int weaponLevel) {
        this.weaponDamage = weaponDamage;
        this.WeaponRange = weaponRange;
        this.criticalChance = criticalChance;
        this.criticalDamage = criticalDamage;

        if(1 > weaponLevel) { weaponLevel = 1; }
        this.weaponLevel = weaponLevel;
    }
}