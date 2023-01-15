package com.company;

import java.util.Scanner;

public class Battle {
    private static Pokemon player1 = randomizePokemon();
    private static Pokemon player2 = randomizePokemon();

    private static Pokemon randomizePokemon() {

        int randomRaw = Constants.RANDOM.nextInt(PokemonList.pokemonTable.length);
        Pokemon randomPokemon = PokemonList.pokemonTable[randomRaw][Constants.START_RANDOM_COL];
        return randomPokemon;

    }

    public static void performTurn(Pokemon pokemon1, Pokemon pokemon2) {
        int userChoice;
        System.out.println("Choose an option: " + "\n" +
                "|1| for Attack" + "\n" +
                "|2| for Skip turn" + "\n" +
                "|3| for Evolve" + "\n" +
                "|4| for Special Ability "+ "\n" +
                "|5| for kick");
        userChoice = Constants.SCANNER.nextInt();
        switch (userChoice) {
            case 1 -> pokemon1.performAttack(pokemon2);
            case 2 -> pokemon1.skipTurn();
            case 3 -> pokemon1.evolve();
            case 4 -> pokemon1.specialAbilityPerform(pokemon1);
            case 5 -> pokemon1.kick(pokemon2);
            default -> System.out.println("Invalid input, please try again");

        }
        pokemon1.setCurrentAttackPoints(Constants.RANDOM.nextInt(Constants.AP_TO_ADD_EACH_TURN));
        pokemon1.setCurrentLife(Constants.RANDOM.nextInt(Constants.HP_TO_ADD_EACH_TURN));
    }

    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("player 1: " + player1.getName() + " " + player1);
        System.out.println("player 2: " + player2.getName() + " " + player2);
        while (player1.isAlive() && player2.isAlive()) {
            System.out.print("PLAYER 1: ");
            performTurn(player1, player2);
            System.out.print("PLAYER 2: ");
            performTurn(player2, player1);
            System.out.println("player 1: " + player1.getName() + " " + player1);
            System.out.println("player 2: " + player2.getName() + " " + player2);
        }

    }


}
