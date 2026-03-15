package com.example.projet;

public class AttackSpecial extends Attack{

    public AttackSpecial(String name, int power, Type type, Effects effect) {
        super(name, power, type, effect);
    }

    public AttackSpecial(String name, int power, Type type) {
        super(name, power, type);
    }

    // Function that calculate and substract the hp of the target by the damage's attack of the attacker
    @Override
    public void attacking(Pokemon attacker, Pokemon target) {
        double min = 0.85;
        double max = 1.0;
        double variation = min + (Math.random() * (max - min));

        double efficiency = this.type.getMultCounter(target.getType1());

        if (target.getType2() != null) {
            efficiency *= this.type.getMultCounter(target.getType2());
        }
        double damage = (this.power * ((double) attacker.getSpecialAttack() / target.getSpecialDefense()) * efficiency * variation);

        checkEffect(attacker, target, (int) (damage) );

        int finalDamage = (damage < 1 && efficiency > 0) ? 1 : (int) damage;

        System.out.println("Le " + attacker.getName() + "a mis "  + finalDamage + " dégât au " + target.getName() +" adverse !");

        int newHp = target.getHp() - finalDamage;
        target.setHp(newHp);
    }
}
