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
    private Attack[] attacks;


    public Attack[] getAttacks() {
        return attacks;
    }

    protected Pokemon(String name, int maxLife, int maxAttackPoints, int level, Attack[] attacks, int currentLife, int currentAttackPoints) {
        this.name = name;
        this.maxLife = maxLife;
        this.maxAttackPoints = maxAttackPoints;
        this.level = level;
        this.criticalDamage = false;
        this.criticalAttackTurn = 0;
        this.turnCounter = 0;
        this.currentLife = currentLife;
        this.currentAttackPoints = currentAttackPoints;
        this.attacks = AttackList.KICK;
        this.addAttacks(attacks);
        if (level == Constants.LEVEL_ONE) {
            this.statsCalculator();
        }
    } //O(1)

    public Pokemon() {
    } //O(1)

    protected void statsDuplication(Pokemon enemy) {
        enemy.name = this.name;
        enemy.criticalDamage = this.criticalDamage;
        enemy.currentAttackPoints = this.currentAttackPoints;
        enemy.level = this.level;
        enemy.maxAttackPoints = this.maxAttackPoints;
        enemy.maxLife = this.maxLife;
        enemy.attacks = this.attacks;
        enemy.currentLife = this.currentLife;


    } //O(n)

    public String getName() {
        return name;
    } //O(1)

    public abstract int specialPower();

    public abstract Pokemon duplicatePokemon();

    public void setCurrentAttackPoints(int currentAttackPoints) {
        this.currentAttackPoints = currentAttackPoints;
    } //O(1)

    private void statsCalculator() {
        this.currentAttackPoints = this.startingManaCalculator(this.maxAttackPoints);
        this.currentLife = this.maxLife;
        this.addAttacks(AttackList.KICK);


    } //O(n)

    public void addAttacks(Attack[] attacksList) {
        int length = 0;
        int index;
        if (this.attacks == null) {
            this.attacks = new Attack[0];
        } else {
            length = this.attacks.length;
        }
        if (attacksList == null) {
            attacksList = new Attack[0];
        }
        Attack[] temp = new Attack[attacksList.length + length];
        for (int i = 0; i < length; i++) {
            temp[i] = this.attacks[i];
        }
        index = length;
        int i = 0;
        do {
            temp[index] = attacksList[i];
            index++;
            i++;
        } while (i != attacksList.length);
        this.attacks = temp;
    } //O(n)

    private int startingManaCalculator(int maxAttackPoints) {
        int result = maxAttackPoints * Constants.STARTING_MANA_POINTS / Constants.PERCENT_REPRESENTATIVE;
        return result;
    } //O(n)

    public int getLevel() {
        return level;
    } //O(1)

    public void addLife() {
        Random random = new Random();
        int randomLifeAdd = random.nextInt(Constants.MAX_LIFE_ADD - Constants.MIN_LIFE_ADD) + Constants.MIN_LIFE_ADD;
        if (this.currentLife + randomLifeAdd > this.maxLife) {
            this.currentLife = this.maxLife;
        } else this.currentLife += randomLifeAdd;
        System.out.println("BONUS : you got more " + randomLifeAdd + " HP");
    } //O(n)

    public void addAttackPoints() {
        Random random = new Random();
        int randomAttackAdd = random.nextInt(Constants.RANDOM_MANA_TO_ADD);
        if (this.currentAttackPoints + randomAttackAdd > this.maxAttackPoints) {
            this.currentAttackPoints = this.maxAttackPoints;
        } else currentAttackPoints += randomAttackAdd;
        System.out.println("BONUS : you got more " + randomAttackAdd + " AP");

    } //O(n)

    public boolean isAlive() {
        boolean alive = true;
        if (this.currentLife == Constants.HP_TO_BE_DEAD) {
            alive = false;
        }
        return alive;
    } //O(n)

    public void skipTurn() {
        int choice = Constants.RANDOM.nextInt(Constants.SKIP_TURN_BOUND) + 1;
        turnCounter++;
        switch (choice) {
            case Constants.ADD_HP -> this.addLife();
            case Constants.ADD_AP -> this.addAttackPoints();
            case Constants.CRITICAL_DAMAGE -> {
                this.criticalDamage = true;
                this.criticalAttackTurn = this.turnCounter;
            }


        }
    } //O(n)

    public String toString() {
        return "Life (" + this.currentLife + " / " + this.maxLife + " )" +
                "Level " + this.level +
                " , Attack Points: (" + this.currentAttackPoints + " / " + this.maxAttackPoints + ")";
    } //O(1)

    public abstract void uniqueAbility();

    public int getCurrentLife() {
        return currentLife;
    } //O(1)

    public void setCurrentLife(int currentLife) {
        this.currentLife = currentLife;
    } //O(1)

    public int getMaxLife() {
        return maxLife;
    } //O(1)

    private String printsAttacksArray() {
        String text = "";
        if (this.attacks != null) {
            for (int i = 0; i < attacks.length; i++) {
                int number = i + 1;
                text += "\n" + number + " | " + attacks[i].toString();
            }
        }
        return text;
    } //O(n)

    private boolean attackExistenceCheck(int userInput) {
        boolean isExist = false;
        if (this.attacks.length >= userInput && userInput > 0) {
            isExist = true;
        } else {
            System.out.println("The input is incorrect, please try again");
        }
        return isExist;
    } //O(n)

    public void getPreviousStats(Pokemon oldPokemon) {
        this.currentLife = oldPokemon.currentLife;
        this.currentAttackPoints = oldPokemon.currentAttackPoints;
        this.addAttacks(oldPokemon.attacks);
        this.criticalDamage = oldPokemon.criticalDamage;


    } //O(n)

    public boolean attack(Pokemon enemy) {
        int userInput;
        do {
            userInput = chooseAttack();
        } while (!checkPoints(userInput));
        this.currentAttackPoints -= this.attacks[userInput - 1].getCost();
        int damage = this.damageCalculator(this.attacks[userInput - 1]);
        enemy.performAttack(damage);
        boolean result = enemy.isAlive();
        if (!result) {
            System.out.println(enemy.name + " is dead " + this.name + " is the winner!");
            System.out.println();

        }
        return result;
    } //O(n)

    public int getMaxAttackPoints() {
        return maxAttackPoints;
    } //O(1)

    private int chooseAttack() {
        int chance;
        do {
            System.out.println(this.printsAttacksArray());
            chance = Constants.SCANNER.nextInt();
            Constants.SCANNER.nextLine();
        } while (!attackExistenceCheck(chance));
        return chance;
    } //O(n)

    public boolean doubleDamage(Pokemon pokemon) {
        int index;
        int damage = 0;

        for (int i = 0; i < 2; i++) {
            index = Constants.RANDOM.nextInt(pokemon.getAttacks().length);
            damage += damageCalculator(pokemon.getAttacks()[index]);
        }
        this.performAttack(damage);

        return this.isAlive();
    } //O(n)

    private boolean checkPoints(int userInput) {
        boolean result = false;
        if (this.currentAttackPoints >= this.attacks[userInput - 1].getCost()) {
            result = true;
        } else {
            System.out.println("You dont have enough AP ");
        }
        return result;
    } //O(n)

    void performAttack(int damage) {

        this.setCurrentLife(this.getCurrentLife() - damage);
    } //O(n)

    protected int damageCalculator(Attack attack) {
        int damage = attack.damageRandomizer();
        if (this.criticalDamage) {
            damage *= Constants.CRITICAL_DAMAGE;
            this.criticalDamage = false;
        }
        return damage;
    } //O(n)

    public boolean isEvolvePossible(int minLife, int minMana) {
        boolean isPossible = false;
        if (this.currentLife > minLife && this.currentAttackPoints > minMana) {
            isPossible = true;
        } else {
            System.out.println("You cant evolve right now, HP/AP is too low. ");
        }
        return isPossible;
    } //O(n)

    public void addHpPerTurn() {
        int hpToAddConstants = Constants.RANDOM.nextInt(Constants.HP_TO_ADD_EACH_TURN);
        this.currentLife += hpToAddConstants;
    } //O(1)

    public void addApPerTurn() {
        int apToAddConstants = Constants.RANDOM.nextInt(Constants.AP_TO_ADD_EACH_TURN);
        this.currentAttackPoints += apToAddConstants;
    } //O(1)


}
