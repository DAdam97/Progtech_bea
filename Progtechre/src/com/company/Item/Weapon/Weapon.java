package com.company.Item.Weapon;

import java.util.Random;

public abstract class Weapon {
    private static Random rnd = new Random();

    private int weaponDamage;
    private int WeaponRange;
    private float criticalChance;

    public static int getRandomDamage(int min, int max){
        if (min >= max) {
            int temp = max;
            max = min;
            min = temp;
        }

        return rnd.nextInt((max - min) + 1) + min;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }
    public int getWeaponRange() {
        return WeaponRange;
    }
    public float getCriticalChance() {
        return criticalChance;
    }

    public Weapon(int weaponDamage, int weaponRange, float criticalChance) {
        this.weaponDamage = weaponDamage;
        WeaponRange = weaponRange;
        this.criticalChance = criticalChance;
    }
}