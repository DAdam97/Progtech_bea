package com.company.Item.Weapon;

import com.company.Item.Weapon.Enchantment.NeutralEnchantment;

public class BareHand extends Weapon {
    @Override
    public int getItemValue() { return 0; }

    @Override
    public int getDamageModifierFromStat() {
        return 0;
    }

    public BareHand() {
        super(10, 2,0,
                0, 1, new NeutralEnchantment());
    }
}
