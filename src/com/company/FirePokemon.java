package com.company;

public class FirePokemon extends Pokemon {

    private int type;


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


    public FirePokemon(String name, int maxLife, int maxAttackPoints, int level, Attack[] attacks, int currentLife, int currentAttackPoints) {
        super(name, maxLife, maxAttackPoints, level, attacks, currentLife, currentAttackPoints);
        this.type = Constants.FIRE_TYPE;
    }

    public static void doubleAttackPerform() {
        Attack attack1 = attacksRandomizer();
        Attack attack2 = attacksRandomizer();



    }

    private static Attack attacksRandomizer() {
        Attack randomAttack;
        int randomAttackIndex = Constants.RANDOM.nextInt(AttackList.firePokemonsAttackList.length);
        randomAttack = AttackList.firePokemonsAttackList[randomAttackIndex];

        return randomAttack;
    }


}
