package model;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class checkPoint extends Entite {
    Integer temps;

    /**
     * Constructeur de la classe checkPoint
     * @param Skin
     * @param VelociteX
     * @param VelociteY
     * @param Size
     * @param SpawnX
     * @param SpawnY
     * @param Temps
     */
    public checkPoint(Image Skin, double VelociteX, double VelociteY, double Size, double SpawnX, double SpawnY, Integer Temps) {
        super(Skin, VelociteX, VelociteY, Size, SpawnX, SpawnY);
        this.temps = Temps;
        getIV().setFitHeight(getIV().getImage().getHeight());
        getIV().setFitWidth(getIV().getImage().getWidth());

    }

    /**
     * Methode qui permet de recuperer le temps de jeu a l'arrivé au checkpoint
     * @return
     */
    public Integer getTemps() {
        return temps;
    }

    /**
     * Methode qui permet de modifier le temps de jeu a l'arrivé au checkpoint
     * @param Temps
     */
    public void setTemps(Integer Temps) {
        this.temps = Temps;
    }

}
