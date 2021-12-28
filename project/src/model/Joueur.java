package model;
import controller.mouvement;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.control.Skin;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Joueur extends Entite {

    private int vie;
    private String pseudo;
    private double velociteY;
    private double velociteX;
    private boolean inJump;
    private boolean canJump;
    private boolean isMouvementAvant;
    private boolean isMouvementArriere;
    private double jumpHauteur = 10;
    private double gravite = 2;
    private double size;
    private Image skin;
    private double imageSize;


    public Joueur(Image Skin, double VelociteX, double VelociteY, double Size, double SpawnX, double SpawnY, String Pseudo) {
        super(Skin, VelociteX, VelociteY, Size, SpawnX, SpawnY);
        vie=10;//A modifier peut etre ?
        Pseudo = pseudo;
        isMouvementArriere=false;
        isMouvementAvant = false;
        velociteX = VelociteX;
        velociteY = VelociteY;
        size = Size;
        skin = Skin;
        imageSize = size;
        setFitWidth(imageSize);
        setFitHeight(imageSize);


    }

    public int getVie()
    {
        return vie;
    }

    public void setVie(int pv)
    {
        vie=pv;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Boolean isInJump () {
        return inJump;
    }
    public void setInJump (Boolean b) {
        inJump = b;
    }
    public void mouvementavantX() {
        isMouvementAvant = true;
        isMouvementArriere = false;
        //IV.setX(IV.getX()+5);
        //System.out.println("zefzfezfe");
    }
    public void mouvementarriereX() {
        isMouvementArriere = true;
        isMouvementAvant = false;
    }
    public void arretmouvement(){
        isMouvementArriere = false;
        isMouvementAvant = false;
    }

    public boolean getisMouvementArriere(){
        return isMouvementArriere;
    }
    public boolean getisMouvementAvant(){
        return isMouvementAvant;
    }

    public void saut() {
        if (canJump) {
            velociteY = velociteY-jumpHauteur;
        }
        canJump = false;

    }
    public void update(ArrayList<Plateforme> plateformeArrayList) {
        updateMouvementX(plateformeArrayList);// obstacle coté
        updateMouvementY(plateformeArrayList);//gravité + plateforme bas
    }
    public Boolean CheckCollision (ArrayList<Plateforme> plateformeArrayList) {
        double WidthJ = IV.getImage().getWidth();
        double HeightJ = IV.getImage().getHeight();
        BoundingBox joueurBound = new BoundingBox(IV.getX(), IV.getY(), WidthJ, HeightJ);

        //pour toutes les plateformes dans la liste
        for (Plateforme p : plateformeArrayList){
            double WidthP =  p.getIV().getImage().getWidth();
            double HeightP = p.getIV().getImage().getHeight();
            BoundingBox platformBound = new BoundingBox(p.IV.getX(), p.IV.getY(), WidthP, HeightP);

            if( platformBound.intersects(joueurBound) ) {
                //System.out.println("Collision");
                return true;
            }
        }
        return false;
    }//Y hauteur // X largeur

    public Boolean CheckCollision (Plateforme p) {
        double WidthJ = IV.getImage().getWidth();
        double HeightJ = IV.getImage().getHeight();
        BoundingBox joueurBound = new BoundingBox(IV.getX(), IV.getY(), WidthJ, HeightJ);
        double WidthP =  p.getIV().getImage().getWidth();
        double HeightP = p.getIV().getImage().getHeight();
        BoundingBox platformBound = new BoundingBox(p.IV.getX(), p.IV.getY(), WidthP, HeightP);
        if( platformBound.intersects(joueurBound) ) {
            //System.out.println("Collision");
            return true;
        }
        return false;
    }//Y hauteur // X largeur

    public void updateMouvementX(ArrayList<Plateforme> plateformeArrayList){

        if (isMouvementAvant) {
            IV.setX(IV.getX() + velociteX);
        }
        if (isMouvementArriere) {
            IV.setX(IV.getX() - velociteX);
        }
        double WidthJ = IV.getImage().getWidth();
        double HeightJ = IV.getImage().getHeight();
        BoundingBox joueurBound = new BoundingBox(IV.getX(), IV.getY(), WidthJ, HeightJ);
        for (Plateforme p : plateformeArrayList){
            double WidthP =  p.getIV().getImage().getWidth();
            double HeightP = p.getIV().getImage().getHeight();
            BoundingBox platformBound = new BoundingBox(p.IV.getX(), p.IV.getY(), WidthP, HeightP);
            Bounds bounds = p.getLayoutBounds();
            if( platformBound.intersects(joueurBound) ) {
                System.out.println("Collision");
                if (isMouvementAvant) {
                    setX(bounds.getMinX() - imageSize - 0.01);
                }
                if (isMouvementArriere) {
                    setX(bounds.getMaxX() + 0.01);
                }
            }
        }


    }
    void updateMouvementY(ArrayList<Plateforme> plateformeArrayList) {
        velociteY += gravite;
        IV.setY(getY() + velociteY);
        double WidthJ = IV.getImage().getWidth();
        double HeightJ = IV.getImage().getHeight();
        BoundingBox joueurBound = new BoundingBox(IV.getX(), IV.getY(), WidthJ, HeightJ);
        for (Plateforme p : plateformeArrayList){
            double WidthP =  p.getIV().getImage().getWidth();
            double HeightP = p.getIV().getImage().getHeight();
            BoundingBox platformBound = new BoundingBox(p.IV.getX(), p.IV.getY(), WidthP, HeightP);
            Bounds bounds = p.getLayoutBounds();
            if( platformBound.intersects(joueurBound) ) {
                System.out.println("Collision");
                setY(bounds.getMinY() - imageSize - 0.01);
                canJump = true;
                velociteX = 0;
            }
        }

    }
}
/*
if(CheckCollision(plateformeArrayList)){
            if (isMouvementAvant) {
                //setX(bounds.getMinX() - imageSize - 0.01);
            }
            if (isMouvementArriere) {
                IV.setX(IV.getX() - velociteX);
            }
        }
 */