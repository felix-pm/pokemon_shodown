package com.example.projet;

import com.example.projet.Instanciation.AllPokemons;
import java.util.ArrayList;

public class Team {
    private AllPokemons allPokemons;
    private Pokemon[] pokemonTeam;
    private ArrayList<Item> inventory;
    public Team(AllPokemons pokemons){
        this.allPokemons = pokemons;
        this.pokemonTeam = new Pokemon[6];
        this.inventory = new ArrayList<>();
        this.inventory.add(new Potion(50));
        this.inventory.add(new Potion(50));
        this.inventory.add(new Antidote());
        this.inventory.add(new Rappel());
        this.inventory.add(new TotalSoin());
    }

    public void addInTeam(Pokemon pokemon){
        for (int i = 0; i < this.pokemonTeam.length; i++) {
            if (this.pokemonTeam[i] == null) {
                this.pokemonTeam[i] = pokemon;
                System.out.println("Pokemon ajouté avec succès !");
                return;
            }
        }
        System.out.println("L'équipe est déjà pleine !");
    }

    public boolean teamAlive(){
        int numberPokemon = this.getSize();
        for(int i = 0; i < this.getSize(); i++){
            if(this.getPokemonTeam()[i].getIsAlive() == false){
                numberPokemon -= 1;
            }
        }
        if(numberPokemon == 0){
            return false;
        }
        return true;
    }

    public Pokemon[] getPokemonTeam() {
        return pokemonTeam;
    }

    public void setPokemonTeam(Pokemon[] pokemonTeam) {
        this.pokemonTeam = pokemonTeam;
    }

    public String printTeam(){
        String presentation = "";
        for(int i = 0; i < this.pokemonTeam.length; i++){
            if (this.pokemonTeam[i] != null) {
                presentation += this.pokemonTeam[i].toString() + "\n\n";
            }
        }
        return presentation;
    }

    public int getSize() {
        int count = 0;
        for (int i = 0; i < this.pokemonTeam.length; i++) {
            if (this.pokemonTeam[i] != null) {
                count++;
            }
        }
        return count;
    }

    public Pokemon getFirstAlive(){
        for(int i = 0; i < this.getSize(); i++){
            if(this.getPokemonTeam()[i] != null &&
                    this.getPokemonTeam()[i].getIsAlive() &&
                    this.getPokemonTeam()[i].getHp() > 0){
                return this.getPokemonTeam()[i];
            }
        }
        return null;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

}
