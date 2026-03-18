package com.example.projet;

import com.example.projet.Instanciation.AllAttack;
import com.example.projet.Instanciation.AllEffects;
import com.example.projet.Instanciation.AllPokemons;
import com.example.projet.Instanciation.AllTypes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class CreateTeamController {

    @FXML
    private ListView<String> availablePokemonsList;
    @FXML
    private ListView<String> teamPokemonsList;
    @FXML
    private ListView<String> possibleAttacksList;
    @FXML
    private ListView<String> equippedAttacksList;
    @FXML private ListView<String> availableItemsList;
    @FXML private Label equippedItemLabel;

    // Listes observables pour l'interface
    private ObservableList<String> teamString = FXCollections.observableArrayList();
    private ObservableList<String> possibleAttacksString = FXCollections.observableArrayList();
    private ObservableList<String> equippedAttacksString = FXCollections.observableArrayList();

    // La vraie liste des instances de Pokemons en train d'être configurés
    private ArrayList<Pokemon> currentTeamList = new ArrayList<>();

    private AllPokemons cataloguePokemons;
    private static Team realTeam;

    @FXML
    public void initialize() {
        AllTypes allTypes = new AllTypes();
        AllEffects allEffects = new AllEffects();
        AllAttack allAttacks = new AllAttack(allTypes, allEffects);
        this.cataloguePokemons = new AllPokemons(allTypes, allAttacks);

        ObservableList<String> availablePokemons = FXCollections.observableArrayList(
                "Pikachu", "Ectoplasma", "Dracaufeu", "Florizarre", "Tortank",
                "Alakazam", "Mackogneur", "Ronflex", "Carchacrok", "Lucario"
        );

        ObservableList<String> items = FXCollections.observableArrayList(
                "Restes", "Lunettes Noires", "Baie Oran", "Ballon"
        );

        teamPokemonsList.getSelectionModel().selectedIndexProperty().addListener((obs, oldVal, newVal) -> {
            updateAttacksViews(newVal.intValue());
            updateItemView(newVal.intValue()); // Nouvelle méthode
        });

        availableItemsList.setItems(items);
        availablePokemonsList.setItems(availablePokemons);
        teamPokemonsList.setItems(teamString);
        possibleAttacksList.setItems(possibleAttacksString);
        equippedAttacksList.setItems(equippedAttacksString);

        // Ecouteur: quand on clique sur un Pokemon de l'équipe, on affiche SES attaques
        teamPokemonsList.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            updateAttacksViews(newValue.intValue());
        });
    }

    @FXML
    protected void onChoosePokemon(ActionEvent event) {
        String selectedPokemonName = availablePokemonsList.getSelectionModel().getSelectedItem();

        if (selectedPokemonName != null && currentTeamList.size() < 6) {
            Pokemon template = cataloguePokemons.getPokemon(selectedPokemonName);
            if (template != null) {
                // On utilise la copie pour avoir des instances indépendantes (ex: 2 Pikachus différents)
                Pokemon newPokemon = template.copy();
                currentTeamList.add(newPokemon);
                teamString.add(newPokemon.getName() + " (Pkmn " + currentTeamList.size() + ")");
            }
        }
    }

    @FXML
    protected void onRemovePokemon(ActionEvent event) {
        int selectedIndex = teamPokemonsList.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            currentTeamList.remove(selectedIndex);
            teamString.remove(selectedIndex);
            possibleAttacksString.clear();
            equippedAttacksString.clear();
        }
    }

    private void updateAttacksViews(int pokemonIndex) {
        possibleAttacksString.clear();
        equippedAttacksString.clear();

        if (pokemonIndex >= 0 && pokemonIndex < currentTeamList.size()) {
            Pokemon selectedPokemon = currentTeamList.get(pokemonIndex);

            // Remplir la liste des attaques possibles (qu'on n'a pas encore équipées)
            for (Attack atk : selectedPokemon.getPossibleAttacks()) {
                if (!selectedPokemon.getListAttack().contains(atk)) {
                    possibleAttacksString.add(atk.getName());
                }
            }

            // Remplir la liste des attaques équipées
            for (Attack atk : selectedPokemon.getListAttack()) {
                equippedAttacksString.add(atk.getName());
            }
        }
    }

    @FXML
    protected void onAddAttack(ActionEvent event) {
        int pIndex = teamPokemonsList.getSelectionModel().getSelectedIndex();
        String selectedAttackName = possibleAttacksList.getSelectionModel().getSelectedItem();

        if (pIndex >= 0 && selectedAttackName != null) {
            Pokemon p = currentTeamList.get(pIndex);
            if (p.getListAttack().size() < 4) { // Max 4 attaques
                for (Attack atk : p.getPossibleAttacks()) {
                    if (atk.getName().equals(selectedAttackName)) {
                        p.addAttack(atk); // Rattache l'attaque au Pokemon sélectionné
                        break;
                    }
                }
                updateAttacksViews(pIndex);
            } else {
                System.out.println("Ce Pokémon a déjà 4 attaques !");
            }
        }
    }

    @FXML
    protected void onRemoveAttack(ActionEvent event) {
        int pIndex = teamPokemonsList.getSelectionModel().getSelectedIndex();
        String selectedAttackName = equippedAttacksList.getSelectionModel().getSelectedItem();

        if (pIndex >= 0 && selectedAttackName != null) {
            Pokemon p = currentTeamList.get(pIndex);
            Attack toRemove = null;
            for (Attack atk : p.getListAttack()) {
                if (atk.getName().equals(selectedAttackName)) {
                    toRemove = atk;
                    break;
                }
            }
            if (toRemove != null) {
                p.getListAttack().remove(toRemove);
                updateAttacksViews(pIndex); // Met à jour l'affichage
            }
        }
    }

    public static Team getRealTeam() {
        return realTeam;
    }

    @FXML
    protected void onValiderEquipe(ActionEvent event) {
        this.realTeam = new Team(this.cataloguePokemons);
        for (Pokemon p : currentTeamList) {
            this.realTeam.addInTeam(p);
        }
        System.out.println("Vraie équipe créée avec succès ! Voici les données :");
        System.out.println(this.realTeam.printTeam());
    }

    @FXML
    protected void onPlay(ActionEvent event) throws IOException {
        if (realTeam != null && realTeam.getSize() >= 3){
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("gameplay.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Pokémon Showdown - gameplay");
            stage.setScene(scene);
            stage.show();
            System.out.println("Equipe enregistrée");
        } else {
            System.out.println("Pas assez de Pokémon dans l'équipe (Minimum 3, Maximum 6)");
        }
    }

    private void updateItemView(int pokemonIndex) {
        if (pokemonIndex >= 0 && pokemonIndex < currentTeamList.size()) {
            Pokemon selected = currentTeamList.get(pokemonIndex);
            if (selected.getHeldItem() != null) {
                equippedItemLabel.setText(selected.getHeldItem().getName());
            } else {
                equippedItemLabel.setText("Aucun");
            }
        }
    }

    @FXML
    protected void onAttachItem(ActionEvent event) {
        int pIndex = teamPokemonsList.getSelectionModel().getSelectedIndex();
        String selectedItemName = availableItemsList.getSelectionModel().getSelectedItem();

        if (pIndex >= 0 && selectedItemName != null) {
            Pokemon p = currentTeamList.get(pIndex);

            // Instanciation de l'objet selon le choix
            switch (selectedItemName) {
                case "Restes": p.setHeldItem(new Leftovers()); break;
                case "Lunettes Noires": p.setHeldItem(new BlackGlasses()); break;
                case "Baie Oran": p.setHeldItem(new OranBerry()); break;
                case "Ballon": p.setHeldItem(new AirBalloon()); break;
            }
            updateItemView(pIndex);
            System.out.println(selectedItemName + " attaché à " + p.getName());
        }
    }
}