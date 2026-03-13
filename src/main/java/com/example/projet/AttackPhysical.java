package com.example.projet;

public class AttackPhysical extends Attack{

    public AttackPhysical(String name, int puissance, Type type, Effect effect) {
        super(name, puissance, type, effect);
    }

    public AttackPhysical(String name, int puissance, Type type) {
        super(name, puissance, type);
    }

    @Override
    public void attacking() {

    }
}
