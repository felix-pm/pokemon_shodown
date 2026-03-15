package com.example.projet;

import java.util.Random;

public class Paralysis extends Effects {
    private String nomStatut;

    public Paralysis(int chanceActivation) {
        super(chanceActivation);
        this.nomStatut = "Paralysis";
    }

    @Override
    public void applyEffect(Pokemon lanceur, Pokemon cible, int amountDamage) {

        if(cible.getStatut() != null){
            Random rand = new Random();
            int draw = rand.nextInt(100) + 1;
            if(draw <= 25){
                // faire en sorte que l'attaque se multiplie par 0
                // et que la vitesse sois diviser par 0 (diviser dans game loop)
            }
        } else {
            cible.setStatut(this);
            int newHp = (int) (cible.getHp() - cible.getHp()/16);
            cible.setHp(newHp);
        }
    }
}