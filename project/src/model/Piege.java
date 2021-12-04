package model;

import javafx.scene.image.Image;

public class Piege extends Entite {
    int degats;
    boolean active;
    boolean visible;

    public Piege(int SpawnX, int SpawnY, Image Skin, int XHitBox, int YHitBox, int degats, boolean active, boolean visible) {
        super(SpawnX, SpawnY,  Skin, XHitBox, YHitBox);
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

    public boolean isVisible() {

        return visible;
    }

    public void setVisible(boolean visible) {

        this.visible = visible;
    }
}
