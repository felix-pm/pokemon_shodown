package com.example.projet;

public abstract class Attack {

    private String name;
    protected int power;
    protected Type type;
    protected Effects effect;

    public Attack(String name, int power, Type type, Effects effect){
        this.name = name;
        this.power = power;
        this.type = type;
        this.effect = effect;
    }

    public Attack(String name, int power, Type type){
        this.name = name;
        this.power = power;
        this.type = type;
        this.effect = null;
    }

    public void checkEffect(Pokemon attacker, Pokemon target, int damage){
        if(this.effect != null){
            this.effect.applyEffect(attacker, target, damage);
        }
    }

    public abstract int attacking(Pokemon attacker, Pokemon target);
}
