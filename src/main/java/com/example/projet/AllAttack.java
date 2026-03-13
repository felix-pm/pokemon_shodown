package com.example.projet;

public class AllAttack {

    private AllTypes all = new AllTypes();

    private AttackSpecial tonnerre = new AttackSpecial("Tonnerre", 90, all.getType("electric"));
    private AttackPhysical viveAttaque = new AttackPhysical("Vive-Attaque", 40, all.getType("normal"));
    private AttackPhysical queueDeFer = new AttackPhysical("Queue de Fer", 100, all.getType("steel"));
    private AttackSpecial fatalFoudre = new AttackSpecial("Fatal-Foudre", 110, all.getType("electric"));
    private AttackSpecial lanceFlammes = new AttackSpecial("Lance-Flammes", 90, all.getType("fire"));
    private AttackPhysical dracogriffe = new AttackPhysical("Dracogriffe", 80, all.getType("dragon"));
    private AttackPhysical vol = new AttackPhysical("Vol", 90, all.getType("flying"));
    private AttackSpecial deflagration = new AttackSpecial("Déflagration", 110, all.getType("fire"));
    private AttackSpecial lanceSoleil = new AttackSpecial("Lance-Soleil", 120, all.getType("grass"));
    private AttackSpecial bombeBeurk = new AttackSpecial("Bombe Beurk", 90, all.getType("poison"));
    private AttackSpecial hydrocanon = new AttackSpecial("Hydrocanon", 110, all.getType("water"));
    private AttackSpecial surf = new AttackSpecial("Surf", 90, all.getType("water"));
    private AttackSpecial laserGlace = new AttackSpecial("Laser Glace", 90, all.getType("ice"));
    private AttackPhysical tourRapide = new AttackPhysical("Tour Rapide", 50, all.getType("normal"));
    private AttackSpecial frappePsy = new AttackSpecial("Frappe Psy", 100, all.getType("psychic"));
    private AttackSpecial ballOmbre = new AttackSpecial("Ball'Ombre", 80, all.getType("ghost"));
    private AttackSpecial aurasphere = new AttackSpecial("Aurasphère", 80, all.getType("fighting"));
    private AttackSpecial meteores = new AttackSpecial("Météores", 60, all.getType("normal"));
    private AttackPhysical morsure = new AttackPhysical("Morsure", 60, all.getType("dark"));
    private AttackPhysical plaquage = new AttackPhysical("Plaquage", 85, all.getType("normal"));
    private AttackPhysical seisme = new AttackPhysical("Séisme", 100, all.getType("ground"));
    private AttackPhysical machouille = new AttackPhysical("Mâchouille", 80, all.getType("dark"));
    private AttackPhysical colere = new AttackPhysical("Colère", 120, all.getType("dragon"));
    private AttackPhysical vitesseExtreme = new AttackPhysical("Vitesse Extrême", 80, all.getType("normal"));
    private AttackPhysical poingFeu = new AttackPhysical("Poing Feu", 75, all.getType("fire"));

}