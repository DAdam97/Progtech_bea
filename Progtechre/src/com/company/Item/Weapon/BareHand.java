package com.company.Item.Weapon;

public class BareHand extends Weapon {
    @Override
    public int getDamageModifier() {
        return 0;
    }

    public BareHand() {
        super(10, 2,0,0, 1);
    }
}
