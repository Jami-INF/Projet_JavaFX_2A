package model;

import javafx.scene.image.Image;

public class Plateforme extends Entite {
    private boolean visible;
    private Image skin;

    public Plateforme(Image Skin, double VelociteX, double VelociteY, double Size, double SpawnX, double SpawnY, boolean Visible) {
        super(Skin, VelociteX, VelociteY, Size, SpawnX, SpawnY);
        visible = Visible;
        skin = Skin;

    }

    public boolean getVisible() {
        return visible;
    }

}
