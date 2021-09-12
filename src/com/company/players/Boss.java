package com.company.players;

public class Boss extends GameEntity {
    private boolean stunning;

    public Boss(int health, int damage) {
        super(health, damage);
    }


    public boolean isStun() {
        return stunning;
    }

    public void setStun(boolean stunning) {
        this.stunning = stunning;
    }
}
