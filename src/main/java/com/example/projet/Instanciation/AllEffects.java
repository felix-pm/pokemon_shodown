package com.example.projet.Instanciation;

import com.example.projet.*;

public class AllEffects {
    private Effects burn;
    private Effects poison;
    private Effects paralysis;
    private Effects damocles;

    public AllEffects() {
        this.burn = new Burn(10);
        this.poison = new Poison(100);
        this.paralysis = new Paralysis(30);
        this.damocles = new Damocles(100);
    }

    public Effects getEffect(String nomDeLeffet) {
        switch (nomDeLeffet.toLowerCase()) {
            case "burn": return this.burn;
            case "poison": return this.poison;
            case "paralysis": return this.paralysis;
            case "damocles": return this.damocles;

            default:
                System.out.println("Erreur : L'effet " + nomDeLeffet + " n'existe pas !");
                return null;
        }
    }

    public Effects getBurn() { return burn; }
    public Effects getPoison() { return poison; }
    public Effects getParalysis() { return paralysis; }
    public Effects getDamocles() { return damocles; }
}