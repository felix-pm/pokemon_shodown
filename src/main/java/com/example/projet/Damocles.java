package com.example.projet;

public class Damocles extends Effects {
    public Damocles(int chanceActivation) {
        super(chanceActivation);
        this.setName("Damocles");
    }

    @Override
    public void applyEffect(Pokemon attacker, Pokemon target, int amountDamage) {
        int newHp = (int) (attacker.getHp() - amountDamage/3);
        attacker.setHp(newHp);
        System.out.println("Le pokemon qui à attaqué a subi un contre coup !");
    }

    @Override
    public String applyEndOfTurn(Pokemon target) {
        return "";
    }
}