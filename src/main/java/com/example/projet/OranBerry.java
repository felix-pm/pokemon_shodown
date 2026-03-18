package com.example.projet;

public class OranBerry extends Item {
    public OranBerry() {
        super("Baie Oran", "Soigne 10 PV automatiquement si les PV tombent sous 50%.");
    }

    @Override
    public String use(Pokemon target) {
        target.setHp(target.getHp() + 10);
        return target.getName() + " consomme sa Baie Oran et récupère 10 PV !";
    }
}