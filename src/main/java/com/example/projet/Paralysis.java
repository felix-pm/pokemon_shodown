package com.example.projet;

import java.util.Random;

public class Paralysis extends Effects {

    public Paralysis(int chanceActivation) {
        super(chanceActivation);
        this.setName("Paralysis");
    }

    @Override
    public void applyEffect(Pokemon attacker, Pokemon target, int amountDamage) {

        if(target.getStatut() == null){
            target.setStatut(this);
            System.out.println("Le " + target.getName() + " est maintenant paralysé !");
        }
    }

    @Override
    public String applyEndOfTurn(Pokemon target) {
        return "";
    }
}