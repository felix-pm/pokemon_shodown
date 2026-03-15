package com.example.projet.Instanciation;

import com.example.projet.Attack;
import com.example.projet.AttackPhysical;
import com.example.projet.AttackSpecial;

public class AllAttack {

    private AllTypes allTypes;
    private AllEffects allEffects;

    private AttackSpecial tonnerre;
    private AttackPhysical viveAttaque;
    private AttackPhysical queueDeFer;
    private AttackSpecial fatalFoudre;
    private AttackSpecial lanceFlammes;
    private AttackPhysical dracogriffe;
    private AttackPhysical vol;
    private AttackSpecial deflagration;
    private AttackSpecial lanceSoleil;
    private AttackSpecial bombeBeurk;
    private AttackSpecial hydrocanon;
    private AttackSpecial surf;
    private AttackSpecial laserGlace;
    private AttackPhysical tourRapide;
    private AttackSpecial frappePsy;
    private AttackSpecial ballOmbre;
    private AttackSpecial aurasphere;
    private AttackSpecial meteores;
    private AttackPhysical morsure;
    private AttackPhysical plaquage;
    private AttackPhysical seisme;
    private AttackPhysical machouille;
    private AttackPhysical colere;
    private AttackPhysical vitesseExtreme;
    private AttackPhysical poingFeu;
    private AttackPhysical damocles;

    public AllAttack(AllTypes types, AllEffects effects) {
        this.allTypes = types;
        this.allEffects = effects;

        this.tonnerre = new AttackSpecial("Tonnerre", 90, allTypes.getType("electric"));
        this.viveAttaque = new AttackPhysical("Vive-Attaque", 40, allTypes.getType("normal"));
        this.queueDeFer = new AttackPhysical("Queue de Fer", 100, allTypes.getType("steel"));
        this.fatalFoudre = new AttackSpecial("Fatal-Foudre", 110, allTypes.getType("electric"));
        this.lanceFlammes = new AttackSpecial("Lance-Flammes", 90, allTypes.getType("fire"));
        this.dracogriffe = new AttackPhysical("Dracogriffe", 80, allTypes.getType("dragon"));
        this.vol = new AttackPhysical("Vol", 90, allTypes.getType("flying"));
        this.deflagration = new AttackSpecial("Déflagration", 110, allTypes.getType("fire"));
        this.lanceSoleil = new AttackSpecial("Lance-Soleil", 120, allTypes.getType("grass"));
        this.bombeBeurk = new AttackSpecial("Bombe Beurk", 90, allTypes.getType("poison"));
        this.hydrocanon = new AttackSpecial("Hydrocanon", 110, allTypes.getType("water"));
        this.surf = new AttackSpecial("Surf", 90, allTypes.getType("water"));
        this.laserGlace = new AttackSpecial("Laser Glace", 90, allTypes.getType("ice"));
        this.tourRapide = new AttackPhysical("Tour Rapide", 50, allTypes.getType("normal"));
        this.frappePsy = new AttackSpecial("Frappe Psy", 100, allTypes.getType("psychic"));
        this.ballOmbre = new AttackSpecial("Ball'Ombre", 80, allTypes.getType("ghost"));
        this.aurasphere = new AttackSpecial("Aurasphère", 80, allTypes.getType("fighting"));
        this.meteores = new AttackSpecial("Météores", 60, allTypes.getType("normal"));
        this.morsure = new AttackPhysical("Morsure", 60, allTypes.getType("dark"));
        this.plaquage = new AttackPhysical("Plaquage", 85, allTypes.getType("normal"));
        this.seisme = new AttackPhysical("Séisme", 100, allTypes.getType("ground"));
        this.machouille = new AttackPhysical("Mâchouille", 80, allTypes.getType("dark"));
        this.colere = new AttackPhysical("Colère", 120, allTypes.getType("dragon"));
        this.vitesseExtreme = new AttackPhysical("Vitesse Extrême", 80, allTypes.getType("normal"));
        this.poingFeu = new AttackPhysical("Poing Feu", 75, allTypes.getType("fire"));
        this.damocles = new AttackPhysical("Damocles", 120, allTypes.getType("normal"),
                allEffects.getEffect("damocles"));
    }

    public Attack getAttack(String nomDeLattaque) {
        switch (nomDeLattaque.toLowerCase()) {
            case "tonnerre": return this.tonnerre;
            case "vive-attaque": return this.viveAttaque;
            case "queue de fer": return this.queueDeFer;
            case "fatal-foudre": return this.fatalFoudre;
            case "lance-flammes": return this.lanceFlammes;
            case "dracogriffe": return this.dracogriffe;
            case "vol": return this.vol;
            case "déflagration": return this.deflagration;
            case "lance-soleil": return this.lanceSoleil;
            case "bombe beurk": return this.bombeBeurk;
            case "hydrocanon": return this.hydrocanon;
            case "surf": return this.surf;
            case "laser glace": return this.laserGlace;
            case "tour rapide": return this.tourRapide;
            case "frappe psy": return this.frappePsy;
            case "ball'ombre": return this.ballOmbre;
            case "aurasphère": return this.aurasphere;
            case "météores": return this.meteores;
            case "morsure": return this.morsure;
            case "plaquage": return this.plaquage;
            case "séisme": return this.seisme;
            case "mâchouille": return this.machouille;
            case "colère": return this.colere;
            case "vitesse extrême": return this.vitesseExtreme;
            case "poing feu": return this.poingFeu;
            case "damocles": return this.damocles;

            default:
                System.out.println("Erreur : L'attaque " + nomDeLattaque + " n'existe pas !");
                return null;
        }
    }
}