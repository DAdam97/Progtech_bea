package com.company.Item.Weapon;

import com.company.Item.Weapon.Enchantment.Enchantment;

public class Bow extends Weapon {
    @Override
    public int getItemValue() {
        int baseValue = 45;
        return  baseValue * getWeaponLevel();
    }

    @Override
    public int getDamageModifierFromStat() {
        return getWeaponStat().getDexterity();
    }

    public Bow(int level, Enchantment enchantment) {
        super(Weapon.getRandomDamage(15, 20) + (int)(0.60f * level),
                120, 0.15f,1.1f, level, enchantment);
    }
}
