package com.company.players;

import java.util.Random;

public class Warrior extends Hero{

    private int fatalDamage;


    public Warrior(int health, int damage, int fatalDamage) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE);
        this.fatalDamage = fatalDamage;
    }

    public int getFatalDamage(){return fatalDamage;}
    public void setFatalDamage(int fatalDamage){this.fatalDamage = fatalDamage;}

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        Random random = new Random();
        for (int i = 2; i < 4; i++) {

        }
        boss.setHealth(boss.getHealth() - (fatalDamage * random.nextInt(4)));
    }
}
