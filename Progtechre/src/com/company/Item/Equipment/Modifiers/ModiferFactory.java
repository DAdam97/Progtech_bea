package com.company.Item.Equipment.Modifiers;

import com.company.Item.Equipment.Equipment;

public class ModiferFactory {
    public Equipment addModifier(Equipment e, ModifierType type, int level){
        Equipment modifiedEquipment = e;

        switch (type) {
            case IncreaseHealth: modifiedEquipment = new IncreaseHealth(e, level);
                break;
            case IncreaseDefense: modifiedEquipment = new IncreaseDefense(e, level);
                break;
            case IncreaseStrength: modifiedEquipment = new IncreaseStrength(e, level);
                break;
            case IncreaseDexterity: modifiedEquipment = new IncreaseDexterity(e, level);
                break;
            case IncreaseWisdom: modifiedEquipment = new IncreaseWisdom(e, level);
                break;
        }

        return e;
    }
}
