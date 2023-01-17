package com.company;

public class Trainer {
    private String name;
    private Pokemon[] pokemons;
    private int level;

    public Trainer(String name, int level, Pokemon[] pokemon) {
        this.name = name;
        this.pokemons = pokemon;
    }

    public String getName() {
        String name = "";
        Pokemon pokemon;
        for (int i = 0; i < pokemons.length; i++) {
            if (pokemons[i] != null) {
                pokemon = pokemons[i];
                name = pokemon.getName();
            }
        }
        return name;
    }

    public int getLevel() {
        int level = 0;
        Pokemon pokemon;
        for (int i = 0; i < pokemons.length; i++) {
            if (pokemons[i] != null) {
                pokemon = pokemons[i];
                level = pokemon.getLevel();
            }
        }
        return level;
    }

    public Pokemon getPokemon() {
        Pokemon pokemonToReturn = null;
        for (int i = 0; i < pokemons.length; i++) {
            if (pokemons[i] != null) {
                pokemonToReturn = pokemons[i];
            }
        }
        return pokemonToReturn;
    }

    public boolean levelUp() {
        boolean result = false;
        if (this.level < this.getPokemons().length) {
            int[] minLifeToEvolve = {Constants.LIFE_REDUCTION_FIRST_EVOLVE, Constants.LIFE_REDUCTION_SECOND_EVOLVE};
            int[] minManaToEvolve = {Constants.ATTACK_REDUCTION_FIRST_EVOLVE, Constants.ATTACK_REDUCTION_SECOND_EVOLVE};
            if (this.pokemons[1] != null && this.pokemons[0].isEvolvePossible(minLifeToEvolve[1], minManaToEvolve[1])) {
                this.pokemons[1].getPreviousStats(this.pokemons[0]);
                this.level++;
                result = true;
            }
        } else {
            System.out.println("You are at your max level");
        }
        return result;
    }

    public String toString() {
        return this.getPokemon() + "";
    }

    public Pokemon[] getPokemons() {
        return this.pokemons;
    }


}
