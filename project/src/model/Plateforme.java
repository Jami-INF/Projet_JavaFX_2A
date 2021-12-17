package model;

import javafx.scene.image.Image;

public class Plateforme extends Entite {
    boolean visible;

    public Plateforme(int SpawnX, int SpawnY, Image Skin, int XHitBox, int YHitBox, int velociteX, int velociteY, boolean visible) {
        super(SpawnX, SpawnY,  Skin, XHitBox, YHitBox, velociteX, velociteY);
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
