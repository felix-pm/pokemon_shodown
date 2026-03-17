package com.example.projet;

public class gameplayController {

    // créer les variables

    public gameplayController(){
        // faire le constructeur si besoin ou un initialize()
    }

    // j'ai mis une méthode de random entre deux nombres pour créer le bot en face en utilisant du random
    // pour les pokemon, les attaques etc,... ou sinon plus tard si on a le temps on verra pour mettre une IA
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }


//    private Team createTeamIa(){
//
//    }
//
//    private Attack chooseAttackIa(){
//
//    }
//
//    private Pokemon choosePokemonIa(){
//
//    }
}
