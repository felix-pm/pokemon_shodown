package com.example.projet;

public class Potion extends Item {
    private int healAmount;

    public Potion(int healAmount) {
        super("Potion", "Restaure " + healAmount + " PV.");
        this.healAmount = healAmount;
    }

    @Override
    public String use(Pokemon target) {
        if (!target.getIsAlive()) {
            return "Échec : " + target.getName() + " est KO et ne peut pas être soigné !";
        }
        int newHp = target.getHp() + healAmount;
        if (newHp > target.getMaxHp()) newHp = target.getMaxHp();

        target.setHp(newHp);
        return target.getName() + " a récupéré des PV grâce à la Potion !";
    }
}