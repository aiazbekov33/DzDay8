package com.company.players;

public class Golem extends Hero{

    public Golem(int health, int damage) {
        super(health, damage, SuperAbility.BLOCKHIT);
    }



    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {

    }
}
