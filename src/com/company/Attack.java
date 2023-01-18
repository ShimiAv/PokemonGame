package com.company;


public class Attack {
    private String name;
    private int cost;
    private int minDamage;
    private int maxDamage;
    private int bonusDamage;

    public Attack(String name, int cost, int minDamage, int maxDamage) {
        this.name = name;
        this.cost = cost;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    } //O(1)

    public int getCost() {
        return this.cost;
    } //O(1)

    public void setBonusDamage(int bonusDamage) {
        this.bonusDamage = bonusDamage;
    } //O(1)

    public int damageRandomizer(){
        int damage;
        int calculatedBonus ;
        if (this.minDamage==this.maxDamage){
            damage=minDamage;
        }else {
            damage = Constants.RANDOM.nextInt(minDamage,maxDamage);
        }
        calculatedBonus = bonusPercentage(damage);
        return calculatedBonus;
    } //O(1)

    private int bonusPercentage (int bonus) {
        return bonus + (bonus * this.bonusDamage/ 100);
    } //O(1)

    public String toString () {
        String text = "Attack name: " + this.name + "(" + this.cost + " points)";
        text += " Damage: ";
        text += (this.minDamage==this.maxDamage)? (bonusPercentage(this.maxDamage)): (bonusPercentage(this.minDamage)) + " / " + (bonusPercentage(this.maxDamage));
        return text;
    } //O(1)
}
