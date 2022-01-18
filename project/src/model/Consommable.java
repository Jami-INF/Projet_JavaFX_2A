package model;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Consommable extends Entite {
    boolean utilise;


    public Consommable(Image Skin, double VelociteX, double VelociteY, double Size, double SpawnX, double SpawnY, boolean utilise) {
        super(Skin, VelociteX, VelociteY, Size, SpawnX, SpawnY);
        this.utilise = utilise;

    }

    public boolean isUtilise() {

        return utilise;
    }

    public void setUtilise(boolean utilise) {

        this.utilise = utilise;
    }


}
