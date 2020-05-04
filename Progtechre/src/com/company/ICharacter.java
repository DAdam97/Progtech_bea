package com.company;

public interface ICharacter {
    boolean attack(ICharacter target);
    void moveTo(Position newPosition);
    boolean loot(ILootable lootable);
}
