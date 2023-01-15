package com.company;

import java.util.Scanner;

public class Battle {
    private static final Pokemon PLAYER_1 = randomizePokemon();
    private static final Pokemon PLAYER_2 = randomizePokemon();

    private static Pokemon randomizePokemon() {

        int randomRaw = Constants.RANDOM.nextInt(PokemonList.pokemonTable.length);
        Pokemon randomPokemon = PokemonList.pokemonTable[randomRaw][Constants.START_RANDOM_COL];
        return randomPokemon;

    }

    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("player 1: " + PLAYER_1.getName() + " " + PLAYER_1);
        System.out.println("player 2: " + PLAYER_2.getName() + " " + PLAYER_2);
        int userChoice;
        while (PLAYER_1.isAlive() && PLAYER_2.isAlive()) {
            System.out.println("Player 1 turn: ");
            System.out.println("Choose an option: " +
                    "|1| for Attack" +
                    "|2| for Skip turn" +
                    "|3| for Evolve" +
                    "|4| for Special Ability ");
            userChoice = Constants.SCANNER.nextInt();
            switch (userChoice) {
                case 1 -> PLAYER_1.attack(PLAYER_2);
                case 2 -> PLAYER_1.skipTurn();
                //case 3 -> PLAYER_1.evolve();
                //case 4 -> PLAYER_1.specialAbility();

            }
        }

    }




}
