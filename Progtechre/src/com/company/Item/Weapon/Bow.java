package com.company.Item.Weapon;

public class Bow extends Weapon {

    public Bow(int level) {
        super((int)(Weapon.getRandomDamage(15, 20) * 0.2 * level), 120, 0.15f);
    }
}
