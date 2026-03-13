package com.example.projet;

import java.util.ArrayList;

public class Pokemon {
    private String name;
    private int hp;
    private int attack;
    private int specialAttack;
    private int defense;
    private int specialDefense;
    private int speed;
    private Type type1;
    private Type type2;
    //private ArrayList<Attack> listAttack;
    //private Object object;
    public Pokemon(String name, int hp, int attack, int specialAttack,
                   int defense, int specialDefense, int speed,
                   Type type1, Type type2){
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.specialAttack = specialAttack;
        this.defense = defense;
        this.specialDefense = specialDefense;
        this.speed = speed;
        this.type1 = type1;
        this.type2 = type2;
        //this.listAttack = new ArrayList<Attack>();
        //this.object = new Object();
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

    public void ChooseAttack(){}
}
