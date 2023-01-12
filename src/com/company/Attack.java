package com.company;

public class Attack {
    private String name;
    private int cost;
    private int damage;
    private boolean isAvailable;
    private int level;

    public Attack(String name, int cost, int damage, int level) {
        this.name = name;
        this.cost = cost;
        this.damage = damage;
        this.isAvailable = isAttackAvailable();
        this.level = level;
    }

    public static final Attack kick = new Attack("Kick",0,4,1);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAttackAvailable() {
        boolean isAvailable = false;
        if (this.level == Pokemon.getCurrentLevel()) {
            isAvailable = true;
        }

        return isAvailable;
    }

    public String toString() {
        return
                "Name :" + name + "\n" +
                        "Cost :" + cost + "\n" +
                        "Damage :" + damage + "\n" +
                        "Is Available :" + isAvailable;

    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
