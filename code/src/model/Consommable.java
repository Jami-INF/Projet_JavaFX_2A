package model;

public class Consommable extends ElementCarte{
    boolean utilise;

    public Consommable(int cordx, int cordy, int hitbox, boolean utilise) {
        super(cordx, cordy, hitbox);
        this.utilise = utilise;
    }

    public boolean isUtilise() {
        return utilise;
    }

    public void setUtilise(boolean utilise) {
        this.utilise = utilise;
    }
}
