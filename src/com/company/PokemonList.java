package com.company;

public class PokemonList {

    private static final FirePokemon[] CHARMANDER = new FirePokemon[]{
            new FirePokemon("Charmander", 40, 80, 1, new Attack[]{
                    AttackList.SCRATCH
            }),
            new FirePokemon("Charmeleon", 60, 90, 2, new Attack[]{
                    AttackList.FLAME_TAIL
            }),
            new FirePokemon("Charizard", 80, 130, 3, new Attack[]{
                    AttackList.FIERY_BLAST
            }),
    };

    private static final FirePokemon[] SALANDIT = new FirePokemon[]{
            new FirePokemon("Salandit", 60, 100, 1, new Attack[]{
                    AttackList.LIVE_COAL
            }),
            new FirePokemon("Salazzle", 80, 160, 2, new Attack[]{
                    AttackList.FIRE_CLAWS
            })
    };

    private static final FirePokemon[] MOLTERS = new FirePokemon[]{
            new FirePokemon("Moltres", 60, 120, 1, new Attack[]{
                    AttackList.ASSISTING_HEATER,
                    AttackList.FIRE_WING
            })
    };

    private static final ElectricPokemon[] PIKACHU = new ElectricPokemon[]{
            new ElectricPokemon("Pichu", 30, 40, 1, new Attack[]{
                    AttackList.QUICK_ATTACK
            }),
            new ElectricPokemon("Pikachu", 40, 50, 2, new Attack[]{
                    AttackList.ELECTRO_BALL
            }),
            new ElectricPokemon("Raichu", 80, 160, 3, new Attack[]{
                    AttackList.ELECTRIC_SURFER
            })
    };

    private static final ElectricPokemon[] BLITZLE = new ElectricPokemon[]{
            new ElectricPokemon("Blitzle", 35, 90, 1, new Attack[]{
                    AttackList.FLOP
            }),
            new ElectricPokemon("Zebstrika", 50, 100, 2, new Attack[]{
                    AttackList.ZAP_KICK
            })
    };

    private static final ElectricPokemon[] ELECTABUZZ = new ElectricPokemon[]{
            new ElectricPokemon("Electabuzz", 100, 30, 1, new Attack[]{
                    AttackList.THUNDER
            }),
            new ElectricPokemon("Electivire", 120, 35, 2, new Attack[]{
                    AttackList.THUNDER_PUNCH
            })
    };

    public static final Pokemon[][] pokemons = new Pokemon[][]{
            CHARMANDER, SALANDIT, MOLTERS, PIKACHU, BLITZLE, ELECTABUZZ
    };

}
