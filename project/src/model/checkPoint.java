package model;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class checkPoint extends Entite {
    Integer temps;

    public checkPoint(Image Skin, double VelociteX, double VelociteY, double Size, double SpawnX, double SpawnY, Integer Temps) {
        super(Skin, VelociteX, VelociteY, Size, SpawnX, SpawnY);
        this.temps = Temps;
        getIV().setFitHeight(getIV().getImage().getHeight());
        getIV().setFitWidth(getIV().getImage().getWidth());

    }

    public Integer getTemps() {
        return temps;
    }
    public void setTemps(Integer Temps) {
        this.temps = Temps;
    }

}
