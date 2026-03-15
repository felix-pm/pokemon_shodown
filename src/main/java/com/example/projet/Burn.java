package com.example.projet;

public class Burn extends Effects {
    private String nomStatut;
    public Burn(int chanceActivation) {
        super(chanceActivation);
        this.nomStatut = "Burn";
    }

    @Override
    public void applyEffect(Pokemon attacker, Pokemon target, int amountDamage) {

        if(target.getStatut() != null){
            int newHp = target.getHp() - target.getHp()/16;
            target.setHp(newHp);
        } else {
            target.setStatut(this);
            int newHp = (int) (target.getHp() - target.getHp()/16);
            target.setHp(newHp);
        }
    }

}