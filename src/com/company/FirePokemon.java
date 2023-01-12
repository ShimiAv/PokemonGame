package com.company;

public class FirePokemon extends Pokemon {


    public FirePokemon(int maxHp, int currentHp, int maxAttackPts, int currentAttackPts, String name, int currentLevel, int maxLevel, Attack[] attacks) {
        super(maxHp, currentHp, maxAttackPts, currentAttackPts, name, currentLevel, maxLevel, attacks);
    }

    protected int uniqueFeature(int currentHp) {
        int updatedHp;
        int chance = random.nextInt(Constants.QUARTER_CHANCE);
        int selfDamage = random.nextInt(Constants.FIRE_POKEMON_SELF_DAMAGE) + Constants.FIRE_POKEMON_SELF_DAMAGE_COMPLETION;
        if (chance == Constants.NUMBER_TO_AVOID_SELF_DAMAGE) {
            updatedHp = currentHp - selfDamage;

        } else {
            updatedHp = currentHp;
        }
        return updatedHp;

    }





}
