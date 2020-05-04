package com.company;


import com.company.Item.Equipment.*;

public class Character implements ICharacter, ILootable {
    private Helmet helmet;
    private Chest chest;
    private Gloves gloves;
    private Pants pants;
    private Boots boots;

    private Stat stat;

    private Position position;

    public Position getPosition() { return position; }

    @Override
    public boolean attack(ICharacter target) {
        return false;
    }

    @Override
    public void moveTo(Position newPosition) {

    }

    @Override
    public boolean loot(ILootable lootable) {
        return false;
    }

    @Override
    public boolean getLoot() {
        return false;
    }

    @Override
    public String toString() {
        return this.stat.toString();
    }

    public Character() {
        this.position = new Position(0,0);
        this.stat = new Stat(100,0,
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
