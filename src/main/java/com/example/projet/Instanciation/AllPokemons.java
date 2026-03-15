package com.example.projet.Instanciation;

import com.example.projet.Pokemon;

public class AllPokemons {

    private AllTypes allTypes;
    private AllAttack allAttack; // On importe le catalogue d'attaques

    // Déclaration des Pokémons
    private Pokemon pikachu;
    private Pokemon ectoplasma;
    private Pokemon dracaufeu;
    private Pokemon florizarre;
    private Pokemon tortank;
    private Pokemon alakazam;
    private Pokemon mackogneur;
    private Pokemon ronflex;
    private Pokemon carchacrok;
    private Pokemon lucario;

    public AllPokemons(AllTypes types, AllAttack attacks) {
        this.allTypes = types;
        this.allAttack = attacks;

        // --- 1. PIKACHU ---
        this.pikachu = new Pokemon("Pikachu", 35, 55,
                50, 40, 50, 90,
                allTypes.getType("electric"), null);
        this.pikachu.addAttack(allAttack.getAttack("thunderbolt"));
        this.pikachu.addAttack(allAttack.getAttack("quick attack"));
        this.pikachu.addAttack(allAttack.getAttack("volt tackle"));
        this.pikachu.addAttack(allAttack.getAttack("iron tail"));

        // --- 2. ECTOPLASMA (Gengar) ---
        this.ectoplasma = new Pokemon("Ectoplasma", 60, 65,
                130, 60, 75, 110,
                allTypes.getType("ghost"), allTypes.getType("poison"));
        this.ectoplasma.addAttack(allAttack.getAttack("shadow ball"));
        this.ectoplasma.addAttack(allAttack.getAttack("sludge bomb"));
        this.ectoplasma.addAttack(allAttack.getAttack("lick"));
        this.ectoplasma.addAttack(allAttack.getAttack("dream eater"));

        // --- 3. DRACAUFEU (Charizard) ---
        this.dracaufeu = new Pokemon("Dracaufeu", 78, 84,
                109, 78, 85, 100,
                allTypes.getType("fire"), allTypes.getType("flying"));
        this.dracaufeu.addAttack(allAttack.getAttack("flamethrower"));
        this.dracaufeu.addAttack(allAttack.getAttack("flare blitz"));
        this.dracaufeu.addAttack(allAttack.getAttack("wing attack"));
        this.dracaufeu.addAttack(allAttack.getAttack("fire blast"));

        // --- 4. FLORIZARRE (Venusaur) ---
        this.florizarre = new Pokemon("Florizarre", 80, 82,
                100, 83, 100, 80,
                allTypes.getType("grass"), allTypes.getType("poison"));
        this.florizarre.addAttack(allAttack.getAttack("solar beam"));
        this.florizarre.addAttack(allAttack.getAttack("double-edge")); // Partagée avec Ronflex
        this.florizarre.addAttack(allAttack.getAttack("razor leaf"));
        this.florizarre.addAttack(allAttack.getAttack("sludge bomb")); // Partagée avec Ectoplasma

        // --- 5. TORTANK (Blastoise) ---
        this.tortank = new Pokemon("Tortank", 79, 83,
                85, 100, 105, 78,
                allTypes.getType("water"), null);
        this.tortank.addAttack(allAttack.getAttack("hydro pump"));
        this.tortank.addAttack(allAttack.getAttack("bite"));
        this.tortank.addAttack(allAttack.getAttack("water gun"));
        this.tortank.addAttack(allAttack.getAttack("take down"));

        // --- 6. ALAKAZAM ---
        this.alakazam = new Pokemon("Alakazam", 55, 50,
                135, 45, 95, 120,
                allTypes.getType("psychic"), null);
        this.alakazam.addAttack(allAttack.getAttack("psychic"));
        this.alakazam.addAttack(allAttack.getAttack("psycho cut"));
        this.alakazam.addAttack(allAttack.getAttack("fire punch"));
        this.alakazam.addAttack(allAttack.getAttack("thunder punch")); // Partagée avec Lucario

        // --- 7. MACKOGNEUR (Machamp) ---
        this.mackogneur = new Pokemon("Mackogneur", 90, 130,
                65, 80, 85, 55,
                allTypes.getType("fighting"), null);
        this.mackogneur.addAttack(allAttack.getAttack("cross chop"));
        this.mackogneur.addAttack(allAttack.getAttack("submission"));
        this.mackogneur.addAttack(allAttack.getAttack("poison jab")); // Partagée avec Carchacrok
        this.mackogneur.addAttack(allAttack.getAttack("karate chop"));

        // --- 8. RONFLEX (Snorlax) ---
        this.ronflex = new Pokemon("Ronflex", 160, 110,
                65, 65, 110, 30,
                allTypes.getType("normal"), null);
        this.ronflex.addAttack(allAttack.getAttack("body slam"));
        this.ronflex.addAttack(allAttack.getAttack("earthquake")); // Partagée avec Carchacrok
        this.ronflex.addAttack(allAttack.getAttack("hyper beam"));
        this.ronflex.addAttack(allAttack.getAttack("double-edge")); // Partagée avec Florizarre

        // --- 9. CARCHACROK (Garchomp) ---
        this.carchacrok = new Pokemon("Carchacrok", 108, 130,
                80, 95, 85, 102,
                allTypes.getType("dragon"), allTypes.getType("ground"));
        this.carchacrok.addAttack(allAttack.getAttack("dragon claw"));
        this.carchacrok.addAttack(allAttack.getAttack("fire fang"));
        this.carchacrok.addAttack(allAttack.getAttack("earthquake")); // Partagée avec Ronflex
        this.carchacrok.addAttack(allAttack.getAttack("poison jab")); // Partagée avec Mackogneur

        // --- 10. LUCARIO ---
        this.lucario = new Pokemon("Lucario", 70, 110,
                115, 70, 70, 90,
                allTypes.getType("fighting"), allTypes.getType("steel"));
        this.lucario.addAttack(allAttack.getAttack("aura sphere"));
        this.lucario.addAttack(allAttack.getAttack("close combat"));
        this.lucario.addAttack(allAttack.getAttack("bullet punch"));
        this.lucario.addAttack(allAttack.getAttack("thunder punch")); // Partagée avec Alakazam
    }

    // Getter global basé sur le nom
    public Pokemon getPokemon(String nomDuPokemon) {
        switch (nomDuPokemon.toLowerCase()) {
            case "pikachu": return this.pikachu;
            case "ectoplasma": return this.ectoplasma;
            case "dracaufeu": return this.dracaufeu;
            case "florizarre": return this.florizarre;
            case "tortank": return this.tortank;
            case "alakazam": return this.alakazam;
            case "mackogneur": return this.mackogneur;
            case "ronflex": return this.ronflex;
            case "carchacrok": return this.carchacrok;
            case "lucario": return this.lucario;

            default:
                System.out.println("Erreur : Le Pokémon " + nomDuPokemon + " n'existe pas !");
                return null;
        }
    }
}