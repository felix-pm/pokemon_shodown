package com.example.projet;

public class AttackSpecial extends Attack{

    public AttackSpecial(String name, int puissance, Type type, Effect effect) {
        super(name, puissance, type, effect);
    }

    public AttackSpecial(String name, int puissance, Type type) {
        super(name, puissance, type);
    }

    @Override
    public void attacking() {

    }
}
