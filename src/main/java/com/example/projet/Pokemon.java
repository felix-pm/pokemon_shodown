package com.example.projet;


import java.util.ArrayList;

public class Pokemon {
    private String name;
    private boolean isAlive;
    private int hp;
    private int attack;
    private int specialAttack;
    private int defense;
    private int specialDefense;
    private int speed;
    private Type type1;
    private Type type2;
    // On passe un statut en paramètre par default null et a chaque tour on vérifie si un effet s'est trigger et si oui
    // on utilise la methode applyEffect.
    private Effects statut;
    private ArrayList<Attack> possibleAttacks;
    private ArrayList<Attack> listAttack;
    private boolean actif;
    //private Object object;
    public Pokemon(String name, int hp, int attack, int specialAttack,
                   int defense, int specialDefense, int speed,
                   Type type1, Type type2, ArrayList<Attack> listAttack){
        this.name = name;
        this.isAlive = true;
        this.hp = hp;
        this.attack = attack;
        this.specialAttack = specialAttack;
        this.defense = defense;
        this.specialDefense = specialDefense;
        this.speed = speed;
        this.type1 = type1;
        this.type2 = type2;
        this.listAttack = listAttack;
        //this.object = new Object();
        this.possibleAttacks = new ArrayList<>();
        this.statut = null;
        this.actif = false;
    }

    public Pokemon(String name, int hp, int attack, int specialAttack,
                   int defense, int specialDefense, int speed,
                   Type type1, Type type2){
        this.name = name;
        this.isAlive = true;
        this.hp = hp;
        this.attack = attack;
        this.specialAttack = specialAttack;
        this.defense = defense;
        this.specialDefense = specialDefense;
        this.speed = speed;
        this.type1 = type1;
        this.type2 = type2;
        this.listAttack = new ArrayList<Attack>();
        //this.object = new Object();
        this.possibleAttacks = new ArrayList<>();
        this.statut = null;
        this.actif = false;
    }

    public void addPossibleAttack(Attack attack) {
        this.possibleAttacks.add(attack);
    }

    public ArrayList<Attack> getPossibleAttacks() {
        return possibleAttacks;
    }

    public void setPossibleAttacks(ArrayList<Attack> possibleAttacks) {
        this.possibleAttacks = possibleAttacks;
    }

    public Pokemon copy() {
        Pokemon p = new Pokemon(this.name, this.hp, this.attack, this.specialAttack,
                this.defense, this.specialDefense, this.speed,
                this.type1, this.type2);
        p.setPossibleAttacks(new ArrayList<>(this.possibleAttacks)); // Copie les attaques possibles
        return p;
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

    public void addAttack(Attack attack){
        this.listAttack.add(attack);
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if(hp < 0){
            System.out.println("Pokemon ko");
            this.hp = 0;
            this.isAlive = false;
        } else {
            this.hp = hp;
        }
    }

    public Pokemon checkSpeed(Pokemon enemy){
        if(this.speed > enemy.getSpeed()){
            return this;
        } else {
            return enemy;
        }
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Type getType1() {
        return type1;
    }

    public void setType1(Type type1) {
        this.type1 = type1;
    }

    public Type getType2() {
        return type2;
    }

    public void setType2(Type type2) {
        this.type2 = type2;
    }

    public Effects getStatut(){
        return this.statut;
    }

    public void setStatut(Effects statut){
        this.statut = statut;
    }

    public ArrayList<Attack> getListAttack() {
        return listAttack;
    }

    public void setListAttack(ArrayList<Attack> listAttack) {
        this.listAttack = listAttack;
    }

    public void ChooseAttack(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }
}
