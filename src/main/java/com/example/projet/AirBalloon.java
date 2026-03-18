package com.example.projet;

public class AirBalloon extends Item {
    private boolean intact = true;

    public AirBalloon() {
        super("Ballon", "Immunise contre le type Sol. Éclate s'il reçoit une attaque.");
    }

    public boolean isIntact() { return intact; }
    public void setIntact(boolean intact) { this.intact = intact; }

    @Override
    public String use(Pokemon target) {
        if (!intact) return "Le Ballon est déjà crevé.";
        return target.getName() + " flotte grâce à son Ballon !";
    }
}