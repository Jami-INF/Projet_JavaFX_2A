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
    public ImageView IV;
    private double size;

    /**
     * Constructeur de la classe Entite
     * @param Skin
     * @param VelociteX
     * @param VelociteY
     * @param Size
     * @param SpawnX
     * @param SpawnY
     */
    public Entite(Image Skin, double VelociteX, double VelociteY, double Size, double SpawnX, double SpawnY){
        IV = new ImageView(Skin);
        skin = Skin;
        size = Size;

        IV.setFitHeight(IV.getImage().getHeight()*size);
        IV.setFitWidth(IV.getImage().getWidth()*size);


        IV.setY(SpawnY);
        IV.setX(SpawnX);

        velociteY = VelociteY;
        velociteX = VelociteX;




    }

    /**
     * Méthode récuperant l'imageView de l'entité
     * @return
     */
    public ImageView getIV(){
        return IV;
    }
}
