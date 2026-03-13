package com.example.projet;

import java.util.HashMap;

public class Type {

    private String name;
    private HashMap<Type, Double> efficiencyOffensive;

    public Type(String name){
        this.name = name;
        this.efficiencyOffensive = new HashMap<>();
    }

    public void addEfficiency(Type target, double multiplicateur){
        this.efficiencyOffensive.put(target, multiplicateur);
    }

    public Double getMultiplicateurContre(Type target){
        if (this.efficiencyOffensive.get(target) == null){
            return 1.0;
        } else {
            return this.efficiencyOffensive.get(target);
        }
    }

    public String getName(){
        return this.name;
    }
}
