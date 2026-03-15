package com.example.projet;

import com.example.projet.Instanciation.AllPokemons;

public class Team {
    private AllPokemons allPokemons;
    private Pokemon[] pokemonTeam;
    private int pokemonAlive;
    public Team(AllPokemons pokemons){
        this.allPokemons = pokemons;
        this.pokemonTeam = new Pokemon[6];
        this.pokemonAlive = pokemonTeam.length;
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
        if(pokemonAlive > 0){
            return true;
        }
        return false;
    }

    public int getPokemonAlive() {
        return pokemonAlive;
    }

    public void setPokemonAlive(int pokemonAlive) {
        this.pokemonAlive = pokemonAlive;
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
}
