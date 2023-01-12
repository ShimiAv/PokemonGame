package com.company;

public class Charmander extends FirePokemon {

    int scratchDamage = random.nextInt(Constants.SCRATCH_DAMAGE) + Constants.SCRATCH_DAMAGE_COMPLETION;
    Attack[] charmanderAttacks = new Attack[1];

    {
        new Attack("Scratch", 15, scratchDamage, 1);
    }


    public Charmander(int maxHp, int currentHp, int maxAttackPts, int currentAttackPts, String name, int currentLevel, int maxLevel, Attack[] attacks) {
        super(80, currentHp, 40, currentAttackPts, "Charmander", 1, 3, attacks);

    }
}
