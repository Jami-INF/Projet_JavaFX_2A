package model;

import javafx.scene.image.Image;

public class Consommable extends Entite {
    boolean utilise;

    public Consommable(int SpawnX, int SpawnY, Image Skin, int XHitBox, int YHitBox, int velociteX, int velociteY, boolean utilise) {
        super(SpawnX, SpawnY,  Skin, XHitBox, YHitBox, velociteX, velociteY);
        this.utilise = utilise;
    }

    public boolean isUtilise() {

        return utilise;
    }

    public void setUtilise(boolean utilise) {

        this.utilise = utilise;
    }
}
