package com.example.projet;

public class Rappel extends Item {
    public Rappel() {
        super("Rappel", "Ressuscite un Pokémon KO avec 50% de ses PV max.");
    }

    @Override
    public String use(Pokemon target) {
        if (!target.getIsAlive()) {
            target.setAlive(true);
            target.setHp(target.getMaxHp() / 2);
            return target.getName() + " est ressuscité et prêt à combattre !";
        }
        return "Échec : " + target.getName() + " n'est pas KO !";
    }
}