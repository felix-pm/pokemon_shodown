package com.example.projet;

public class Damocles extends Effects {
    private String nomStatut;
    public Damocles(int chanceActivation) {
        super(chanceActivation);
        this.nomStatut = "Damocles";
    }

    @Override
    public void applyEffect(Pokemon attacker, Pokemon target, int amountDamage) {
        int newHp = (int) (attacker.getHp() - amountDamage/3);
        attacker.setHp(newHp);
        System.out.println("Le pokemon qui à attaqué a subi un contre coup !");
    }

}