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
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateTeamController {

    @FXML
    private ListView<String> availablePokemonsList;
    @FXML
    private ListView<String> teamPokemonsList;

    private ObservableList<String> teamString = FXCollections.observableArrayList();

    private AllPokemons cataloguePokemons;
    private static Team realTeam;

    @FXML
    public void initialize() {
        // --- 1. INSTANCIATION DES DONNÉES DU JEU ---
        // (Pour l'instant on les crée ici, plus tard on les passera d'une page à l'autre)
        AllTypes allTypes = new AllTypes();
        AllEffects allEffects = new AllEffects();
        AllAttack allAttacks = new AllAttack(allTypes, allEffects);
        this.cataloguePokemons = new AllPokemons(allTypes, allAttacks);

        this.realTeam = new Team(this.cataloguePokemons);

        ObservableList<String> availablePokemons = FXCollections.observableArrayList(
                "Pikachu", "Ectoplasma", "Dracaufeu", "Florizarre", "Tortank",
                "Alakazam", "Mackogneur", "Ronflex", "Carchacrok", "Lucario"
        );
        availablePokemonsList.setItems(availablePokemons);
        teamPokemonsList.setItems(teamString);
    }

    @FXML
    protected void onChoosePokemon(ActionEvent event) {
        String selectedPokemon = availablePokemonsList.getSelectionModel().getSelectedItem();

        if (selectedPokemon != null && teamString.size() < 6) {
            teamString.add(selectedPokemon);
        }
    }

    @FXML
    protected void onValiderEquipe(ActionEvent event) {
        // On réinitialise l'équipe au cas où on clique plusieurs fois sur "Valider"
        this.realTeam = new Team(this.cataloguePokemons);

        // On parcourt tous les "noms" que le joueur a choisis dans la liste de droite
        for (String nomDuPokemon : teamString) {
            Pokemon vraiPokemon = cataloguePokemons.getPokemon(nomDuPokemon);
            if(vraiPokemon != null) {
                this.realTeam.addInTeam(vraiPokemon);
            }
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
            System.out.println("Equipe enregistré");
        } else {
            System.out.println("Pas assez de pokemon dans l'équipe");
        }

    }
}