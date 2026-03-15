module com.example.projet {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.projet to javafx.fxml;
    exports com.example.projet;
    exports com.example.projet.Instanciation;
    opens com.example.projet.Instanciation to javafx.fxml;
}