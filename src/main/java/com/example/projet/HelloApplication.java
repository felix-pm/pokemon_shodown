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
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 700, 700);
        //controller data = new controller();
        //stage.setTitle("Pokemon Shodown");
        //stage.setScene(scene);

        AllTypes allTypes = new AllTypes();
        AllEffects allEffects = new AllEffects();

        // 2. Instanciation des attaques (nécessite les Types et les Effets)
        AllAttack allAttacks = new AllAttack(allTypes, allEffects);

        // 3. Instanciation du catalogue de Pokémons (nécessite les Types et les Attaques)
        AllPokemons allPokemons = new AllPokemons(allTypes, allAttacks);

        // 4. Instanciation de la Gameloop (nécessite le catalogue de Pokémons)
        Gameloop gameloop = new Gameloop(allPokemons);

        stage.show();
    }
}
