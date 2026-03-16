package com.example.projet;

import com.example.projet.Instanciation.AllAttack;
import com.example.projet.Instanciation.AllEffects;
import com.example.projet.Instanciation.AllPokemons;
import com.example.projet.Instanciation.AllTypes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        AllTypes allTypes = new AllTypes();
        AllEffects allEffects = new AllEffects();
        AllAttack allAttacks = new AllAttack(allTypes, allEffects);
        AllPokemons allPokemons = new AllPokemons(allTypes, allAttacks);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Pokémon Showdown");
        stage.setScene(scene);
        stage.show();
    }
}