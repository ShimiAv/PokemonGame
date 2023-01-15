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

    public int getType() {
        return type;
    }

    public Attack[] getAttacks() {
        return attacks;
    }

    public Pokemon(String name, int maxLife, int maxAttackPoints, int level, Attack[] attack, int currentLife, int currentAttackPoints) {
        this.name = name;
        this.maxLife = maxLife;
        this.maxAttackPoints = maxAttackPoints;
        this.level = level;
        this.criticalDamage = false;
        this.criticalAttackTurn = 0;
        this.turnCounter = 0;
        this.currentLife = currentLife;
        this.currentAttackPoints = currentAttackPoints;
    }

    public String getName() {
        return name;
    }


    public boolean hasEnoughAttackPoints(Attack attack) {
        boolean enough = false;
        if (this.currentAttackPoints >= attack.getCost()) {
            enough = true;

        }
        return enough;
    }

    public void setCurrentAttackPoints(int currentAttackPoints) {
        this.currentAttackPoints = currentAttackPoints;
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
        if (this.currentLife + randomLifeAdd > this.maxLife) {
            this.currentLife = this.maxLife;
        } else this.setCurrentLife(this.currentLife + randomLifeAdd);
        System.out.println("BOUNUS : you got more " + randomLifeAdd + " HP");
    }

    public void addAttackPoints() {
        Random random = new Random();
        int randomAttackAdd = random.nextInt(40);
        if (this.currentAttackPoints + randomAttackAdd > this.maxAttackPoints) {
            this.currentAttackPoints = this.maxAttackPoints;
        } else this.setCurrentAttackPoints(currentAttackPoints + randomAttackAdd);
        System.out.println("BOUNUS : you got more " + randomAttackAdd + " AP");

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
        int choice = Constants.RANDOM.nextInt(Constants.SKIP_TURN_BOUND) + 1;
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

    public String toString() {
        return "Life (" + this.currentLife + " / " + this.maxLife + " )" +
                " , Attack Points: (" + this.currentAttackPoints + " / " + this.maxAttackPoints + ")";
    }

    public abstract void uniqueAbility();

    public int getCurrentLife() {
        return currentLife;
    }

    public void setCurrentLife(int currentLife) {
        this.currentLife = maxLife;
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


    public int getCurrentAttackPoints() {
        return currentAttackPoints;
    }

    private String printsAttacksArray() {
        String text = "";
        if (this.attacks != null) {
            for (int i = 0; i < attacks.length; i++) {
                int number = i + 1;
                text += "\n" + number + " | " + attacks[i].toString();
            }
        }
        return text;
    }


    public boolean performAttack(Pokemon other) {
        int userInput;
        do {
            userInput = chooseAttack();
        } while (!attackPointsChecker(userInput));
        this.currentAttackPoints -= this.attacks[userInput - 1].getCost();
        this.takeDamage(this.attacks[userInput - 1], other);
        return other.isAlive();
    }

    private boolean attackExistenceCheck(int userInput) {
        boolean isExist = false;
        if (this.attacks.length >= userInput && userInput > 0) {
            isExist = true;
        } else {
            System.out.println("The input is incorrect, please try again");
        }
        return isExist;
    }

    public int getMaxAttackPoints() {
        return maxAttackPoints;
    }

    private int chooseAttack() {
        int chance;
        do {
            System.out.println(this.printsAttacksArray());
            chance = Constants.SCANNER.nextInt();
            Constants.SCANNER.nextLine();
        } while (!attackExistenceCheck(chance));
        return chance;
    }

    private boolean attackPointsChecker(int userInput) {
        boolean result = false;
        if (this.currentAttackPoints >= this.attacks[userInput - 1].getCost()) {
            result = true;
        } else {
            System.out.println("You dont have enough attack points");
        }
        return result;
    }

    private void takeDamage(Attack attack, Pokemon other) {
        int damage = attack.damageRandomizer();
        removeBonus();
        other.setCurrentLife(other.getCurrentLife() - damage);
    }

    private void removeBonus() {
        for (int i = 0; i < this.attacks.length; i++) {
            this.attacks[i].setBonusDamage(0);
        }
    }

    public void specialAbilityPerform(Pokemon pokemon) {
        switch (this.type) {
            case Constants.ELECTRIC_TYPE -> {
                pokemon.setCurrentAttackPoints(maxAttackPoints);
                pokemon.setCurrentLife(maxLife);
            }

            case Constants.FIRE_TYPE -> {

            }
        }

    }

    public void kick(Pokemon enemy) {
        enemy.setCurrentAttackPoints(enemy.getCurrentAttackPoints() - Constants.KICK);
    }

    public Pokemon performEvolve() {
        Pokemon upgradedPokemon = null;
        int[] upgradedPokemonIndex;
        switch (this.level) {
            case Constants.LEVEL_ONE -> {
                if (getCurrentLife() > Constants.LIFE_REDUCTION_FIRST_EVOLVE && getCurrentAttackPoints() > Constants.ATTACK_REDUCTION_FIRST_EVOLVE) {
                    upgradedPokemonIndex = PokemonList.returnIndexOfPokemon(this);
                    upgradedPokemon = PokemonList.pokemonTable[upgradedPokemonIndex[upgradedPokemonIndex[0]]][Constants.LEVEL_ONE];
                } else {
                    System.out.println("You can't evolve now, HP/AP are too low");
                }
            }
            case Constants.LEVEL_TWO -> {
                if (getCurrentLife() > Constants.LIFE_REDUCTION_SECOND_EVOLVE && getCurrentAttackPoints() > Constants.ATTACK_REDUCTION_SECOND_EVOLVE) {
                    upgradedPokemonIndex = PokemonList.returnIndexOfPokemon(this);
                    upgradedPokemon = PokemonList.pokemonTable[upgradedPokemonIndex[upgradedPokemonIndex[0]]][Constants.LEVEL_TWO];
                } else {
                    System.out.println("You can't evolve now, HP/AP are too low");
                }
            }
        }


        return upgradedPokemon;
    }

    public void evolve() {
        performEvolve();
    }


}
