package com.company;

import java.util.Random;

public class Attack {
    private int cost;
    private int minDamage;
    private int maxDamage;

    public Attack(int cost, int minDamage, int maxDamage) {
        this.cost = cost;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public int getCost(){
        return this.cost;
    }

    public int getDamage(){
        Random random = new Random();
        return random.nextInt(this.maxDamage - this.minDamage) + this.minDamage + 1;
    }
}
