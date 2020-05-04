package com.company.Item.Equipment;
import com.company.Stat;

public abstract class Equipment{
    private Stat stat;

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
