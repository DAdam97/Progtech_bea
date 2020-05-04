package com.company.Item.Weapon;

public class Sword extends Weapon {

    public Sword(int level) {
        super((int)(Weapon.getRandomDamage(20, 25) * 0.1 * level), 10, 0.15f);
    }
}
