package com.example.projet;

public class Leftovers extends Item {
    public Leftovers() {
        super("Restes", "Restaure 8% des HP à chaque tour.");
    }

    @Override
    public String use(Pokemon target) {
        int heal = target.getMaxHp() * 8 / 100;
        int newHp = Math.min(target.getMaxHp(), target.getHp() + heal);
        target.setHp(newHp);
        return target.getName() + " regagne des PV grâce à ses Restes !";
    }
}