package com.example.projet;

public class Poison extends Effects {
    private String nomStatut;

    public Poison(int chanceActivation) {
        super(chanceActivation);
        this.nomStatut = "Poison";
    }

    @Override
    public void applyEffect(Pokemon attacker, Pokemon target, int amountDamage) {

        if(target.getStatut() != null){
            int newHp = target.getHp() - target.getHp()/8;
            target.setHp(newHp);
        } else {
            target.setStatut(this);
            int newHp = (int) (target.getHp() - target.getHp()/8);
            target.setHp(newHp);
        }
    }
}