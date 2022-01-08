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
    private double jumpHauteur = 150;
    private double gravite = 10;
    private double size;
    private Image skin;
    private double imageSize;
    private boolean isCollideUp = false;
    private boolean isCollideDown = false;
    private boolean isCollideLeft = false;
    private boolean isCollideRight = false;



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
        isCollideLeft = false;
        //IV.setX(IV.getX()+5);
        //System.out.println("zefzfezfe");
    }
    public void mouvementarriereX() {
        isMouvementArriere = true;
        isMouvementAvant = false;
        isCollideRight = false;
    }
    public void arretmouvement(){
        isMouvementArriere = false;
        isMouvementAvant = false;
        isCollideLeft = false;
        isCollideRight = false;
    }

    public boolean getisMouvementArriere(){
        return isMouvementArriere;
    }
    public boolean getisMouvementAvant(){
        return isMouvementAvant;
    }

    public void saut() {
        if(isCollideUp == false){
            inJump = true;
            if (canJump) {
                velociteY = velociteY-jumpHauteur;//le problème est que le saut se fait en une frame, ducoup en faisant +40, il se tp dans la plateforme sans verifier la collision
                gravite = 10;
            }
            canJump = false;
        }


    }
    public void update(ArrayList<Plateforme> plateformeArrayList) {
        //updateMouvementX(plateformeArrayList);// obstacle coté
        //updateMouvementY(plateformeArrayList);//gravité + plateforme bas
        velociteY += gravite;
        //gravite =10;
        /*if(isCollideUp == false && isCollideDown == false){

        }*/
        IV.setY(getY() + velociteY);

        if (isCollideRight == false){
            if (isMouvementAvant) {
                IV.setX(IV.getX() + velociteX);
            }
        }
        if (isCollideLeft == false){
            if (isMouvementArriere) {
                IV.setX(IV.getX() - velociteX);
            }
        }
        double WidthJ = IV.getImage().getWidth();
        double HeightJ = IV.getImage().getHeight();
        BoundingBox joueurBound = new BoundingBox(IV.getX(), IV.getY(), WidthJ, HeightJ);
        //COORDONNES JOUEUR
        double BasJ = joueurBound.getMaxY();
        double HautJ = joueurBound.getMinY();
        double GaucheJ = joueurBound.getMinX();
        double DroiteJ = joueurBound.getMaxX();
        for (Plateforme p : plateformeArrayList){
            double WidthP =  p.getIV().getImage().getWidth();
            double HeightP = p.getIV().getImage().getHeight();
            BoundingBox platformBound = new BoundingBox(p.IV.getX(), p.IV.getY(), WidthP, HeightP);
            //COORDONNES PLATEFORME
            double BasP = platformBound.getMaxY();
            double HautP = platformBound.getMinY();
            double GaucheP = platformBound.getMinX()-5;
            double DroiteP = platformBound.getMaxX()-5;
            //Bounds bounds = p.getLayoutBounds();
            if(GaucheJ >= DroiteP && HautJ <= HautP && BasJ >= BasP){ // COLLISION PAR LA GAUCHE X
                isCollideLeft = true;
                gravite = 10;
                System.out.println("collision gauche : gaucheJ");

            }/*else{
                isCollideLeft = false;
            }*/
            if(DroiteJ >= GaucheP && HautJ <= HautP && BasJ >= BasP){ //COLLISION PAR LA DROITE X
                isCollideRight = true;
                gravite = 10;
                System.out.println("collision droite : DroiteJ");
            }/*else{
                isCollideRight = false;
            }*/


            if(HautJ >= BasP && GaucheJ <= DroiteP && DroiteJ >= GaucheP){ //COLLISION TETE Y
                isCollideUp = true;
                gravite = 10;
                velociteY = 0;
                canJump = false;
                System.out.println("collision tete");
            }else{
                isCollideUp = false;
            }
            if(BasJ >= HautP && GaucheJ <= DroiteP && DroiteJ >= GaucheP){ //COLLISION SOL Y
                isCollideDown = true;
                gravite = 0;
                canJump = true;
                System.out.println("collision sol");

            }else{
                isCollideDown = false;
            }

        }

    }
    /*
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
    }//Y hauteur // X largeur*/
/*
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
    */

    /*public void updateMouvementX(ArrayList<Plateforme> plateformeArrayList){
        if (isCollideRight == false){
            if (isMouvementAvant) {
                IV.setX(IV.getX() + velociteX);
            }
        }
        if (isCollideLeft == false){
            if (isMouvementArriere) {
                IV.setX(IV.getX() - velociteX);
            }
        }
        double WidthJ = IV.getImage().getWidth();
        double HeightJ = IV.getImage().getHeight();
        BoundingBox joueurBound = new BoundingBox(IV.getX(), IV.getY(), WidthJ, HeightJ);
        //COORDONNES JOUEUR
        double BasJ = joueurBound.getMaxY();
        double HautJ = joueurBound.getMinY();
        double GaucheJ = joueurBound.getMinX();
        double DroiteJ = joueurBound.getMaxX();
        for (Plateforme p : plateformeArrayList){
            double WidthP =  p.getIV().getImage().getWidth();
            double HeightP = p.getIV().getImage().getHeight();
            BoundingBox platformBound = new BoundingBox(p.IV.getX(), p.IV.getY(), WidthP, HeightP);
            //COORDONNES PLATEFORME
            double BasP = platformBound.getMaxY();
            double HautP = platformBound.getMinY();
            double GaucheP = platformBound.getMinX()-5;
            double DroiteP = platformBound.getMaxX()-5;
            //Bounds bounds = p.getLayoutBounds();
            if(GaucheJ >= DroiteP){ // COLLISION PAR LA GAUCHE X
                isCollideLeft = true;
                System.out.println("collision gauche : gaucheJ");

            }
            if(DroiteJ >= GaucheP && HautJ <= HautP && BasJ >= BasP){ //COLLISION PAR LA DROITE X
                isCollideRight = true;
                System.out.println("collision droite : DroiteJ");
                System.out.println(DroiteJ);
                System.out.println(GaucheP);
            }
        }
    }

    void updateMouvementY(ArrayList<Plateforme> plateformeArrayList) {
        velociteY += gravite;
        IV.setY(getY() + velociteY);
        double WidthJ = IV.getImage().getWidth();
        double HeightJ = IV.getImage().getHeight();

        BoundingBox joueurBound = new BoundingBox(IV.getX(), IV.getY(), WidthJ, HeightJ);
        //COORDONNES JOUEUR
        double BasJ = joueurBound.getMaxY();
        double HautJ = joueurBound.getMinY();
        double GaucheJ = joueurBound.getMinX();
        double DroiteJ = joueurBound.getMaxX();
        //System.out.println(HautJ);
        //POUR TOUTES LES PLATEFORMES
        for (Plateforme p : plateformeArrayList){
            double WidthP =  p.getIV().getImage().getWidth();
            double HeightP = p.getIV().getImage().getHeight();
            BoundingBox platformBound = new BoundingBox(p.IV.getX(), p.IV.getY(), WidthP, HeightP);
            //COORDONNES PLATEFORME
            double BasP = platformBound.getMaxY();
            double HautP = platformBound.getMinY();
            double GaucheP = platformBound.getMinX();
            double DroiteP = platformBound.getMaxX();
            //System.out.println(HautP);
            //System.out.println("hautP: ");
            //System.out.println(HautP);
            //System.out.println("basJ");
            //System.out.println(BasJ);
            if(BasJ >= HautP && GaucheJ <= DroiteP && DroiteJ >= GaucheP){ //COLLISION SOL Y
                isCollideDown = true;
                gravite = 0;
                canJump = true;
                System.out.println("collision sol");

            }
            if(HautJ >= BasP && GaucheJ <= DroiteP && DroiteJ >= GaucheP){ //COLLISION TETE Y
                isCollideUp = true;
                gravite = 10;
                canJump = false;
                System.out.println("collision tete");

            }
        }
    }*/
}