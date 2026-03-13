package com.example.projet;

public class AllTypes {
    private Type normal = new Type("normal");
    private Type fire = new Type("fire");
    private Type water = new Type("water");
    private Type grass = new Type("grass");
    private Type electric = new Type("electric");
    private Type ice = new Type("ice");
    private Type fighting = new Type("fighting");
    private Type poison = new Type("poison");
    private Type ground = new Type("ground");
    private Type flying = new Type("fying");
    private Type psychic = new Type("psychic");
    private Type bug = new Type("bug");
    private Type rock = new Type("rock");
    private Type ghost = new Type("ghost");
    private Type dragon = new Type("dragon");
    private Type dark = new Type("dark");
    private Type steel = new Type("steel");
    private Type fairy = new Type("fairy");

    public AllTypes(){
        createEfficiency();
    }
    //instantiation of types

    public void createEfficiency(){
        // --- NORMAL ---
        this.normal.addEfficiency(this.rock, 0.5);
        this.normal.addEfficiency(this.ghost, 0.0);
        this.normal.addEfficiency(this.steel, 0.5);

        // --- FIRE ---
        this.fire.addEfficiency(this.fire, 0.5);
        this.fire.addEfficiency(this.water, 0.5);
        this.fire.addEfficiency(this.grass, 2.0);
        this.fire.addEfficiency(this.ice, 2.0);
        this.fire.addEfficiency(this.bug, 2.0);
        this.fire.addEfficiency(this.rock, 0.5);
        this.fire.addEfficiency(this.dragon, 0.5);
        this.fire.addEfficiency(this.steel, 2.0);

        // --- WATER ---
        this.water.addEfficiency(this.fire, 2.0);
        this.water.addEfficiency(this.water, 0.5);
        this.water.addEfficiency(this.grass, 0.5);
        this.water.addEfficiency(this.ground, 2.0);
        this.water.addEfficiency(this.rock, 2.0);
        this.water.addEfficiency(this.dragon, 0.5);

        // --- GRASS ---
        this.grass.addEfficiency(this.fire, 0.5);
        this.grass.addEfficiency(this.water, 2.0);
        this.grass.addEfficiency(this.grass, 0.5);
        this.grass.addEfficiency(this.poison, 0.5);
        this.grass.addEfficiency(this.ground, 2.0);
        this.grass.addEfficiency(this.flying, 0.5);
        this.grass.addEfficiency(this.bug, 0.5);
        this.grass.addEfficiency(this.rock, 2.0);
        this.grass.addEfficiency(this.dragon, 0.5);
        this.grass.addEfficiency(this.steel, 0.5);

        // --- ELECTRIC ---
        this.electric.addEfficiency(this.water, 2.0);
        this.electric.addEfficiency(this.grass, 0.5);
        this.electric.addEfficiency(this.electric, 0.5);
        this.electric.addEfficiency(this.ground, 0.0);
        this.electric.addEfficiency(this.flying, 2.0);
        this.electric.addEfficiency(this.dragon, 0.5);

        // --- ICE ---
        this.ice.addEfficiency(this.fire, 0.5);
        this.ice.addEfficiency(this.water, 0.5);
        this.ice.addEfficiency(this.grass, 2.0);
        this.ice.addEfficiency(this.ice, 0.5);
        this.ice.addEfficiency(this.ground, 2.0);
        this.ice.addEfficiency(this.flying, 2.0);
        this.ice.addEfficiency(this.dragon, 2.0);
        this.ice.addEfficiency(this.steel, 0.5);

        // --- FIGHTING ---
        this.fighting.addEfficiency(this.normal, 2.0);
        this.fighting.addEfficiency(this.ice, 2.0);
        this.fighting.addEfficiency(this.poison, 0.5);
        this.fighting.addEfficiency(this.flying, 0.5);
        this.fighting.addEfficiency(this.psychic, 0.5);
        this.fighting.addEfficiency(this.bug, 0.5);
        this.fighting.addEfficiency(this.rock, 2.0);
        this.fighting.addEfficiency(this.ghost, 0.0);
        this.fighting.addEfficiency(this.dark, 2.0);
        this.fighting.addEfficiency(this.steel, 2.0);
        this.fighting.addEfficiency(this.fairy, 0.5);

        // --- POISON ---
        this.poison.addEfficiency(this.grass, 2.0);
        this.poison.addEfficiency(this.poison, 0.5);
        this.poison.addEfficiency(this.ground, 0.5);
        this.poison.addEfficiency(this.rock, 0.5);
        this.poison.addEfficiency(this.ghost, 0.5);
        this.poison.addEfficiency(this.steel, 0.0);
        this.poison.addEfficiency(this.fairy, 2.0);

        // --- GROUND ---
        this.ground.addEfficiency(this.fire, 2.0);
        this.ground.addEfficiency(this.grass, 0.5);
        this.ground.addEfficiency(this.electric, 2.0);
        this.ground.addEfficiency(this.poison, 2.0);
        this.ground.addEfficiency(this.flying, 0.0);
        this.ground.addEfficiency(this.bug, 0.5);
        this.ground.addEfficiency(this.rock, 2.0);
        this.ground.addEfficiency(this.steel, 2.0);

        // --- FLYING ---
        this.flying.addEfficiency(this.grass, 2.0);
        this.flying.addEfficiency(this.electric, 0.5);
        this.flying.addEfficiency(this.fighting, 2.0);
        this.flying.addEfficiency(this.bug, 2.0);
        this.flying.addEfficiency(this.rock, 0.5);
        this.flying.addEfficiency(this.steel, 0.5);

        // --- PSYCHIC ---
        this.psychic.addEfficiency(this.fighting, 2.0);
        this.psychic.addEfficiency(this.poison, 2.0);
        this.psychic.addEfficiency(this.psychic, 0.5);
        this.psychic.addEfficiency(this.dark, 0.0);
        this.psychic.addEfficiency(this.steel, 0.5);

        // --- BUG ---
        this.bug.addEfficiency(this.fire, 0.5);
        this.bug.addEfficiency(this.grass, 2.0);
        this.bug.addEfficiency(this.fighting, 0.5);
        this.bug.addEfficiency(this.poison, 0.5);
        this.bug.addEfficiency(this.flying, 0.5);
        this.bug.addEfficiency(this.psychic, 2.0);
        this.bug.addEfficiency(this.ghost, 0.5);
        this.bug.addEfficiency(this.dark, 2.0);
        this.bug.addEfficiency(this.steel, 0.5);
        this.bug.addEfficiency(this.fairy, 0.5);

        // --- ROCK ---
        this.rock.addEfficiency(this.fire, 2.0);
        this.rock.addEfficiency(this.ice, 2.0);
        this.rock.addEfficiency(this.fighting, 0.5);
        this.rock.addEfficiency(this.ground, 0.5);
        this.rock.addEfficiency(this.flying, 2.0);
        this.rock.addEfficiency(this.bug, 2.0);
        this.rock.addEfficiency(this.steel, 0.5);

        // --- GHOST ---
        this.ghost.addEfficiency(this.normal, 0.0);
        this.ghost.addEfficiency(this.psychic, 2.0);
        this.ghost.addEfficiency(this.ghost, 2.0);
        this.ghost.addEfficiency(this.dark, 0.5);

        // --- DRAGON ---
        this.dragon.addEfficiency(this.dragon, 2.0);
        this.dragon.addEfficiency(this.steel, 0.5);
        this.dragon.addEfficiency(this.fairy, 0.0);

        // --- DARK ---
        this.dark.addEfficiency(this.fighting, 0.5);
        this.dark.addEfficiency(this.psychic, 2.0);
        this.dark.addEfficiency(this.ghost, 2.0);
        this.dark.addEfficiency(this.dark, 0.5);
        this.dark.addEfficiency(this.fairy, 0.5);

        // --- STEEL ---
        this.steel.addEfficiency(this.fire, 0.5);
        this.steel.addEfficiency(this.water, 0.5);
        this.steel.addEfficiency(this.electric, 0.5);
        this.steel.addEfficiency(this.ice, 2.0);
        this.steel.addEfficiency(this.rock, 2.0);
        this.steel.addEfficiency(this.steel, 0.5);
        this.steel.addEfficiency(this.fairy, 2.0);

        // --- FAIRY ---
        this.fairy.addEfficiency(this.fire, 0.5);
        this.fairy.addEfficiency(this.fighting, 2.0);
        this.fairy.addEfficiency(this.poison, 0.5);
        this.fairy.addEfficiency(this.dragon, 2.0);
        this.fairy.addEfficiency(this.dark, 2.0);
        this.fairy.addEfficiency(this.steel, 0.5);
    }



}
