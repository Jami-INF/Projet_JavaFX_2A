package model;
import javafx.geometry.BoundingBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public abstract class Entite extends ImageView {

    private double vitesse = 300;

    private double gravite = 5;

    private double imageSize;

    private double x;
    private double y;
    private Image skin;
    private double velociteX;
    private double velociteY;
    private double time;

    ImageView IV;

    public Entite(Image Skin, double VelociteX, double VelociteY, double Size, double SpawnX, double SpawnY){
        IV = new ImageView(Skin);
        skin = Skin;
        IV.setY(SpawnY);
        IV.setX(SpawnX);

        VelociteY = velociteY;
        VelociteX = velociteX;


    }

    public ImageView getIV(){
        return IV;
    }
}
