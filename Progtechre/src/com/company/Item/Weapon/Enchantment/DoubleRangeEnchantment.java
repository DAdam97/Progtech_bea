package com.company.Item.Weapon.Enchantment;

public class DoubleRangeEnchantment implements Enchantment {
    @Override
    public int getDmgEnchantment() { return 0; }

    @Override
    public float getRngEnchantment() { return 2f; }

    @Override
    public float getCritChanceEnchantment() { return 0f; }

    @Override
    public float getCritDamageEnchantment() { return 0f; }

    @Override
    public int getDefEnchantment() { return 1; }

    @Override
    public String gatEnchantment() {
        return "Double Weapon Range";
    }
}
