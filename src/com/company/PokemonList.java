package com.company;

public class PokemonList {

    private static final FirePokemon[] CHARMANDER = new FirePokemon[]{
            new FirePokemon("Charmander", 1, 80, 40, new Attack[]{
                    AttackList.SCRATCH
            }),
            new FirePokemon("Charmeleon", 2, 90, 60, new Attack[]{
                    AttackList.FLAME_TAIL
            }),
            new FirePokemon("Charizard", 3, 130, 80, new Attack[]{
                    AttackList.FIERY_BLAST
            }),
    };

    private static final FirePokemon[] SALANDIT = new FirePokemon[]{
            new FirePokemon("Salandit", 1, 100, 60, new Attack[]{
                    AttackList.LIVE_COAL
            }),
            new FirePokemon("Salazzle", 2, 160, 80, new Attack[]{
                    AttackList.FIRE_CLAWS
            })
    };

    private static final FirePokemon[] MOLTERS = new FirePokemon[]{
            new FirePokemon("Moltres", 1, 120, 60, new Attack[]{
                    AttackList.ASSISTING_HEATER,
                    AttackList.FIRE_WING
            })
    };

    private static final ElectricPokemon[] PIKACHU = new ElectricPokemon[]{
            new ElectricPokemon("Pichu", 1, 40, 30, new Attack[]{
                    AttackList.QUICK_ATTACK
            }),
            new ElectricPokemon("Pikachu", 2, 50, 40, new Attack[]{
                    AttackList.ELECTRO_BALL
            }),
            new ElectricPokemon("Raichu", 3, 160, 80, new Attack[]{
                    AttackList.ELECTRIC_SURFER
            })
    };

    private static final ElectricPokemon[] BLITZLE = new ElectricPokemon[]{
            new ElectricPokemon("Blitzle", 1, 90, 35, new Attack[]{
                    AttackList.FLOP
            }),
            new ElectricPokemon("Zebstrika", 2, 100, 50, new Attack[]{
                    AttackList.ZAP_KICK
            })
    };

    private static final ElectricPokemon[] ELECTABUZZ = new ElectricPokemon[]{
            new ElectricPokemon("Electabuzz", 1, 30, 100, new Attack[]{
                    AttackList.THUNDER
            }),
            new ElectricPokemon("Electivire", 2, 35, 120, new Attack[]{
                    AttackList.THUNDER_PUNCH
            })
    };

    public static final Pokemon[][] pokemons = new Pokemon[][]{
            CHARMANDER, SALANDIT, MOLTERS, PIKACHU, BLITZLE, ELECTABUZZ
    };

}
