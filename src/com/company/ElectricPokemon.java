package com.company;

public class ElectricPokemon extends Pokemon {
    private int electricity;
    private int type;

    public void uniqueAbility() {
        if (isDischargeNeeded()) {
            this.electricity = 0;
        } else {
            this.electricity += Constants.CHARGE_BOOST;
        }
        for (int i = 0; i < this.getAttacks().length; i++) {
            this.getAttacks()[i].setBonusDamage(this.electricity);
        }
    }

    private boolean isDischargeNeeded() {
        boolean result = false;
        int selfDischargeLimit = (this.getMaxLife() * Constants.DISCHARGE_PERCENTAGE) / Constants.PERCENT_REPRESENTATIVE;
        if (this.getCurrentLife() <= selfDischargeLimit) {
            result = true;
        }
        return result;
    }


    public void specialPower() {

    }

    ;

    public ElectricPokemon(String name,  int maxLife,  int maxAttackPoints, int level, Attack[] attacks) {
        super(name,  maxLife,  maxAttackPoints, level, attacks);
        this.type = Constants.ELECTRIC_TYPE;
    }

    public int getType() {
        return type;
    }

    public ElectricPokemon(Pokemon other) {
        super(other);
    }

    public void attack(Pokemon enemy) {

    }


    public void charge() {

    }

    public String toString() {
        return super.toString() + " Electricity: " + this.electricity;
    }

}
