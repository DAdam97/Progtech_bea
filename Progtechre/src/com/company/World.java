package com.company;

import com.company.Item.Equipment.Equipment;
import com.company.Item.Equipment.EquipmentFactory;
import com.company.Item.Equipment.EquipmentType;
import com.company.Item.Equipment.Modifiers.ModiferFactory;
import com.company.Item.Equipment.Modifiers.ModifierType;
import com.company.Item.Weapon.Bow;
import com.company.Item.Weapon.Enchantment.DoubleRangeEnchantment;
import com.company.Item.Weapon.Enchantment.NeutralEnchantment;
import com.company.Item.Weapon.Enchantment.TrueDamageEnchantment;
import com.company.Item.Weapon.MagicStaff;
import com.company.Item.Weapon.Sword;
import com.company.Item.Weapon.Weapon;

import java.util.Scanner;

public class World {

    private Weapon[] starterWeapons = {new Sword(1, new NeutralEnchantment()),
                                new MagicStaff(1, new TrueDamageEnchantment()),
                                new Bow(1, new DoubleRangeEnchantment())};

    private Scanner scanner = new Scanner(System.in);
    private EquipmentFactory ef = new EquipmentFactory();
    private ModiferFactory mf = new ModiferFactory();

    public void Start() throws InterruptedException {
        Character mainCharacter = new Character();
        int option;

        System.out.println("Choose your starter weapon! \n");

        displayStarterWeapons();

        option = chooseFromOptions(1, starterWeapons.length);

        mainCharacter.equipWeapon(starterWeapons[option - 1]);

        System.out.println("Your character is now wielding a " + mainCharacter.getWeapon().getWeaponType() + "\n");

        Character enemy1 = new Character(new Position(-8, 0));
        Equipment[] enemyEquipment = ef.generateFullEquipment(2);
        enemy1.equipAll(enemyEquipment);

        System.out.println("A bandit appeared behind you.");
        System.out.println("Press enter to start the fight!");
        scanner.nextLine();
        scanner.nextLine();


        while (enemy1.isAlive()){
            System.out.println("your health:" + mainCharacter.getStat().getHealth());
            System.out.println("enemy health:" + enemy1.getStat().getHealth());

            mainCharacter.attack(enemy1);
            enemy1.attack(mainCharacter);

            Thread.sleep(1000);
        }

        System.out.println("Congratulation you killed the bandit before he could reach you.");
        Thread.sleep(2000);

        System.out.println("Move closer to the body.\n\n");

        do{
            System.out.println("Your position: (" + mainCharacter.getPosition().getX() + ", " + mainCharacter.getPosition().getY() + ")");
            System.out.println("Enemy position: (" + enemy1.getPosition().getX() + ", " + enemy1.getPosition().getY() + ")");
            System.out.println();

            System.out.println("Choose a direction! \n");

            displayDirections();

            option = chooseFromOptions(1,Direction.values().length);

            Direction dir = Direction.valueOf(option - 1);

            System.out.println("Steps: ");
            int steps = scanner.nextInt();

            mainCharacter.moveForwardInDirection(dir, steps);

            Thread.sleep(500);

        }while (3 < mainCharacter.getPosition().getDistance(enemy1));

        System.out.println("Do you want to steal his clothes? ");
        System.out.println("1) yes   2) no");


        option = chooseFromOptions(1, 2);

        switch (option){
            case 1: mainCharacter.equipAll(enemyEquipment);
                break;

            case 2:
                break;
        }

        for (int i = 0; i < enemyEquipment.length; i++){
            System.out.println("You stole his " + enemyEquipment[i].toString() );
        }

        System.out.println("Upgrade your equipment!");
        for (int i = 0; i < EquipmentType.values().length; i++){
            System.out.println(i+1 + ") " + EquipmentType.valueOf(i).toString());
        }

        option = chooseFromOptions(1, EquipmentType.values().length);

        Equipment e = mainCharacter.getEquipment(option - 1);

        System.out.println("Choose an upgrade.\n");
        for (int i = 0; i < ModifierType.values().length; i++){
            System.out.println(i+1 + ") " + ModifierType.valueOf(i).toString());
        }

        option = chooseFromOptions(1, ModifierType.values().length);

        e = mf.addModifier(e, ModifierType.valueOf(option-1), 100);
        mainCharacter.equip(e);

        System.out.println(mainCharacter.displayEquipment());

        scanner.close();
    }

    private int chooseFromOptions(int min, int max){

        int chosen;
        boolean isChosen;

        do{
            chosen = scanner.nextInt();
            isChosen = true;

            if (chosen > max || min > chosen) {
                System.out.println("You pressed the wrong button!");
                isChosen = false;
            }
        }while (!isChosen);

        return chosen;
    }

    private void displayStarterWeapons(){
        for(int i = 0; i < starterWeapons.length; i++){
            System.out.println(i+1 + ") " + starterWeapons[i].getWeaponType() + " (damage:" + starterWeapons[i].getWeaponDamage() + ", range:" + starterWeapons[i].getWeaponRange() +
                    ", crit Chance:" + starterWeapons[i].getCriticalChance() + "%, enchantment:" + starterWeapons[i].getEnchantment() + ", level:"+starterWeapons[i].getWeaponLevel()+")");
        }
    }

    private void displayDirections(){
        for(int i = 0; i < Direction.values().length; i++){
            System.out.println(i+1 + ") " + Direction.valueOf(i).toString());
        }
    }
}
