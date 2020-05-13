package com.company.Item.Equipment;

import com.company.Stat;

public class EquipmentFactory {
    public Equipment[] generateFullEquipment(int level){
        Equipment[] fullEquipment = new Equipment[5];

        fullEquipment[0] = new Helmet(Stat.generateRandomStat(level));
        fullEquipment[1] = new Chest(Stat.generateRandomStat(level));
        fullEquipment[2] = new Gloves(Stat.generateRandomStat(level));
        fullEquipment[3] = new Pants(Stat.generateRandomStat(level));
        fullEquipment[4] = new Boots(Stat.generateRandomStat(level));

        return fullEquipment;
    }

    public Equipment generateEquipment(EquipmentType type, int level){
        Equipment e = new Boots(new Stat(0,0,0,0,0));

        switch (type) {
            case Helmet: e = new Helmet(Stat.generateRandomStat(level));
                break;
            case Chest:  e = new Chest(Stat.generateRandomStat(level));
                break;
            case Gloves: e = new Gloves(Stat.generateRandomStat(level));
                break;
            case Pants: e = new Pants(Stat.generateRandomStat(level));
                break;
            case Boots: e = new Boots(Stat.generateRandomStat(level));
                break;
        }

        return e;
    }
}
