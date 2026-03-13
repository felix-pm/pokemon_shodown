package com.example.projet;

public abstract class Attack {

    private String name;
    private int puissance;
    private Type type;
    private Effect effect;

    public Attack(String name, int puissance, Type type, Effect effect){
        this.name = name;
        this.puissance = puissance;
        this.type = type;
        this.effect = effect;
    }

    public Attack(String name, int puissance, Type type){
        this.name = name;
        this.puissance = puissance;
        this.type = type;
    }

    public abstract void attacking();
}
