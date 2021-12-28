package model;

import javafx.scene.image.Image;

public class Piege extends Entite {
    int degats;
    boolean active;
    boolean visible;

    public Piege(Image Skin, double VelociteX, double VelociteY, double Size, int degats, boolean active, boolean visible) {
        super(Skin, VelociteX, VelociteY, Size);
        this.degats = degats;
        this.active = active;
        this.visible = visible;
    }

    public int getDegats() {

        return degats;
    }

    public void setDegats(int degats) {

        this.degats = degats;
    }

    public boolean isActive() {

        return active;
    }

    public void setActive(boolean active) {

        this.active = active;
    }

    public boolean getVisible() {

        return visible;
    }


}
