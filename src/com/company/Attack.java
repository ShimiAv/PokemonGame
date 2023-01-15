package com.company;

import java.util.Random;

public class Attack {
    private String name;
    private int cost;
    private int minDamage;
    private int maxDamage;
    private int bonusDamage;

    public Attack(String name, int cost, int minDamage, int maxDamage) {
        this.name = name;
        this.cost = cost;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public int getCost() {
        return this.cost;
    }

    public void setBonusDamage(int bonusDamage) {
        this.bonusDamage = bonusDamage;
    }

    public int getDamage() {
        Random random = new Random();
        return random.nextInt(this.maxDamage - this.minDamage) + this.minDamage + 1;
    }
}
