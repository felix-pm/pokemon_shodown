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
        this.pokemonTeam[this.pokemonTeam.length] = pokemon;
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

}
