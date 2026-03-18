package com.example.projet;

public class TotalSoin extends Item {
    public TotalSoin() {
        super("Total Soin", "Guérit n'importe quelle altération de statut.");
    }

    @Override
    public String use(Pokemon target) {
        if (target.getStatut() != null) {
            String statutName = target.getStatut().getName();
            target.setStatut(null);
            return target.getName() + " n'est plus affecté par " + statutName + " !";
        }
        return target.getName() + " n'a aucun problème de statut.";
    }
}