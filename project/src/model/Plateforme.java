package model;

import javafx.scene.image.Image;

public class Plateforme extends Entite {
    private boolean visible;

    public Plateforme(Image Skin, double VelociteX, double VelociteY, double Size, boolean visible) {
        super(Skin, VelociteX, VelociteY, Size);
        this.visible = visible;
    }

    public boolean getVisible() {
        return visible;
    }

}
