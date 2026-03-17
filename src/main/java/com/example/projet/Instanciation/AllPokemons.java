package com.example.projet.Instanciation;

import com.example.projet.Pokemon;

public class AllPokemons {

    private AllTypes allTypes;
    private AllAttack allAttack;

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

        // --- 1. PIKACHU (HP: 35 -> 175) ---
        this.pikachu = new Pokemon("Pikachu", 175, 55,
                50, 40, 50, 90,
                allTypes.getType("electric"), null);
        this.pikachu.addPossibleAttack(allAttack.getAttack("thunderbolt"));
        this.pikachu.addPossibleAttack(allAttack.getAttack("quick attack"));
        this.pikachu.addPossibleAttack(allAttack.getAttack("volt tackle"));
        this.pikachu.addPossibleAttack(allAttack.getAttack("iron tail"));

        // --- 2. ECTOPLASMA (HP: 60 -> 300) ---
        this.ectoplasma = new Pokemon("Ectoplasma", 300, 65,
                130, 60, 75, 110,
                allTypes.getType("ghost"), allTypes.getType("poison"));
        this.ectoplasma.addPossibleAttack(allAttack.getAttack("shadow ball"));
        this.ectoplasma.addPossibleAttack(allAttack.getAttack("sludge bomb"));
        this.ectoplasma.addPossibleAttack(allAttack.getAttack("lick"));
        this.ectoplasma.addPossibleAttack(allAttack.getAttack("dream eater"));

        // --- 3. DRACAUFEU (HP: 78 -> 390) ---
        this.dracaufeu = new Pokemon("Dracaufeu", 390, 84,
                109, 78, 85, 100,
                allTypes.getType("fire"), allTypes.getType("flying"));
        this.dracaufeu.addPossibleAttack(allAttack.getAttack("flamethrower"));
        this.dracaufeu.addPossibleAttack(allAttack.getAttack("flare blitz"));
        this.dracaufeu.addPossibleAttack(allAttack.getAttack("wing attack"));
        this.dracaufeu.addPossibleAttack(allAttack.getAttack("fire blast"));

        // --- 4. FLORIZARRE (HP: 80 -> 400) ---
        this.florizarre = new Pokemon("Florizarre", 400, 82,
                100, 83, 100, 80,
                allTypes.getType("grass"), allTypes.getType("poison"));
        this.florizarre.addPossibleAttack(allAttack.getAttack("solar beam"));
        this.florizarre.addPossibleAttack(allAttack.getAttack("double-edge"));
        this.florizarre.addPossibleAttack(allAttack.getAttack("razor leaf"));
        this.florizarre.addPossibleAttack(allAttack.getAttack("sludge bomb"));

        // --- 5. TORTANK (HP: 79 -> 395) ---
        this.tortank = new Pokemon("Tortank", 395, 83,
                85, 100, 105, 78,
                allTypes.getType("water"), null);
        this.tortank.addPossibleAttack(allAttack.getAttack("hydro pump"));
        this.tortank.addPossibleAttack(allAttack.getAttack("bite"));
        this.tortank.addPossibleAttack(allAttack.getAttack("water gun"));
        this.tortank.addPossibleAttack(allAttack.getAttack("take down"));

        // --- 6. ALAKAZAM (HP: 55 -> 275) ---
        this.alakazam = new Pokemon("Alakazam", 275, 50,
                135, 45, 95, 120,
                allTypes.getType("psychic"), null);
        this.alakazam.addPossibleAttack(allAttack.getAttack("psychic"));
        this.alakazam.addPossibleAttack(allAttack.getAttack("psycho cut"));
        this.alakazam.addPossibleAttack(allAttack.getAttack("fire punch"));
        this.alakazam.addPossibleAttack(allAttack.getAttack("thunder punch"));

        // --- 7. MACKOGNEUR (HP: 90 -> 450) ---
        this.mackogneur = new Pokemon("Mackogneur", 450, 130,
                65, 80, 85, 55,
                allTypes.getType("fighting"), null);
        this.mackogneur.addPossibleAttack(allAttack.getAttack("cross chop"));
        this.mackogneur.addPossibleAttack(allAttack.getAttack("submission"));
        this.mackogneur.addPossibleAttack(allAttack.getAttack("poison jab"));
        this.mackogneur.addPossibleAttack(allAttack.getAttack("karate chop"));

        // --- 8. RONFLEX (HP: 160 -> 800) ---
        this.ronflex = new Pokemon("Ronflex", 800, 110,
                65, 65, 110, 30,
                allTypes.getType("normal"), null);
        this.ronflex.addPossibleAttack(allAttack.getAttack("body slam"));
        this.ronflex.addPossibleAttack(allAttack.getAttack("earthquake"));
        this.ronflex.addPossibleAttack(allAttack.getAttack("hyper beam"));
        this.ronflex.addPossibleAttack(allAttack.getAttack("double-edge"));

        // --- 9. CARCHACROK (HP: 108 -> 540) ---
        this.carchacrok = new Pokemon("Carchacrok", 540, 130,
                80, 95, 85, 102,
                allTypes.getType("dragon"), allTypes.getType("ground"));
        this.carchacrok.addPossibleAttack(allAttack.getAttack("dragon claw"));
        this.carchacrok.addPossibleAttack(allAttack.getAttack("fire fang"));
        this.carchacrok.addPossibleAttack(allAttack.getAttack("earthquake"));
        this.carchacrok.addPossibleAttack(allAttack.getAttack("poison jab"));

        // --- 10. LUCARIO (HP: 70 -> 350) ---
        this.lucario = new Pokemon("Lucario", 350, 110,
                115, 70, 70, 90,
                allTypes.getType("fighting"), allTypes.getType("steel"));
        this.lucario.addPossibleAttack(allAttack.getAttack("aura sphere"));
        this.lucario.addPossibleAttack(allAttack.getAttack("close combat"));
        this.lucario.addPossibleAttack(allAttack.getAttack("bullet punch"));
        this.lucario.addPossibleAttack(allAttack.getAttack("thunder punch"));
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