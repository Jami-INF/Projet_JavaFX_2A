package model;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Consommable extends Entite {
    boolean utilise;

    /**
     * Constructeur de Consommable
     * @param Skin
     * @param VelociteX
     * @param VelociteY
     * @param Size
     * @param SpawnX
     * @param SpawnY
     * @param utilise
     */
    public Consommable(Image Skin, double VelociteX, double VelociteY, double Size, double SpawnX, double SpawnY, boolean utilise) {
        super(Skin, VelociteX, VelociteY, Size, SpawnX, SpawnY);
        this.utilise = utilise;

    }

    /**
     * Méthode permettant de savoir si le consommable est utilisé ou non
     * @return
     */
    public boolean isUtilise() {

        return utilise;
    }

    /**
     * Méthode permettant de changer l'état du consommable
     * @param utilise
     */
    public void setUtilise(boolean utilise) {

        this.utilise = utilise;
    }


}
