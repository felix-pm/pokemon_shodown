package com.example.projet;

import com.example.projet.Instanciation.AllPokemons;
import java.util.Random;

public class Gameloop {
    private Team playerTeam;
    private Team enemyTeam;
    private Pokemon activePlayerPokemon;
    private Pokemon activeEnemyPokemon;
    private int currentTurn;
    private boolean isGameOver;

    public Gameloop(Team playerTeam, AllPokemons catalogue) {
        this.playerTeam = playerTeam;
        this.enemyTeam = createEnemyTeam(catalogue);
        this.activePlayerPokemon = getFirstAlive(this.playerTeam);
        this.activeEnemyPokemon = getFirstAlive(this.enemyTeam);
        this.currentTurn = 1;
        this.isGameOver = false;
    }

    private Team createEnemyTeam(AllPokemons catalogue) {
        Team team = new Team(catalogue);
        String[] allNames = {"Pikachu", "Ectoplasma", "Dracaufeu", "Florizarre", "Tortank", "Alakazam", "Mackogneur", "Ronflex", "Carchacrok", "Lucario"};
        Random rand = new Random();
        int teamSize = rand.nextInt(4) + 3; // 3 à 6 Pokémon

        for (int i = 0; i < teamSize; i++) {
            Pokemon p = catalogue.getPokemon(allNames[rand.nextInt(allNames.length)]).copy();
            for (Attack atk : p.getPossibleAttacks()) {
                if (p.getListAttack().size() < 4) p.addAttack(atk);
            }
            team.addInTeam(p);
        }
        return team;
    }

    public Pokemon getFirstAlive(Team team) {
        for (Pokemon p : team.getPokemonTeam()) {
            if (p != null && p.getIsAlive() && p.getHp() > 0) return p;
        }
        return null;
    }

    public Attack getRandomEnemyAttack() {
        Random rand = new Random();
        return activeEnemyPokemon.getListAttack().get(rand.nextInt(activeEnemyPokemon.getListAttack().size()));
    }

    public boolean isPlayerFaster() {
        return activePlayerPokemon.getSpeed() >= activeEnemyPokemon.getSpeed();
    }

    public String performAttack(Pokemon attacker, Pokemon target, Attack attack) {
        int oldHp = target.getHp();
        String log = attacker.getName() + " utilise " + attack.getName() + " !\n";

        attack.attacking(attacker, target); // Applique les dégâts (géré dans Attack)

        int damage = oldHp - target.getHp();
        log += target.getName() + " perd " + Math.max(0, damage) + " HP.\n";
        return log;
    }

    public String checkEnemyFaint() {
        if (!activeEnemyPokemon.getIsAlive() || activeEnemyPokemon.getHp() <= 0) {
            String log = activeEnemyPokemon.getName() + " adverse est KO !\n";
            activeEnemyPokemon = getFirstAlive(enemyTeam);
            if (activeEnemyPokemon != null) {
                log += "L'adversaire envoie " + activeEnemyPokemon.getName() + " !\n";
            } else {
                log += "\n⚔️ VICTOIRE ! L'équipe adverse est vaincue !\n";
                isGameOver = true;
            }
            return log;
        }
        return "";
    }

    public String checkPlayerFaint() {
        if (!activePlayerPokemon.getIsAlive() || activePlayerPokemon.getHp() <= 0) {
            String log = activePlayerPokemon.getName() + " est KO ! Choisissez un nouveau Pokémon.\n";
            if (getFirstAlive(playerTeam) == null) {
                log += "\n💀 DÉFAITE ! Vous n'avez plus de Pokémon en état de se battre !\n";
                isGameOver = true;
            }
            return log;
        }
        return "";
    }

    public void endTurn() {
        if (!isGameOver && getFirstAlive(playerTeam) != null && getFirstAlive(enemyTeam) != null) {
            currentTurn++;
        }
    }

    // --- Getters et Setters ---
    public Team getPlayerTeam() { return playerTeam; }
    public Team getEnemyTeam() { return enemyTeam; }
    public Pokemon getActivePlayerPokemon() { return activePlayerPokemon; }
    public void setActivePlayerPokemon(Pokemon p) { this.activePlayerPokemon = p; }
    public Pokemon getActiveEnemyPokemon() { return activeEnemyPokemon; }
    public int getCurrentTurn() { return currentTurn; }
    public boolean isGameOver() { return isGameOver; }
}