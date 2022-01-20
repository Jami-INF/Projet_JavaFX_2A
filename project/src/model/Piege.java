package model;

import javafx.scene.image.Image;

public class Piege extends Entite {
    int degats;
    boolean active;
    boolean visible;

    /**
     * constructeur de la classe Piege
     * @param Skin
     * @param VelociteX
     * @param VelociteY
     * @param Size
     * @param SpawnX
     * @param SpawnY
     * @param degats
     * @param active
     * @param visible
     */
    public Piege(Image Skin, double VelociteX, double VelociteY, double Size, double SpawnX, double SpawnY, int degats, boolean active, boolean visible) {
        super(Skin, VelociteX, VelociteY, Size, SpawnX, SpawnY);
        this.degats = degats;
        this.active = active;
        this.visible = visible;
    }

    /**
     * methode qui permet récuperer les degats d'un piège
     * @return degats en int
     */
    public int getDegats() {

        return degats;
    }

    /**
     * methode qui permet de modifier les degats d'un piège
     * @param degats
     */
    public void setDegats(int degats) {

        this.degats = degats;
    }

    /**
     * methode qui permet de savoir si un piege est actif ou pas
     * @return boolean active
     */
    public boolean isActive() {

        return active;
    }

    /**
     * methode qui permet de modifier l'état d'un piege
     * @param active
     */
    public void setActive(boolean active) {

        this.active = active;
    }

    /**
     * methode qui permet de savoir si un piege est visible ou pas
     * @return
     */
    public boolean getVisible() {

        return visible;
    }


}
