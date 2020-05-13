package com.company.Item.Weapon;

import com.company.Item.Weapon.Enchantment.NeutralEnchantment;

public class BareHand extends Weapon {
    @Override
    public int getItemValue() { return 0; }

    @Override
    public String getWeaponType() {
        return WeaponType.BareHand.toString();
    }

    @Override
    public int getDamageModifierFromStat() {
        return 10;
    }

    public BareHand() {
        super(10, 2,0,
                0, 1, new NeutralEnchantment());
    }
}
