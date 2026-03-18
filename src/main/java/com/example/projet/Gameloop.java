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
        this.activePlayerPokemon = playerTeam.getFirstAlive();
        this.activeEnemyPokemon = enemyTeam.getFirstAlive();
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

        attack.attacking(attacker, target);

        int damage = oldHp - target.getHp();
        log += target.getName() + " perd " + Math.max(0, damage) + " HP.\n";
        return log;
    }

    public String checkEnemyFaint() {
        if (!activeEnemyPokemon.getIsAlive() || activeEnemyPokemon.getHp() <= 0) {
            String log = activeEnemyPokemon.getName() + " adverse est KO !\n";
            if (enemyTeam.teamAlive()) {
                activeEnemyPokemon = enemyTeam.getFirstAlive();
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
            if (!playerTeam.teamAlive()) {
                log += "\n💀 DÉFAITE ! Vous n'avez plus de Pokémon en état de se battre !\n";
                isGameOver = true;
            }
            return log;
        }
        return "";
    }

    public String endTurn() {
        StringBuilder statusLog = new StringBuilder();

        if (!isGameOver && playerTeam.getFirstAlive() != null && enemyTeam.getFirstAlive() != null) {

            if (activePlayerPokemon.getStatut() != null) {
                String logEffect = activePlayerPokemon.getStatut().applyEndOfTurn(activePlayerPokemon);
                if (!logEffect.isEmpty()) {
                    statusLog.append(logEffect).append("\n");
                }
            }

            if (activePlayerPokemon.getHeldItem() != null && activePlayerPokemon.getIsAlive()) {
                statusLog.append(activePlayerPokemon.getHeldItem().use(activePlayerPokemon)).append("\n");
            }

            if (activeEnemyPokemon.getStatut() != null && activeEnemyPokemon.getHp() > 0) {
                String logEffect = activeEnemyPokemon.getStatut().applyEndOfTurn(activeEnemyPokemon);
                if (!logEffect.isEmpty()) {
                    statusLog.append(logEffect).append("\n");
                }
            }

            if (activeEnemyPokemon.getHeldItem() != null && activeEnemyPokemon.getIsAlive()) {
                statusLog.append(activeEnemyPokemon.getHeldItem().use(activeEnemyPokemon)).append("\n");
            }

            currentTurn++;
        }
        return statusLog.toString();
    }

    public String useItemTurn(Item item, Pokemon target) {
        String log = "Vous utilisez " + item.getName() + " sur " + target.getName() + " !\n";
        log += item.use(target) + "\n";

        if (activeEnemyPokemon.getIsAlive() && activeEnemyPokemon.getHp() > 0) {
            Attack enemyAttack = getRandomEnemyAttack();
            log += "\n" + performAttack(activeEnemyPokemon, activePlayerPokemon, enemyAttack);
            log += checkPlayerFaint();
        }

        return log;
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