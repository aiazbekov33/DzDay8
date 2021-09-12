package com.company.players;

public class Magic extends Hero {

    private int damageUp;

    public Magic(int health, int damage, int damageUp) {
        super(health, damage, SuperAbility.BOOST);
        this.damageUp = damageUp;
    }

    public int getDamageUp() {
        return damageUp;
    }

    public void setDamageUp(int damageUp) {
        this.damageUp = damageUp;
    }


    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (!heroes[i].getAbility().equals(SuperAbility.BOOST)) {
            }
            boss.setHealth(boss.getHealth() - damageUp);
        }
    }
}
