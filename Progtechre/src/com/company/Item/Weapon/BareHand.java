package com.company.Item.Weapon;

public class BareHand extends Weapon {
    @Override
    public int getItemValue() { return 0; }

    @Override
    public int getDamageModifier() {
        return 0;
    }

    public BareHand() {
        super(10, 2,0,0, 1);
    }
}
