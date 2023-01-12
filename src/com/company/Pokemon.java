package com.company;

import java.util.Random;
import java.util.Scanner;

public abstract class Pokemon {
    final Random random = new Random();
    final Scanner scanner = new Scanner(System.in);
    private int maxHp;
    private int currentHp;
    private int maxAttackPts;
    private int currentAttackPts;
    private String name;
    private static int currentLevel;
    private int maxLevel;
    private Attack[] attacks;

    public int hpIncrement(int turn) {

        do {
            this.currentHp += random.nextInt(Constants.HP_INCREMENT_PER_TURN);
        } while (currentHp < maxHp);
        return currentHp;
    }

    public int attackPtsIncrement() {
        do {
            this.currentAttackPts += random.nextInt(Constants.ATTACK_PTS_INCREMENT_PER_TURN);
        } while (currentAttackPts < maxAttackPts);
        return currentAttackPts;
    }

    protected abstract int uniqueFeature(int numbers);

    public void addsHp() {
        int hpToAdd = random.nextInt(Constants.MIN_HP_TO_ADD, Constants.MAX_HP_TO_ADD);
        if (this.currentHp + hpToAdd > this.maxHp) {
            this.currentHp = this.maxHp;
        } else {
            this.currentHp += hpToAdd;
        }

    }

    public void addsAttackPts() {
        int attackPtsToAdd = random.nextInt(Constants.MIN_ATTACK_POINTS_TO_ADD, Constants.MAX_ATTACK_POINTS_TO_ADD);
        if (this.currentAttackPts + attackPtsToAdd > this.maxAttackPts) {
            this.currentAttackPts = this.maxAttackPts;
        } else {
            this.currentAttackPts += attackPtsToAdd;
        }


    }


    public boolean evolve() {
        boolean isEvolvedSuccessfully = false;
        if (this.currentLevel < this.maxLevel) {
            switch (this.currentLevel) {
                case 1 -> {
                    if (this.currentHp - Constants.HP_PTS_TO_EVOLVE_1 > 0) {
                        if (this.currentAttackPts - Constants.ATTACK_PTS_TO_EVOLVE_1 > 0) {
                            this.currentLevel++;
                            this.currentHp -= Constants.HP_PTS_TO_EVOLVE_1;
                            this.currentAttackPts -= Constants.ATTACK_PTS_TO_EVOLVE_1;
                            isEvolvedSuccessfully = true;
                        } else
                            System.out.println("Unable to evolve, not enough attack points (" + Constants.ATTACK_PTS_TO_EVOLVE_1 + ")");
                    } else System.out.println("Unable to evolve, not enough HP (" + Constants.HP_PTS_TO_EVOLVE_1 + ")");
                }
                case 2 -> {
                    if (this.currentHp - Constants.HP_PTS_TO_EVOLVE_2 > 0) {
                        if (this.currentAttackPts - Constants.ATTACK_PTS_TO_EVOLVE_2 > 0) {
                            this.currentLevel++;
                            this.currentHp -= Constants.HP_PTS_TO_EVOLVE_2;
                            this.currentAttackPts -= Constants.ATTACK_PTS_TO_EVOLVE_2;
                            isEvolvedSuccessfully = true;
                        } else
                            System.out.println("Unable to evolve, not enough attack points (" + Constants.ATTACK_PTS_TO_EVOLVE_2 + ")");
                    } else System.out.println("Unable to evolve, not enough HP (" + Constants.HP_PTS_TO_EVOLVE_2 + ")");
                }
            }
        } else System.out.println("Unable to evolve, you are at your max level");
        return isEvolvedSuccessfully;
    }

    public Random getRandom() {
        return random;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public Pokemon(int maxHp, int currentHp, int maxAttackPts, int currentAttackPts, String name,  int currentLevel, int maxLevel, Attack[] attacks) {
        this.maxHp = maxHp;
        this.currentHp = currentHp;
        this.maxAttackPts = maxAttackPts;
        this.currentAttackPts = currentAttackPts;
        this.name = name;
        this.currentLevel = currentLevel;
        this.maxLevel = maxLevel;
        this.attacks = attacks;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public int getMaxAttackPts() {
        return maxAttackPts;
    }

    public void setMaxAttackPts(int maxAttackPts) {
        this.maxAttackPts = maxAttackPts;
    }

    public int getCurrentAttackPts() {
        return currentAttackPts;
    }

    public void setCurrentAttackPts(int currentAttackPts) {
        this.currentAttackPts = currentAttackPts;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return

                "Name :" + name + " | " +
                        "Current Hp :" + currentHp + " | " +
                        "Current Attack Points :" + currentAttackPts + " | " +
                        "Current Level :" + currentLevel;


    }


    public void setName(String name) {
        this.name = name;
    }

    public static int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }
}

