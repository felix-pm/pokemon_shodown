package com.example.projet.Instanciation;

import com.example.projet.Attack;
import com.example.projet.AttackPhysical;
import com.example.projet.AttackSpecial;

public class AllAttack {

    private AllTypes allTypes;
    private AllEffects allEffects;

    // --- ATTACK DECLARATIONS ---

    // Pikachu
    private Attack thunderbolt;
    private Attack quickAttack;
    private Attack voltTackle;
    private Attack ironTail;

    // Gengar (Ectoplasma)
    private Attack shadowBall;
    private Attack sludgeBomb; // Shared with Venusaur
    private Attack lick;
    private Attack dreamEater;

    // Charizard (Dracaufeu)
    private Attack flamethrower;
    private Attack flareBlitz;
    private Attack wingAttack;
    private Attack fireBlast;

    // Venusaur (Florizarre)
    private Attack solarBeam;
    private Attack doubleEdge; // Shared with Snorlax
    private Attack razorLeaf;

    // Blastoise (Tortank)
    private Attack hydroPump;
    private Attack bite;
    private Attack waterGun;
    private Attack takeDown;

    // Alakazam
    private Attack psychic;
    private Attack psychoCut;
    private Attack firePunch;
    private Attack thunderPunch; // Shared with Lucario

    // Machamp (Mackogneur)
    private Attack crossChop;
    private Attack submission;
    private Attack poisonJab; // Shared with Garchomp
    private Attack karateChop;

    // Snorlax (Ronflex)
    private Attack bodySlam;
    private Attack earthquake; // Shared with Garchomp
    private Attack hyperBeam;

    // Garchomp (Carchacrok)
    private Attack dragonClaw;
    private Attack fireFang;

    // Lucario
    private Attack auraSphere;
    private Attack closeCombat;
    private Attack bulletPunch;

    public AllAttack(AllTypes types, AllEffects effects) {
        this.allTypes = types;
        this.allEffects = effects;


        // Pikachu
        this.thunderbolt = new AttackSpecial("Thunderbolt",
                90, allTypes.getType("electric"),
                allEffects.getEffect("paralysis"));
        this.quickAttack = new AttackPhysical("Quick Attack",
                40, allTypes.getType("normal"), null);
        this.voltTackle = new AttackPhysical("Volt Tackle",
                120, allTypes.getType("electric"),
                allEffects.getEffect("damocles"));
        this.ironTail = new AttackPhysical("Iron Tail",
                100, allTypes.getType("steel"),
                null);

        // Gengar
        this.shadowBall = new AttackSpecial("Shadow Ball",
                80, allTypes.getType("ghost"), null);
        this.sludgeBomb = new AttackSpecial("Sludge Bomb",
                90, allTypes.getType("poison"),
                allEffects.getEffect("poison"));
        this.lick = new AttackPhysical("Lick",
                30, allTypes.getType("ghost"),
                allEffects.getEffect("paralysis"));
        this.dreamEater = new AttackSpecial("Dream Eater",
                100, allTypes.getType("ghost"), null);

        // Charizard
        this.flamethrower = new AttackSpecial("Flamethrower",
                90, allTypes.getType("fire"),
                allEffects.getEffect("burn"));
        this.flareBlitz = new AttackPhysical("Flare Blitz",
                120, allTypes.getType("fire"),
                allEffects.getEffect("damocles"));
        this.wingAttack = new AttackPhysical("Wing Attack",
                60, allTypes.getType("flying"), null);
        this.fireBlast = new AttackSpecial("Fire Blast",
                110, allTypes.getType("fire"),
                allEffects.getEffect("burn"));

        // Venusaur
        this.solarBeam = new AttackSpecial("Solar Beam",
                120, allTypes.getType("grass"), null);
        this.doubleEdge = new AttackPhysical("Double-Edge",
                120, allTypes.getType("normal"), allEffects.getEffect("damocles"));
        this.razorLeaf = new AttackPhysical("Razor Leaf",
                55, allTypes.getType("grass"), null);

        // Blastoise
        this.hydroPump = new AttackSpecial("Hydro Pump",
                110, allTypes.getType("water"), null);
        this.bite = new AttackPhysical("Bite", 60,
                allTypes.getType("dark"), null);
        this.waterGun = new AttackSpecial("Water Gun",
                40, allTypes.getType("water"), null);
        this.takeDown = new AttackPhysical("Take Down",
                90, allTypes.getType("normal"),
                allEffects.getEffect("damocles"));

        // Alakazam
        this.psychic = new AttackSpecial("Psychic",
                90, allTypes.getType("psychic"), null);
        this.psychoCut = new AttackPhysical("Psycho Cut",
                70, allTypes.getType("psychic"), null);
        this.firePunch = new AttackPhysical("Fire Punch",
                75, allTypes.getType("fire"),
                allEffects.getEffect("burn"));
        this.thunderPunch = new AttackPhysical("Thunder Punch",
                75, allTypes.getType("electric"),
                allEffects.getEffect("paralysis"));

        // Machamp
        this.crossChop = new AttackPhysical("Cross Chop",
                100, allTypes.getType("fighting"), null);
        this.submission = new AttackPhysical("Submission",
                80, allTypes.getType("fighting"),
                allEffects.getEffect("damocles"));
        this.poisonJab = new AttackPhysical("Poison Jab",
                80, allTypes.getType("poison"),
                allEffects.getEffect("poison"));
        this.karateChop = new AttackPhysical("Karate Chop",
                50, allTypes.getType("fighting"), null);

        // Snorlax
        this.bodySlam = new AttackPhysical("Body Slam",
                85, allTypes.getType("normal"),
                allEffects.getEffect("paralysis"));
        this.earthquake = new AttackPhysical("Earthquake",
                100, allTypes.getType("ground"), null);
        this.hyperBeam = new AttackSpecial("Hyper Beam",
                150, allTypes.getType("normal"), null);

        // Garchomp
        this.dragonClaw = new AttackPhysical("Dragon Claw",
                80, allTypes.getType("dragon"), null);
        this.fireFang = new AttackPhysical("Fire Fang",
                65, allTypes.getType("fire"),
                allEffects.getEffect("burn"));

        // Lucario
        this.auraSphere = new AttackSpecial("Aura Sphere",
                80, allTypes.getType("fighting"), null);
        this.closeCombat = new AttackPhysical("Close Combat",
                120, allTypes.getType("fighting"), null);
        this.bulletPunch = new AttackPhysical("Bullet Punch",
                40, allTypes.getType("steel"), null);
    }

    public Attack getAttack(String attackName) {
        switch (attackName.toLowerCase()) {
            case "thunderbolt": return this.thunderbolt;
            case "quick attack": return this.quickAttack;
            case "volt tackle": return this.voltTackle;
            case "iron tail": return this.ironTail;

            case "shadow ball": return this.shadowBall;
            case "sludge bomb": return this.sludgeBomb;
            case "lick": return this.lick;
            case "dream eater": return this.dreamEater;

            case "flamethrower": return this.flamethrower;
            case "flare blitz": return this.flareBlitz;
            case "wing attack": return this.wingAttack;
            case "fire blast": return this.fireBlast;

            case "solar beam": return this.solarBeam;
            case "double-edge": return this.doubleEdge;
            case "razor leaf": return this.razorLeaf;

            case "hydro pump": return this.hydroPump;
            case "bite": return this.bite;
            case "water gun": return this.waterGun;
            case "take down": return this.takeDown;

            case "psychic": return this.psychic;
            case "psycho cut": return this.psychoCut;
            case "fire punch": return this.firePunch;
            case "thunder punch": return this.thunderPunch;

            case "cross chop": return this.crossChop;
            case "submission": return this.submission;
            case "poison jab": return this.poisonJab;
            case "karate chop": return this.karateChop;

            case "body slam": return this.bodySlam;
            case "earthquake": return this.earthquake;
            case "hyper beam": return this.hyperBeam;

            case "dragon claw": return this.dragonClaw;
            case "fire fang": return this.fireFang;

            case "aura sphere": return this.auraSphere;
            case "close combat": return this.closeCombat;
            case "bullet punch": return this.bulletPunch;

            default:
                System.out.println("Error: The attack '" + attackName + "' does not exist!");
                return null;
        }
    }
}