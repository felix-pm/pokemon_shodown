package com.example.projet;

import java.util.Random;

public abstract class Effects {
    private String name;
    private int chanceActivation;

    public Effects(int chanceActivation) {
        this.chanceActivation = chanceActivation;
    }

    public int getChanceActivation() {
        return chanceActivation;
    }

    public boolean isTriggered() {
        Random rand = new Random();
        int tirage = rand.nextInt(100) + 1;
        return tirage <= chanceActivation;
    }

    public abstract void applyEffect(Pokemon attacker, Pokemon cible, int amountDamage);
    public abstract String applyEndOfTurn(Pokemon target);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
