package com.company.Item.Weapon;

import com.company.Character;
import com.company.Item.Item;
import com.company.Item.Weapon.Enchantment.Enchantment;
import com.company.Stat;

import java.util.Random;

public abstract class Weapon extends Item {
    public static Random rnd = new Random();

    private int weaponLevel;
    private int weaponDamage;
    private int WeaponRange;
    private float criticalChance;
    private float criticalDamage;
    private Stat weaponStat = new Stat();
    private Enchantment enchantment;

    public int getWeaponLevel() { return weaponLevel; }
    public int getWeaponDamage() { return weaponDamage + enchantment.getDmgEnchantment(); }
    public int getWeaponRange() { return (int)(WeaponRange * enchantment.getRngEnchantment()); }
    public float getCriticalChance() { return criticalChance + enchantment.getCritChanceEnchantment(); }
    public float getCriticalDamage() { return criticalDamage + enchantment.getCritDamageEnchantment(); }
    public Stat getWeaponStat() { return weaponStat; }
    public String getEnchantment(){ return enchantment.gatEnchantment(); }
    public abstract String getWeaponType();

    public float getDamageScalar() { return 0.15f; }

    public void attack(Character enemy){
        int damage = (this.getWeaponDamage() + (int)(getDamageModifierFromStat() * getDamageScalar())
                                                    /
                (enemy.getStat().getDefense() * enchantment.getDefEnchantment() + 1));

        if(Weapon.rnd.nextFloat() < this.getCriticalChance()){
            damage += getWeaponDamage() * getCriticalDamage();
        }

        enemy.damage(damage);
    }

    public abstract int getDamageModifierFromStat();

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

    @Override
    public String toString() {
        return "Weapon{" +
                "weaponLevel=" + weaponLevel +
                ", weaponDamage=" + weaponDamage +
                ", WeaponRange=" + WeaponRange +
                ", criticalChance=" + criticalChance +
                ", criticalDamage=" + criticalDamage +
                ", weaponStat=" + weaponStat +
                ", enchantment=" + enchantment +
                '}';
    }

    public Weapon(int weaponDamage, int weaponRange, float criticalChance, float criticalDamage, int weaponLevel, Enchantment enchantment) {
        this.weaponDamage = weaponDamage;
        this.WeaponRange = weaponRange;
        this.criticalChance = criticalChance;
        this.criticalDamage = criticalDamage;

        if(1 > weaponLevel) { weaponLevel = 1; }
        this.weaponLevel = weaponLevel;

        this.enchantment = enchantment;
    }
}