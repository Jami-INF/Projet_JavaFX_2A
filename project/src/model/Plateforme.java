package model;

import javafx.scene.image.Image;

public class Plateforme extends Entite {
    private boolean visible;
    private Image skin;

    /**
     * Constructeur de la classe Plateforme
     * @param Skin
     * @param VelociteX
     * @param VelociteY
     * @param Size
     * @param SpawnX
     * @param SpawnY
     * @param Visible
     */
    public Plateforme(Image Skin, double VelociteX, double VelociteY, double Size, double SpawnX, double SpawnY, boolean Visible) {
        super(Skin, VelociteX, VelociteY, Size, SpawnX, SpawnY);
        visible = Visible;
        skin = Skin;

    }

    /**
     * Savoir si une plateforme est visible ou non
     * @return
     */
    public boolean getVisible() {
        return visible;
    }

}
