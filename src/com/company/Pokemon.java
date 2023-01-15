package com.company;

import java.util.Random;

public abstract class Pokemon {
    private String name;
    private int currentLife;
    private int maxLife;
    private int currentAttackPoints;
    private int maxAttackPoints;
    private int level;
    private boolean criticalDamage;
    private int turnCounter;
    private int criticalAttackTurn;
    private int type;
    private Attack[] attacks;

    public Attack[] getAttacks() {
        return attacks;
    }

    public Pokemon(String name,  int maxLife, int maxAttackPoints, int level, Attack[] attacks) {
        this.name = name;
        this.maxLife = maxLife;
        this.maxAttackPoints = maxAttackPoints;
        this.level = level;
        this.criticalDamage = false;
        this.criticalAttackTurn = 0;
        this.turnCounter = 0;
    }

    public Pokemon(Pokemon other) {

    }

    public abstract void attack(Pokemon enemy);

    public boolean hasEnoughAttackPoints(Attack attack) {
        boolean enough = false;
        if (this.currentAttackPoints >= attack.getCost()) {
            enough = true;

        }
        return enough;
    }

    public void reduceAttackPoints(int amount) {
        this.currentAttackPoints -= amount;
    }

    public boolean isCriticalDamage() {
        return criticalDamage;
    }


    public void reduceLife(int amount) {
        this.currentLife -= amount;
    }

    public void setCriticalDamage(boolean criticalDamage) {
        this.criticalDamage = criticalDamage;
    }


    public int getLevel() {
        return level;
    }

    public void addLife() {
        Random random = new Random();
        int randomLifeAdd = random.nextInt(Constants.MAX_LIFE_ADD - Constants.MIN_LIFE_ADD) + Constants.MIN_LIFE_ADD;
        if (this.currentLife + randomLifeAdd > this.maxLife)
            this.currentLife = this.maxLife;
        else this.currentLife += randomLifeAdd;
    }

    public void addAttackPoints() {
        Random random = new Random();
        int randomAttackAdd = random.nextInt(40);
        if (this.currentAttackPoints + randomAttackAdd > this.maxAttackPoints)
            this.currentAttackPoints = this.maxAttackPoints;
        else this.currentAttackPoints += randomAttackAdd;
    }

    public boolean isAlive() {
        boolean alive = true;
        if (this.currentLife <= 0) {
            alive = false;
        }
        return alive;
    }

    public void setTurnCounter(int turnCounter) {
        this.turnCounter = turnCounter;
    }

    public int getTurnCounter() {
        return turnCounter;
    }

    public int getCriticalAttackTurn() {
        return criticalAttackTurn;
    }

    public void skipTurn() {
        Random random = new Random();
        int choice = random.nextInt(Constants.SKIP_TURN_BOUND) + 1;
        turnCounter++;
        switch (choice) {
            case 1 -> this.addLife();
            case 2 -> this.addAttackPoints();
            case 3 -> {
                this.criticalDamage = true;
                this.criticalAttackTurn = this.turnCounter;
            }


        }
    }

    public void performAttack(Pokemon enemy, Attack attack) {
        if (hasEnoughAttackPoints(attack)) {
            reduceAttackPoints(attack.getCost());
            int damage = attack.getDamage();
            if (this.isCriticalDamage() && (this.getTurnCounter() - this.getCriticalAttackTurn() == 1)) {
                damage = damage * Constants.CRITICAL_DAMAGE;
                enemy.reduceLife(damage);
            } else {
                enemy.reduceLife(damage);
            }
            System.out.println("Current pokemon " + this);
            System.out.println("Enemy pokemon " + enemy);
        } else {
            System.out.println("You dont have enough attack points");
        }
    }

    public String toString() {
        return "Life (" + this.currentLife + " / " + this.maxLife + " )" +
                " , Attack Points: (" + this.currentAttackPoints + " / " + this.maxAttackPoints + ")";
    }

    public abstract void uniqueAbility();

    public int getCurrentLife() {
        return currentLife;
    }

    public void setCurrentLife(int currentLife) {
        this.currentLife = currentLife;
    }

    public boolean isValidAttack(int attack) {
        boolean valid = attack == Constants.LEVEL_ONE;
        if ((attack == Constants.LEVEL_TWO) && (this.getLevel() >= Constants.LEVEL_TWO)) valid = true;
        if ((attack == Constants.LEVEL_THREE) && (this.getLevel() == Constants.LEVEL_THREE)) valid = true;
        return valid;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }
}
