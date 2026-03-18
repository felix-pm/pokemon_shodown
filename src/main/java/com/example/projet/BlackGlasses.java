package com.example.projet;

public class BlackGlasses extends Item {
    public BlackGlasses() {
        super("Lunettes Noires", "Augmente la puissance des attaques Ténèbres de 20%.");
    }

    @Override
    public String use(Pokemon target) {
        return "";
    }
}