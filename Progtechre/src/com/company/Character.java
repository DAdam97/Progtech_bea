package com.company;


import com.company.Item.Equipment.*;
import com.company.Item.Weapon.BareHand;
import com.company.Item.Weapon.Weapon;

public class Character implements IMoveable {
    private Helmet helmet;
    private Chest chest;
    private Gloves gloves;
    private Pants pants;
    private Boots boots;

    private Weapon weapon;

    private Stat stat;
    private Position position;

    private boolean isAlive;

    public Stat getStat() { return stat; }

    @Override
    public Position getPosition() { return this.position; }

    public void damage(int applyDamage){
        stat.decreaseHealth(applyDamage);

        if (0 > stat.getHealth()) {
            stat.increaseHealth(stat.getHealth());
            isAlive = false;
        }
    }

    public boolean attack(Character enemy){
        System.out.println("W:" + weapon.getWeaponRange() + "  D: " + position.getDistance(enemy) );

        if (weapon.getWeaponRange() >= position.getDistance(enemy)){
                weapon.attack(enemy);
                return true;
        }
        return false;
    }

    public void equipWeapon(Weapon weapon){
        this.weapon = weapon;
        weapon.setWeaponStat( this.stat );
    }


    public Character() {
        this.weapon = new BareHand();
        this.isAlive = true;
        this.position = new Position(0,0);
        this.stat = new Stat(100,1,
                0,0,0);
    }

    public Character(Position position){
        this();
        this.position = position;
    }

    public Character(Position position, Helmet helmet, Chest chest, Gloves gloves, Pants pants, Boots boots) {
        this(position);

        this.helmet = helmet;
        this.chest = chest;
        this.gloves = gloves;
        this.pants = pants;
        this.boots = boots;

        this.stat.addStat(helmet.getStat(), chest.getStat(), gloves.getStat(),
                            pants.getStat(), boots.getStat());
    }
}
