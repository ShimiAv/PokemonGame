package com.company;

public class ElectricPokemon extends Pokemon {
    private int battery;
    private int type;

    public void uniqueAbility() {
        if (isDischargeNeeded()) {
            this.battery = 0;
        } else {
            this.battery += Constants.CHARGE_BOOST;
        }
        for (int i = 0; i < this.getAttacks().length; i++) {
            this.getAttacks()[i].setBonusDamage(this.battery);
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

    public ElectricPokemon(String name, int maxLife, int maxAttackPoints, int level, Attack[] attacks, int currentLife, int currentAttackPoints) {
        super(name, maxLife, maxAttackPoints, level, attacks, currentLife, currentAttackPoints);
        this.type = Constants.ELECTRIC_TYPE;
    }

    public int getType() {
        return type;
    }

    public void charge() {

    }

    public String toString() {
        return super.toString() + " Electricity: " + this.battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }


}
