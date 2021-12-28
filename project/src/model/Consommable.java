package model;

import javafx.scene.image.Image;

public class Consommable extends Entite {
    boolean utilise;

    public Consommable(Image Skin, double VelociteX, double VelociteY, double Size, boolean utilise) {
        super(Skin, VelociteX, VelociteY, Size);
        this.utilise = utilise;
    }

    public boolean isUtilise() {

        return utilise;
    }

    public void setUtilise(boolean utilise) {

        this.utilise = utilise;
    }
}
