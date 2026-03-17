package com.example.projet;

import com.example.projet.Instanciation.AllPokemons;

public class Gameloop {
    private Team team1;
    private Team team2;
    private AllPokemons allPokemons;

    public Gameloop(AllPokemons pokemons){
        this.allPokemons = pokemons;
        this.team1 = new Team(this.allPokemons);
        this.team2 = new Team(this.allPokemons);

        this.team1.addInTeam(pokemons.getPokemon("pikachu"));
        this.team1.addInTeam(pokemons.getPokemon("ectoplasma"));
        this.team1.addInTeam(pokemons.getPokemon("pikachu"));

        this.team2.addInTeam(pokemons.getPokemon("florizarre"));
        this.team2.addInTeam(pokemons.getPokemon("tortank"));
        this.team2.addInTeam(pokemons.getPokemon("pikachu"));
        this.team2.addInTeam(pokemons.getPokemon("pikachu"));
        this.team2.addInTeam(pokemons.getPokemon("mackogneur"));
        this.team2.addInTeam(pokemons.getPokemon("alakazam"));
        this.team2.addInTeam(pokemons.getPokemon("lucario"));

        System.out.println(this.team1.printTeam());
        System.out.println(this.team2.printTeam());

        Pokemon pokemon1 = this.team1.getPokemonTeam()[0];
        Pokemon pokemon2 = this.team1.getPokemonTeam()[0];

        Attack attack = pokemon1.getListAttack().get(0);
        System.out.println(pokemon2.toString());
        attack.attacking(pokemon1, pokemon2);
        System.out.println(pokemon2.toString());
    }

    public void launchLoop(){

        if(team1.teamAlive() == false || team2.teamAlive() == false){
            // arrêt de jeu
        }
    }

}