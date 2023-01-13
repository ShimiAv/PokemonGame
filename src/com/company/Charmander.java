package com.company;

import java.util.Scanner;

public class Charmander extends Pokemon {
    private Attack scratch;
    private Attack flameTail;
    private Attack fieryBlast;

    public Charmander() {
        super(80, 80, (int) (40 * 0.75), 40, 1);
        this.scratch = new Attack(15, 25, 30);
        this.flameTail = new Attack(40, 30, 50);
        this.fieryBlast = new Attack(50, 50, 30);
    }

    public void attack(Pokemon enemy) {
        this.setTurnCounter(this.getTurnCounter() + 1);
        Scanner scanner = new Scanner(System.in);
        Attack attack = null;
        int userChoice;
        do {
            System.out.println("Choose an Attack" +
                    "|1| - for Scratch" +
                    "|2| - for Flame Tail" +
                    "|3| - for Fiery Blast");
            userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1 -> attack = this.scratch;
                case 2 -> attack = this.flameTail;
                case 3 -> attack = this.fieryBlast;
            }

        } while (!isValidAttack(userChoice));
        this.performAttack(enemy, attack);

    }

    public boolean isValidAttack(int attack) {
        boolean valid = attack == Constants.LEVEL_ONE;
        if ((attack == Constants.LEVEL_TWO) && (this.getLevel() >= Constants.LEVEL_TWO)) valid = true;
        if ((attack == Constants.LEVEL_THREE) && (this.getLevel() == Constants.LEVEL_THREE)) valid = true;
        return valid;
    }


}
