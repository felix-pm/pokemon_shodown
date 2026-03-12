package com.example.projet;

import java.sql.*;

public class controller {

    public controller(){
        final String DB_URL = "jdbc:mysql://localhost:8889/Coda_POKEMON_SHOWDOWN";
        final String USER = "root";
        final String PASS = "root";



        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM Pokemon JOIN Pokemon_Attaque ON Pokemon.id = " +
                    "Pokemon_Attaque.pokemon_id JOIN Attaque ON Attaque.id = Pokemon_Attaque.attaque_id";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getString("nom_pokemon"));
                System.out.println(rs.getInt("hp"));
                System.out.println(rs.getInt("attaque"));
                System.out.println(rs.getInt("attaque_speciale"));
                System.out.println(rs.getInt("defense"));
                System.out.println(rs.getInt("defense_speciale"));
                System.out.println(rs.getInt("vitesse"));
                System.out.println(rs.getString("type1"));
                System.out.println(rs.getString("type2"));
                System.out.println(rs.getString("src"));
                System.out.println("----------------");
                System.out.println(rs.getString("nom_attaque"));
                System.out.println(rs.getInt("puissance"));
                System.out.println(rs.getString("type"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
