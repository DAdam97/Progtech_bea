package com.company.Item.Weapon;

import com.company.Character;

public class Sword extends Weapon {

    @Override
    public int getDamageModifier() {
        return getWeaponStat().getStrength();
    }

    public Sword(int level) {
        super(Weapon.getRandomDamage(20, 25) + (int)(0.75f * level),
                10, 0.15f, 1.1f, level);
    }
}
