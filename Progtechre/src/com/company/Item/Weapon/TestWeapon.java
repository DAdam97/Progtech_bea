package com.company.Item.Weapon;

import com.company.Item.Weapon.Enchantment.Enchantment;

public class TestWeapon extends Weapon {
    public TestWeapon(int weaponDamage, int weaponRange, float criticalChance, float criticalDamage, int weaponLevel, Enchantment enchantment) {
        super(weaponDamage, weaponRange, criticalChance, criticalDamage, weaponLevel, enchantment);
    }

    @Override
    public int getDamageModifierFromStat() {
        return getWeaponStat().getStrength();
    }

    @Override
    public int getItemValue() {
        return 0;
    }
}
