package com.company.Item.Weapon;

import com.company.Item.Weapon.Enchantment.Enchantment;

public class MagicStaff extends Weapon {
    @Override
    public int getItemValue() {
        int baseValue = 100;
        return  baseValue * getWeaponLevel();
    }

    @Override
    public int getDamageModifierFromStat() {
        return getWeaponStat().getWisdom();
    }

    public MagicStaff(int level, Enchantment enchantment) {
        super(Weapon.getRandomDamage(17, 22)+ (int)(0.65f * level),
                60, 0.15f, 1.1f, level, enchantment);
    }
}
