package com.company.Item.Weapon;

public class Bow extends Weapon {

    @Override
    public int getDamageModifier() {
        return getWeaponStat().getDexterity();
    }

    public Bow(int level) {
        super(Weapon.getRandomDamage(15, 20) + (int)(0.60f * level),
                120, 0.15f,1.1f, level);
    }
}
