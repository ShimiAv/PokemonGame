package com.company;

public class ElectricPokemon extends Pokemon {
    private int battery;
    private boolean isSpecialPowerAvailable;

    public ElectricPokemon(String name, int maxLife, int maxAttackPoints, int level, Attack[] attack, int currentLife, int currentAttackPoints) {
        super(name, maxLife, maxAttackPoints, level, attack, currentLife, currentAttackPoints);
    } //O(1)

    public void uniqueAbility() {
        for (int i = 0; i < this.getAttacks().length; i++) {
            this.getAttacks()[i].setBonusDamage(this.battery);
        }
    } //O(1)

    private boolean isDischargeNeeded() {
        boolean result = false;
        int selfDischargeLimit = (this.getMaxLife() * Constants.DISCHARGE_PERCENTAGE) / Constants.PERCENT_REPRESENTATIVE;
        if (this.getCurrentLife() <= selfDischargeLimit) {
            result = true;
        }
        return result;
    } //O(1)

    public ElectricPokemon() {
        super();
    } //O(1)

    public Pokemon duplicatePokemon() {
        ElectricPokemon newPokemon = new ElectricPokemon();
        this.statsDuplication(newPokemon);
        return newPokemon;
    } //O(1)

    public void skipTurn() {
        super.skipTurn();
        this.addBattery();
    } //O(1)

    private void addBattery() {
        this.battery += Constants.ELECTRICITY_TO_ADD;
    } //O(1)

    protected void damage(int damage) {
        super.performAttack(damage);
        if (isLowBattery()) {
            this.battery = 0;
        }
    } //O(1)

    private boolean isLowBattery() {
        boolean isLow = false;
        int batteryPercentToDischarge = this.getMaxLife() * Constants.DISCHARGE_PERCENTAGE / Constants.PERCENT_REPRESENTATIVE;
        if (this.getCurrentLife() < batteryPercentToDischarge) {
            isLow = true;
        }
        return isLow;
    } //O(1)

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
    } //O(1)

    public void getCurrentStats(Pokemon lowerLevel) {
        super.getPreviousStats(lowerLevel);
        this.battery = ((ElectricPokemon) lowerLevel).battery;
        this.isSpecialPowerAvailable = ((ElectricPokemon) lowerLevel).isSpecialPowerAvailable;
        this.isLowBattery();

    } //O(1)


    public String toString() {
        return super.toString() + " Battery : " + this.battery;
    } //O(1)


}
