package model;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Entite extends ImageView {

    private double vitesse = 300;
    private double jumpHauteur = 700;
    private double gravite = 2000;

    private double imageSize;
    private boolean isMouvementAvant;
    private boolean isMouvementArriere;
    private double x;
    private double y;
    private Image skin;
    private double velociteX;
    private double velociteY;
    private double yAcceleration;

    public Entite(Image Skin, double VelociteX, double VelociteY, double Size){
        skin = Skin;
        setY(y);
        setX(x);
        imageSize = Size;
        setFitWidth(imageSize);
        setFitHeight(imageSize);
        VelociteY = velociteY;
        VelociteX = velociteX;
    }

    public void mouvementavantX() {
        isMouvementAvant = true;
        isMouvementArriere = false;
    }

    public void mouvementarriereX() {
        isMouvementArriere = true;
        isMouvementAvant = false;
    }
    public void arretmouvement(){
        isMouvementArriere = false;
        isMouvementAvant = false;
    }

    public void saut(int Y) {
        velociteY = velociteY-jumpHauteur;
    }
    public void updateMouvement(){
        if (isMouvementAvant) {
            setX(getX() + velociteX);
        }
        if (isMouvementArriere) {
            setX(getX() - velociteX);
        }

    }


}
