package com.company.Item.Equipment;
import com.company.Item.Item;
import com.company.Stat;

public abstract class Equipment extends Item {
    private Stat stat;
    private EquipmentType type;

    public abstract EquipmentType getType();
    public Stat getStat(){
        return stat;
    }

    @Override
    public String toString() {
        return stat.toString();
    }

    public Equipment(Stat stat) {
        this.stat = stat;
    }
}
