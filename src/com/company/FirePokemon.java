package com.company;

public class FirePokemon extends Pokemon{

    private int type;


    public void attack(Pokemon enemy) {

    }

    public void uniqueAbility () {
        int chance = Constants.RANDOM.nextInt(Constants.PERCENT_REPRESENTATIVE) + 1;
        if (chance <= Constants.SELF_DAMAGE) {
            int selfDamageAmount = Constants.RANDOM.nextInt(Constants.MIN_SELF_DAMAGE, Constants.MAX_SELF_DAMAGE + 1);
            int result = this.getCurrentLife() - selfDamageAmount;
            this.setCurrentLife(result);
        }
    }


    public FirePokemon(String name, int maxLife,  int maxAttackPoints, int level,Attack[] attacks) {
        super(name, maxLife, maxAttackPoints, level,attacks);
        this.type = Constants.FIRE_TYPE;
    }

    public int getType() {
        return type;
    }

    public FirePokemon (Pokemon other) {
        super(other);
    }

    public void selfDamage () {

    }
}
