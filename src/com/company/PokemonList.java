package com.company;

public class PokemonList {

    private static  FirePokemon[] CHARMANDER = new FirePokemon[]{
            new FirePokemon("Charmander", 80, 40, 1, new Attack[]{
                    AttackList.SCRATCH
            }, 80, 30),
            new FirePokemon("Charmeleon", 90, 60, 2, new Attack[]{
                    AttackList.FLAME_TAIL
            }, 90, 60),
            new FirePokemon("Charizard", 130, 80, 3, new Attack[]{
                    AttackList.FIERY_BLAST
            }, 130, 80),
    };

    private static  FirePokemon[] SALANDIT = new FirePokemon[]{
            new FirePokemon("Salandit", 100, 60, 1, new Attack[]{
                    AttackList.LIVE_COAL
            }, 100, 45),
            new FirePokemon("Salazzle", 160, 80, 2, new Attack[]{
                    AttackList.FIRE_CLAWS
            }, 160, 80)
    };

    private static  FirePokemon[] MOLTERS = new FirePokemon[]{
            new FirePokemon("Moltres", 120, 60, 1, new Attack[]{
                    AttackList.ASSISTING_HEATER,
                    AttackList.FIRE_WING
            }, 120, 45)
    };

    private static  ElectricPokemon[] PIKACHU = new ElectricPokemon[]{
            new ElectricPokemon("Pichu", 40, 30, 1, new Attack[]{
                    AttackList.QUICK_ATTACK
            }, 40, 23),
            new ElectricPokemon("Pikachu", 50, 40, 2, new Attack[]{
                    AttackList.ELECTRO_BALL
            }, 50, 40),
            new ElectricPokemon("Raichu", 160, 80, 3, new Attack[]{
                    AttackList.ELECTRIC_SURFER
            }, 160, 80)
    };

    private static  ElectricPokemon[] BLITZLE = new ElectricPokemon[]{
            new ElectricPokemon("Blitzle", 90, 35, 1, new Attack[]{
                    AttackList.FLOP
            }, 90, 27),
            new ElectricPokemon("Zebstrika", 100, 50, 2, new Attack[]{
                    AttackList.ZAP_KICK
            }, 100, 50)

    };

    private static  ElectricPokemon[] ELECTABUZZ = new ElectricPokemon[]{
            new ElectricPokemon("Electabuzz", 100, 30, 1, new Attack[]{
                    AttackList.THUNDER
            }, 100, 23),
            new ElectricPokemon("Electivire", 120, 35, 2, new Attack[]{
                    AttackList.THUNDER_PUNCH
            }, 120, 35)
    };

    public static  Pokemon[][] pokemonTable = new Pokemon[][]{
            CHARMANDER, SALANDIT, MOLTERS, PIKACHU, BLITZLE, ELECTABUZZ
    };


}
