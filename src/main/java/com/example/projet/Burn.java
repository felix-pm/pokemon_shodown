package com.example.projet;

public class Burn extends Effects {
    public Burn(int chanceActivation) {
        super(chanceActivation);
        this.setName("Burn");
    }

    @Override
    public void applyEffect(Pokemon attacker, Pokemon target, int amountDamage) {
        if(target.getStatut() == null){
            target.setStatut(this);
            System.out.println("Le " + target.getName() + " est maintenant brulé !");
        }
    }

    @Override
    public String applyEndOfTurn(Pokemon target) {
        int damage = target.getHp() / 16;
        if(damage < 1) damage = 1;
        target.setHp(target.getHp() - damage);
        return target.getName() + " souffre de sa brûlure et perd " + damage + " PV.";
    }

}