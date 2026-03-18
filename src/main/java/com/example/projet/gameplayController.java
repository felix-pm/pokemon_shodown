package com.example.projet;

import com.example.projet.Instanciation.AllAttack;
import com.example.projet.Instanciation.AllEffects;
import com.example.projet.Instanciation.AllPokemons;
import com.example.projet.Instanciation.AllTypes;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.util.Duration;
import javafx.scene.control.ComboBox;

import java.util.HashMap;
import java.util.Map;

public class gameplayController {

    @FXML private Label playerNameLabel;
    @FXML private ProgressBar playerHpBar;
    @FXML private Label playerHpLabel;
    @FXML private Label enemyNameLabel;
    @FXML private ProgressBar enemyHpBar;
    @FXML private Label enemyHpLabel;
    @FXML private Button atkBtn1, atkBtn2, atkBtn3, atkBtn4;
    @FXML private Button switchBtn1, switchBtn2, switchBtn3, switchBtn4, switchBtn5, switchBtn6;
    @FXML private TextArea battleLog;
    @FXML private Label turnLabel;
    @FXML private Label playerStatusLabel;
    @FXML private Label enemyStatusLabel;
    @FXML private ComboBox<String> inventoryCombo;
    @FXML private Button useItemBtn;

    private Button[] switchBtns;
    private Gameloop gameloop;
    private Map<Pokemon, Integer> maxHpMap = new HashMap<>();
    private boolean isAnimating = false;

    @FXML
    public void initialize() {
        switchBtns = new Button[]{switchBtn1, switchBtn2, switchBtn3, switchBtn4, switchBtn5, switchBtn6};

        AllTypes allTypes = new AllTypes();
        AllEffects allEffects = new AllEffects();
        AllAttack allAttacks = new AllAttack(allTypes, allEffects);
        AllPokemons catalogue = new AllPokemons(allTypes, allAttacks);

        Team playerTeam = CreateTeamController.getRealTeam();

        gameloop = new Gameloop(playerTeam, catalogue);

        for (Pokemon p : gameloop.getPlayerTeam().getPokemonTeam()) {
            if (p != null) maxHpMap.put(p, p.getHp());
        }
        for (Pokemon p : gameloop.getEnemyTeam().getPokemonTeam()) {
            if (p != null) maxHpMap.put(p, p.getHp());
        }

        if(gameloop.getActivePlayerPokemon() == null) return;

        updateInventoryUI();

        turnLabel.setText("Tour " + gameloop.getCurrentTurn());
        log("Le combat commence ! L'adversaire envoie " +
                gameloop.getActiveEnemyPokemon().getName() + " !");
        log("À toi de jouer, " + gameloop.getActivePlayerPokemon().getName() + " !");

        updateUI();
    }

    private void updateInventoryUI() {
        if (inventoryCombo != null) {
            inventoryCombo.getItems().clear();

            for (Item item : gameloop.getPlayerTeam().getInventory()) {
                inventoryCombo.getItems().add(item.getName() + " (" + item.getDescription() + ")");
            }

            if (gameloop.getPlayerTeam().getInventory().isEmpty()) {
                inventoryCombo.setPromptText("Sac vide");
                useItemBtn.setDisable(true);
                inventoryCombo.setDisable(true);
            }
        }
    }

    @FXML
    void onUseItem(ActionEvent event) {
        if (gameloop.isGameOver() || isAnimating) return;

        int selectedIndex = inventoryCombo.getSelectionModel().getSelectedIndex();

        if (selectedIndex >= 0) {
            Item selectedItem = gameloop.getPlayerTeam().getInventory().get(selectedIndex);
            Pokemon activePlayer = gameloop.getActivePlayerPokemon();

            log("\n=== TOUR " + gameloop.getCurrentTurn() + " ===");
            isAnimating = true;

            String actionLog = gameloop.useItemTurn(selectedItem, activePlayer);
            log(actionLog);

            gameloop.getPlayerTeam().getInventory().remove(selectedIndex);

            updateInventoryUI();
            updateUI();
            finishTurn();
        } else {
            log("Veuillez sélectionner un objet dans le sac");
        }
    }

    private void updateUI() {
        Pokemon activePlayer = gameloop.getActivePlayerPokemon();
        if (activePlayer != null) {
            String nameWithItem = activePlayer.getName();
            if (activePlayer.getHeldItem() != null) {
                nameWithItem += " (" + activePlayer.getHeldItem().getName() + ")";
            }
            playerNameLabel.setText(nameWithItem);
            playerNameLabel.setText(activePlayer.getName());
            int maxHp = maxHpMap.get(activePlayer);
            int currentHp = Math.max(0, activePlayer.getHp());
            playerHpBar.setProgress((double) currentHp / maxHp);
            playerHpLabel.setText("HP: " + currentHp + "/" + maxHp);

            updateStatusLabel(playerStatusLabel, activePlayer);

            Button[] atkBtns = {atkBtn1, atkBtn2, atkBtn3, atkBtn4};
            for (int i = 0; i < 4; i++) {
                if (i < activePlayer.getListAttack().size()) {
                    atkBtns[i].setText(activePlayer.getListAttack().get(i).getName());
                    atkBtns[i].setDisable(isAnimating || !activePlayer.getIsAlive() || currentHp == 0);
                } else {
                    atkBtns[i].setText("-");
                    atkBtns[i].setDisable(true);
                }
            }

            boolean canAct = !isAnimating && activePlayer.getIsAlive() && currentHp > 0;
            if (useItemBtn != null && inventoryCombo != null) {
                boolean isInventoryEmpty = gameloop.getPlayerTeam().getInventory().isEmpty();
                useItemBtn.setDisable(!canAct || isInventoryEmpty);
                inventoryCombo.setDisable(!canAct || isInventoryEmpty);
            }
        }

        Pokemon activeEnemy = gameloop.getActiveEnemyPokemon();
        if (activeEnemy != null) {
            enemyNameLabel.setText(activeEnemy.getName());
            int maxHp = maxHpMap.get(activeEnemy);
            int currentHp = Math.max(0, activeEnemy.getHp());
            enemyHpBar.setProgress((double) currentHp / maxHp);
            enemyHpLabel.setText("HP: " + currentHp + "/" + maxHp);

            updateStatusLabel(enemyStatusLabel, activeEnemy);
        }

        Pokemon[] team = gameloop.getPlayerTeam().getPokemonTeam();
        for (int i = 0; i < 6; i++) {
            if (i < team.length && team[i] != null) {
                Pokemon p = team[i];
                switchBtns[i].setVisible(true);
                int currentHp = Math.max(0, p.getHp());
                int maxHp = maxHpMap.get(p);
                switchBtns[i].setText(p.getName() + " (" + currentHp + "/" + maxHp + ")");

                if (!p.getIsAlive() || currentHp == 0) {
                    switchBtns[i].setDisable(true);
                    switchBtns[i].setStyle("-fx-background-color: #E74C3C;" +
                            " -fx-text-fill: white; -fx-opacity: 0.6;");
                } else if (p == activePlayer) {
                    switchBtns[i].setDisable(true);
                    switchBtns[i].setStyle("-fx-background-color: #2ECC71;" +
                            " -fx-text-fill: white; -fx-font-weight: bold;");
                } else {
                    switchBtns[i].setDisable(isAnimating);
                    switchBtns[i].setStyle("-fx-background-color: #3498DB;" +
                            " -fx-text-fill: white; -fx-cursor: hand;");
                }
            } else {
                switchBtns[i].setVisible(false);
            }
        }
    }

    private void updateStatusLabel(Label label, Pokemon pokemon) {
        String status = "";
        if (pokemon.getStatut() != null) {
            status = pokemon.getStatut().getName();
        }

        if (status == null || status.isEmpty() || status.equalsIgnoreCase("NONE")) {
            label.setText("");
            label.setStyle("-fx-background-color: transparent;");
            label.setVisible(false);
        } else {
            // Formater le texte à afficher (trigramme)
            String displayText = status.toUpperCase();
            if (status.equalsIgnoreCase("Burn")) displayText = "BRN";
            else if (status.equalsIgnoreCase("Poison")) displayText = "PSN";
            else if (status.equalsIgnoreCase("Paralysis")) displayText = "PAR";

            label.setText(" " + displayText + " ");
            label.setVisible(true);

            // Attribution des couleurs (on se base sur le vrai nom de la classe/du statut)
            switch (status.toUpperCase()) {
                case "BURN":
                    label.setStyle("-fx-background-color: #E74C3C; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 3px;");
                    break;
                case "POISON":
                    label.setStyle("-fx-background-color: #9B59B6; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 3px;");
                    break;
                case "PARALYSIS":
                    label.setStyle("-fx-background-color: #F1C40F; -fx-text-fill: black; -fx-font-weight: bold; -fx-background-radius: 3px;");
                    break;
                default:
                    label.setStyle("-fx-background-color: #34495E; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 3px;");
                    break;
            }
        }
    }

    private void log(String message) {
        if(message != null && !message.isEmpty()) {
            battleLog.appendText(message + (message.endsWith("\n") ? "" : "\n"));
        }
    }

    @FXML void onAttack1(ActionEvent event) { executeTurn(0); }
    @FXML void onAttack2(ActionEvent event) { executeTurn(1); }
    @FXML void onAttack3(ActionEvent event) { executeTurn(2); }
    @FXML void onAttack4(ActionEvent event) { executeTurn(3); }

    @FXML void onSwitch1(ActionEvent event) { executeSwitch(0); }
    @FXML void onSwitch2(ActionEvent event) { executeSwitch(1); }
    @FXML void onSwitch3(ActionEvent event) { executeSwitch(2); }
    @FXML void onSwitch4(ActionEvent event) { executeSwitch(3); }
    @FXML void onSwitch5(ActionEvent event) { executeSwitch(4); }
    @FXML void onSwitch6(ActionEvent event) { executeSwitch(5); }

    private void executeSwitch(int teamIndex) {
        Pokemon newActive = gameloop.getPlayerTeam().getPokemonTeam()[teamIndex];
        Pokemon currentActive = gameloop.getActivePlayerPokemon();

        if (newActive == null || !newActive.getIsAlive() || newActive == currentActive) return;

        boolean wasDead = !currentActive.getIsAlive() || currentActive.getHp() <= 0;

        if (!wasDead) {
            log("\n=== TOUR " + gameloop.getCurrentTurn() + " ===");
            log("Reviens " + currentActive.getName() + " !");
        }

        gameloop.setActivePlayerPokemon(newActive);
        log("Go " + gameloop.getActivePlayerPokemon().getName() + " !");
        updateUI();

        if (!wasDead && gameloop.getActiveEnemyPokemon().getIsAlive() &&
                gameloop.getActiveEnemyPokemon().getHp() > 0) {
            isAnimating = true;
            updateUI();

            PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.setOnFinished(e -> {
                log(gameloop.performAttack(gameloop.getActiveEnemyPokemon(),
                        gameloop.getActivePlayerPokemon(), gameloop.getRandomEnemyAttack()));
                log(gameloop.checkPlayerFaint());
                finishTurn();
            });
            pause.play();
        } else {
            finishTurn();
        }
    }

    private void executeTurn(int attackIndex) {
        if (gameloop.isGameOver() || !gameloop.getActivePlayerPokemon().getIsAlive()
                || !gameloop.getActiveEnemyPokemon().getIsAlive() || isAnimating) return;

        Attack playerAttack = gameloop.getActivePlayerPokemon().getListAttack().get(attackIndex);
        Attack enemyAttack = gameloop.getRandomEnemyAttack();

        log("\n=== TOUR " + gameloop.getCurrentTurn() + " ===");
        isAnimating = true;
        updateUI();

        if (gameloop.isPlayerFaster()) {
            log(gameloop.performAttack(gameloop.getActivePlayerPokemon(),
                    gameloop.getActiveEnemyPokemon(), playerAttack));
            log(gameloop.checkEnemyFaint());
            updateUI();

            if (gameloop.getActiveEnemyPokemon().getIsAlive() &&
                    gameloop.getActiveEnemyPokemon().getHp() > 0) {
                PauseTransition pause = new PauseTransition(Duration.seconds(2));
                pause.setOnFinished(e -> {
                    log(gameloop.performAttack(gameloop.getActiveEnemyPokemon(),
                            gameloop.getActivePlayerPokemon(), enemyAttack));
                    log(gameloop.checkPlayerFaint());
                    finishTurn();
                });
                pause.play();
            } else {
                finishTurn();
            }
        } else {
            log(gameloop.performAttack(gameloop.getActiveEnemyPokemon(),
                    gameloop.getActivePlayerPokemon(), enemyAttack));
            log(gameloop.checkPlayerFaint());
            updateUI();

            if (gameloop.getActivePlayerPokemon().getIsAlive() &&
                    gameloop.getActivePlayerPokemon().getHp() > 0) {
                PauseTransition pause = new PauseTransition(Duration.seconds(2));
                pause.setOnFinished(e -> {
                    log(gameloop.performAttack(gameloop.getActivePlayerPokemon(),
                            gameloop.getActiveEnemyPokemon(), playerAttack));
                    log(gameloop.checkEnemyFaint());
                    finishTurn();
                });
                pause.play();
            } else {
                finishTurn();
            }
        }
    }

    private void finishTurn() {
        String statusLog = gameloop.endTurn();
        if(!statusLog.isEmpty()) {
            log(statusLog);
        }

        log(gameloop.checkPlayerFaint());
        log(gameloop.checkEnemyFaint());

        turnLabel.setText("Tour " + gameloop.getCurrentTurn());
        isAnimating = gameloop.isGameOver();

        updateUI();
    }
}