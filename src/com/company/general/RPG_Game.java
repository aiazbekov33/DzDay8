package com.company.general;

import com.company.players.*;

import java.util.Random;

public class RPG_Game {

    public static Random random = new Random();

    public static void start() {

        Boss boss = new Boss(400, 50);
        Warrior warrior = new Warrior(250, 10,0);
        Tank tank = new Tank(250, 10,30);
        Magic magic = new Magic(250, 10, 10);
        Medic medic = new Medic(250, 5, 15);
        Medic youngMedic = new Medic(300, 8, 5);
        Thor thor = new Thor(400, 15);
        Golem golem = new Golem(300,10);

        Hero[] heroes = {warrior, tank, magic, medic, youngMedic, thor,};

        printStatistic(boss, heroes);

        while (!isFinished(boss, heroes)){
            round(boss, heroes);
        }

    }

    private static void printStatistic(Boss boss, Hero[] heroes){
        System.out.println("________________________");

        System.out.println("Boss health: " + boss.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() + " health: " + heroes[i].getHealth());
        }
        System.out.println("________________________");
    }

    private static void round(Boss boss, Hero[] heroes){
        bossHit(boss, heroes);
        heroesHits(boss, heroes);
        heroesApplySuperAbility(boss, heroes);
        printStatistic(boss, heroes);
    }

    private static boolean isFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDied = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDied = false;
                break;
            }
        }
        if (allHeroesDied){
            System.out.println("Boss won!!!");
        }
        return allHeroesDied;
    }

    private static void bossHit(Boss boss, Hero[] heroes) {

        if (boss.getHealth() > 0) {
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0) {
                    if ((heroes[i].getHealth() - boss.getDamage()) < 0) {
                        heroes[i].setHealth(0);
                    } else {
                        heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
                    }
                }
            }
        }
    }

    private static void heroesHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                if (boss.getHealth() - heroes[i].getDamage() < 0) {
                    boss.setHealth(0);
                } else {
                    boss.setHealth(boss.getHealth() - heroes[i].getDamage());
                }
            }
        }
    }

    private static void heroesApplySuperAbility(Boss boss, Hero[] heroes){
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].applySuperAbility(boss, heroes);
        }
    }
}
