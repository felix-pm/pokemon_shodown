package com.example.projet;

public class Antidote extends Item {
    public Antidote() {
        super("Antidote", "Soigne le statut Poison.");
    }

    @Override
    public String use(Pokemon target) {
        if (target.getStatut() != null && target.getStatut().getName().equalsIgnoreCase("Poison")) {
            target.setStatut(null);
            return target.getName() + " est guéri du poison !";
        }
        return "L'Antidote n'a aucun effet sur " + target.getName() + ".";
    }
}