package com.example.projet;

public class Poison extends Effects {

    public Poison(int chanceActivation) {
        super(chanceActivation);
        this.setName("Poison");
    }

    @Override
    public void applyEffect(Pokemon attacker, Pokemon target, int amountDamage) {
        if(target.getStatut() == null){
            target.setStatut(this);
            System.out.println("Le " + target.getName() + " est maintenant empoisonné !");
        }
    }

    @Override
    public String applyEndOfTurn(Pokemon target) {
        int damage = target.getHp() / 8;
        if(damage < 1) damage = 1;
        target.setHp(target.getHp() - damage);
        return target.getName() + " souffre du poison et perd " + damage + " PV.";
    }
}