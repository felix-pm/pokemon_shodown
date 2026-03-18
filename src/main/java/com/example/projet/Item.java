package com.example.projet;

public abstract class Item {
    protected String name;
    protected String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public abstract String use(Pokemon target);

    public String getName() { return name; }
    public String getDescription() { return description; }
}