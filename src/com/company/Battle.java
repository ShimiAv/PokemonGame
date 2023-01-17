package com.company;


public class Battle {

    public static Trainer player1 = new Trainer("PLAYER1", 1, Battle.randomizePokemon());
    public static Trainer player2 = new Trainer("PLAYER2", 1, Battle.randomizePokemon());

    static Pokemon[] randomizePokemon() {

        int randomRaw = Constants.RANDOM.nextInt(PokemonList.pokemonTable.length);
        Pokemon[] randomPokemons = new Pokemon[1];
        Pokemon randomPokemon = PokemonList.pokemonTable[randomRaw][Constants.START_RANDOM_COL];
        randomPokemons[0] = randomPokemon;
        return randomPokemons;

    }

    public static void startGame(Trainer player1, Trainer player2) {
        boolean endLoop = false;
        int userChoice;
        System.out.println("PLAYER 1: " + player1.getName() + " " + player1);
        System.out.println("PLAYER 2: " + player2.getName() + " " + player2);
        System.out.println("Choose an option: " + "\n" +
                "|1| for Attack" + "\n" +
                "|2| for Skip turn" + "\n" +
                "|3| for Evolve" + "\n" +
                "|4| for Special Ability " + "\n"
               );
        userChoice = Constants.SCANNER.nextInt();
        Constants.SCANNER.nextLine();
        switch (userChoice) {
            case 1 -> {
                if (!player1.getPokemons()[player1.getLevel() - 1].tryToKill(player2.getPokemons()[player2.getLevel() - 1])) {
                    endLoop = true;
                } else {
                    switchTurn();
                }
            }
            case 2 -> {
                player1.getPokemons()[player1.getLevel() - 1].skipTurn();
                switchTurn();
            }
            case 3 -> {
                if (player1.levelUp()) {
                    switchTurn();
                }
            }
            case 4 -> {
                switch (player1.getPokemons()[player1.getLevel() - 1].specialPower()) {
                    case Constants.SPECIAL_POWER_FAILURE -> System.out.println("Special power failed");
                    case Constants.SPECIAL_POWER_SUCCESS -> switchTurn();
                    case Constants.CRITICAL_DAMAGE -> {
                        if (player2.getPokemons()[player2.getLevel() - 1].doubleDamage(player1.getPokemons()[player1.getLevel() - 1])) {
                            System.out.println(player2.getPokemons()[player2.getLevel() - 1].getName() + " is dead");
                            endLoop = true;
                        } else {
                            switchTurn();
                        }
                    }
                }
            }
            default -> System.out.println("Invalid input, please try again");
        }

        while (!endLoop) ;
        }




    public static void switchTurn() {

        while (player1.getPokemon().isAlive() && player2.getPokemon().isAlive()) {

            startGame(player1, player2);

            startGame(player2, player1);
            System.out.println("PLAYER 1: " + player1.getName() + " " + player1);
            System.out.println("PLAYER 2: " + player2.getName() + " " + player2);
        }
    }


    public static void intro() {
        System.out.println("*** Pokemon are magical creatures of different types and with different special abilities. " +"\n"+
                "Pokemon are captured by Pokemon Trainers, so they can train them to fight battles against each other, " +"\n"+
                "as part of some weird national sport.In battle, each Pokemon has a certain amount of life points, " +"\n"+
                "when they run out - it is defeated in battle. Also, each Pokemon has a certain amount of attack points, " +"\n"+
                "with which it can perform attacks against its opponent. " +"\n"+
                "That is, if a certain attack costs 15 attack points, the Pokemon will only be able to perform that attack if it currently has 15 or more attack points." +"\n"+
                "On top of that, certain types of Pokemon can evolve, that is, change their form, the nature and power of their attacks. ***"

        );
        System.out.println();
    }





}