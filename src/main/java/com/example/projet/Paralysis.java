package com.example.projet;

import java.util.Random;

public class Paralysis extends Effects {
    private String nomStatut;

    public Paralysis(int chanceActivation) {
        super(chanceActivation);
        this.nomStatut = "Paralysis";
    }

    @Override
    public void applyEffect(Pokemon attacker, Pokemon target, int amountDamage) {

        if(target.getStatut() == null){
            target.setStatut(this);
            System.out.println("Le " + target.getName() + " est maintenant paralysé !");
        }
    }
}