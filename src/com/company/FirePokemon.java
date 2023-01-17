package com.company;

public class FirePokemon extends Pokemon {


    public void attack(Pokemon enemy) {

    }

    public void uniqueAbility() {
        int chance = Constants.RANDOM.nextInt(Constants.PERCENT_REPRESENTATIVE) + 1;
        if (chance == Constants.SELF_DAMAGE) {
            int selfDamageAmount = Constants.RANDOM.nextInt(Constants.MIN_SELF_DAMAGE, Constants.MAX_SELF_DAMAGE + 1);
            int result = this.getCurrentLife() - selfDamageAmount;
            this.setCurrentLife(result);
            System.out.println("you have lost " + selfDamageAmount + "HP");
        }
    }

    public Pokemon duplicatePokemon() {
        ElectricPokemon newPokemon = new ElectricPokemon();
        this.statsDuplication(newPokemon);
        return newPokemon;
    }

    public boolean isKilled(Pokemon enemy) {
        boolean result = super.tryToKill(enemy);
        uniqueAbility();
        if (!result&&this.getCurrentLife()<0){
            System.out.println("You killed yourself");
            result =true;
        }
        return result;
    }

    public int specialPower() {
        int result = Constants.SPECIAL_POWER_FAILURE;
        if (this.getCurrentLife()/Constants.HALF_REPRESENTATIVE >0) {
            this.setCurrentLife(this.getCurrentLife() / Constants.HALF_REPRESENTATIVE);
            this.setCurrentAttackPoints(0);
            result = Constants.DOUBLE_DAMAGE;
        }
        return result;
    }



    public FirePokemon(String name, int maxLife, int maxAttackPoints, int level, Attack[] attacks, int currentLife, int currentAttackPoints) {
        super(name, maxLife, maxAttackPoints, level, attacks, currentLife, currentAttackPoints);

    }





}
