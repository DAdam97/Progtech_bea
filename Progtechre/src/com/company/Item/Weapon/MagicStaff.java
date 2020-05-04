package com.company.Item.Weapon;

public class MagicStaff extends Weapon {

    public MagicStaff(int level) {
        super((int)(Weapon.getRandomDamage(17, 22) * 0.125 * level), 60, 0.15f);
    }
}
