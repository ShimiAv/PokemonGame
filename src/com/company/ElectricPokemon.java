package com.company;

public class ElectricPokemon extends Pokemon {
    private int battery;
    private boolean isSpecialPowerAvailable;

    public ElectricPokemon(String name, int maxLife, int maxAttackPoints, int level, Attack[] attack, int currentLife, int currentAttackPoints) {
        super(name, maxLife, maxAttackPoints, level, attack, currentLife, currentAttackPoints);
    }

    public void uniqueAbility() {
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

    public ElectricPokemon() {
        super();
    }

    public Pokemon duplicatePokemon() {
        ElectricPokemon newPokemon = new ElectricPokemon();
        this.statsDuplication(newPokemon);
        return newPokemon;
    }

    public void skipTurn() {
        super.skipTurn();
        this.addBattery();
    }

    private void addBattery() {
        this.battery += Constants.ELECTRICITY_TO_ADD;
    }

    protected void damage(int damage) {
        super.performAttack(damage);
        if (isLowBattery()) {
            this.battery = 0;
        }
    }

    private boolean isLowBattery() {
        boolean isLow = false;
        int batteryPercentToDischarge = this.getMaxLife() * Constants.DISCHARGE_PERCENTAGE / Constants.PERCENT_REPRESENTATIVE;
        if (this.getCurrentLife() < batteryPercentToDischarge) {
            isLow = true;
        }
        return isLow;
    }

    public int specialPower() {
        int result = Constants.SPECIAL_POWER_FAILURE;
        if (!isSpecialPowerAvailable) {
            this.setCurrentLife(this.getMaxLife());
            this.setCurrentAttackPoints(this.getMaxAttackPoints());
            isSpecialPowerAvailable = true;
            result = Constants.SPECIAL_POWER_SUCCESS;
            this.addBattery();
        }
        return result;
    }

    public void getCurrentStats(Pokemon lowerLevel) {
        super.getPreviousStats(lowerLevel);
        this.battery = ((ElectricPokemon) lowerLevel).battery;
        this.isSpecialPowerAvailable = ((ElectricPokemon) lowerLevel).isSpecialPowerAvailable;
        this.isLowBattery();

    }


    public String toString() {
        return super.toString() + " Battery : " + this.battery;
    }


}
