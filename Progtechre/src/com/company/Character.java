package com.company;


import com.company.Item.Equipment.*;
import com.company.Item.Weapon.BareHand;
import com.company.Item.Weapon.Weapon;

public class Character implements IMoveable {
    // region variables
    private Equipment helmet;
    private Equipment chest;
    private Equipment gloves;
    private Equipment pants;
    private Equipment boots;

    private Weapon weapon;
    private Stat stat;
    private Position position;
    private boolean isAlive;
    //endregion

    // region getters
    public Equipment getHelmet() { return helmet; }
    public Equipment getChest() { return chest; }
    public Equipment getGloves() { return gloves; }
    public Equipment getPants() { return pants; }
    public Equipment getBoots() { return boots; }

    public Weapon getWeapon() { return weapon; }
    public Stat getStat() { return stat; }

    @Override
    public Position getPosition() { return position; }
    public boolean isAlive() { return isAlive; }
    //endregion

    // region functions
    public void equip(Equipment equipment){
        switch (equipment.getType()) {
            case Helmet:
                stat.removeStat(this.helmet.getStat());
                helmet = equipment;
                break;
            case Chest:
                stat.removeStat(this.chest.getStat());
                chest = equipment;
                break;
            case Gloves:
                stat.removeStat(this.gloves.getStat());
                gloves = equipment;
            break;
            case Pants:
                stat.removeStat(this.pants.getStat());
                pants = equipment;
            break;
            case Boots:
                stat.removeStat(this.boots.getStat());
                boots = equipment;
                break;
        }

        stat.addStat(equipment.getStat());
    }

    public void equipAll(Equipment... equipments){
        for (Equipment e : equipments){
            equip(e);
        }
    }

    public Equipment getEquipment(int slot){
        Equipment e = this.boots;
        switch (slot){
            case 0: e = this.helmet;
                break;
            case 1: e = this.chest;
                break;
            case 2: e = this.gloves;
                break;
            case 3: e = this.pants;
                break;
        }

        return e;
    }

    public void equipWeapon(Weapon weapon){
        this.weapon = weapon;
        weapon.setWeaponStat( this.stat );
    }

    public void damage(int applyDamage){
        stat.decreaseHealth(applyDamage);

        if (0 > stat.getHealth()) {
            stat.increaseHealth(-1 * stat.getHealth());
            isAlive = false;
        }
    }

    public boolean attack(Character enemy){
        if (weapon.getWeaponRange() >= position.getDistance(enemy)){
                weapon.attack(enemy);
                return true;
        }
        return false;
    }

    public void moveForward(int steps){
        getPosition().moveForward(steps);
    }

    public void moveForwardInDirection(Direction dir, int steps){
        getPosition().moveForwardInDirection(dir, steps);
    }

    public void faceToDirection(Direction dir){
        getPosition().faceTo(dir);
    }

    public void faceToCharacter(Character character){
        getPosition().faceTo(character);
    }

    public String displayEquipment(){
        return "Weapon: " + this.getWeapon().getWeaponType() + "\n" +
                this.getHelmet().toString() + "\n" +
                this.getChest().toString() + "\n" +
                this.getGloves().toString() + "\n" +
                this.getPants().toString() + "\n" +
                this.getBoots().toString();
    }

    //endregion

    //region constructors
    public Character() {
        this.helmet = new Helmet(new Stat());
        this.chest = new Chest(new Stat());
        this.gloves = new Gloves(new Stat());
        this.pants = new Pants(new Stat());
        this.boots = new Boots(new Stat());
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
    //endregion
}
