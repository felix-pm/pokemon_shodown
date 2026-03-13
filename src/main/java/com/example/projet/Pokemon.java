package com.example.projet;

public class Pokemon {
    private String name;
    private int hp;
    private int attack;
    private int specialAttack;
    private int defense;
    private int specialDefense;
    private int speed;
    private String type1;
    private String type2;
    public Pokemon(String name, int hp, int attack, int specialAttack,
                   int defense, int specialDefense, int speed,
                   String type1, String type2){
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.specialAttack = specialAttack;
        this.defense = defense;
        this.specialDefense = specialDefense;
        this.speed = speed;
        this.type1 = type1;
        this.type2 = type2;
    }

    public String toString(){
        return "Name: " + this.name + "\n" +
                "Hp: " + this.hp + "\n" +
                "Attack: " + this.attack + "\n" +
                "Special Attack: " + this.specialAttack + "\n" +
                "Defense: " + this.defense + "\n" +
                "Special Defense: " + this.specialDefense + "\n" +
                "Speed: " + this.speed + "\n" +
                "Type 1: " + this.type1 + "\n" +
                "Type 2: " + this.type2;
    }
}
