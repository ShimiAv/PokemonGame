package com.company;

public class AttackList {



    public static final Attack SCRATCH = new Attack("Scratch", 15, 25, 30);
    public static final Attack FLAME_TAIL = new Attack("Flame Tail", 40, 30, 50);
    public static final Attack FIERY_BLAST = new Attack("Fiery Blast", 50, 50, 50);
    public static final Attack LIVE_COAL = new Attack("Live Coal", 10, 0, 25);
    public static final Attack FIRE_CLAWS = new Attack("Fire Claws", 25, 0, 50);
    public static final Attack ASSISTING_HEATER = new Attack("Assisting Heater", 30, 10, 60);
    public static final Attack FIRE_WING = new Attack("Fire Wing", 30, 30, 30);


    public static final Attack QUICK_ATTACK = new Attack("Quick Attack", 5, 10, 10);
    public static final Attack ELECTRO_BALL = new Attack("Electro Ball", 10, 30, 40);
    public static final Attack ELECTRIC_SURFER = new Attack("Electric Surfer", 60, 20, 120);
    public static final Attack FLOP = new Attack("Flop", 20, 20, 25);
    public static final Attack ZAP_KICK = new Attack("Zap Kick", 30, 30, 35);
    public static final Attack THUNDER = new Attack("Thunder", 60, 40, 50);
    public static final Attack THUNDER_PUNCH = new Attack("Thunder Punch", 80, 50, 120);

    public static final Attack[] firePokemonsAttackList = new Attack[6];{
        firePokemonsAttackList[0] = SCRATCH;
        firePokemonsAttackList[1] = FLAME_TAIL;
        firePokemonsAttackList[2] = FIERY_BLAST;
        firePokemonsAttackList[3] = LIVE_COAL;
        firePokemonsAttackList[4] = FIRE_CLAWS;
        firePokemonsAttackList[5] = ASSISTING_HEATER;
        firePokemonsAttackList[6] = FIRE_WING;





    }


}
