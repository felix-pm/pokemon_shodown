package com.example.projet.Instanciation;

import com.example.projet.Pokemon;

public class AllPokemons {

    private AllTypes allTypes;

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

    public AllPokemons(AllTypes types) {
        this.allTypes = types;

        this.pikachu = new Pokemon("Pikachu", 35, 55, 50, 40, 50, 90,
                allTypes.getType("electric"), null);

        this.ectoplasma = new Pokemon("Ectoplasma", 60, 65, 130, 60, 75, 110,
                allTypes.getType("ghost"), allTypes.getType("poison"));

        this.dracaufeu = new Pokemon("Dracaufeu", 78, 84, 109, 78, 85, 100,
                allTypes.getType("fire"), allTypes.getType("flying"));

        this.florizarre = new Pokemon("Florizarre", 80, 82, 100, 83, 100, 80,
                allTypes.getType("grass"), allTypes.getType("poison"));

        this.tortank = new Pokemon("Tortank", 79, 83, 85, 100, 105, 78,
                allTypes.getType("water"), null);

        this.alakazam = new Pokemon("Alakazam", 55, 50, 135, 45, 95, 120,
                allTypes.getType("psychic"), null);

        this.mackogneur = new Pokemon("Mackogneur", 90, 130, 65, 80, 85, 55,
                allTypes.getType("fighting"), null);

        this.ronflex = new Pokemon("Ronflex", 160, 110, 65, 65, 110, 30,
                allTypes.getType("normal"), null);

        this.carchacrok = new Pokemon("Carchacrok", 108, 130, 80, 95, 85, 102,
                allTypes.getType("dragon"), allTypes.getType("ground"));

        this.lucario = new Pokemon("Lucario", 70, 110, 115, 70, 70, 90,
                allTypes.getType("fighting"), allTypes.getType("steel"));
    }

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