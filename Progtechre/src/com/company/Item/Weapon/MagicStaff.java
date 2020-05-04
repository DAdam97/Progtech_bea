package com.company.Item.Weapon;

public class MagicStaff extends Weapon {

    @Override
    public int getDamageModifier() {
        return getWeaponStat().getWisdom();
    }

    public MagicStaff(int level) {
        super(Weapon.getRandomDamage(17, 22)+ (int)(0.65f * level),
                60, 0.15f, 1.1f, level);
    }
}
