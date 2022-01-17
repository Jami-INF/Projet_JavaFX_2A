package controller;
import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.geometry.BoundingBox;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Entite;
import model.Joueur;
import model.Plateforme;

public class collision{

    public void verify(ArrayList<Plateforme> p, Joueur j1){
        j1.setiscollideUp(false);
        j1.setiscollideDown(false);
        j1.setiscollideLeft(false);
        j1.setiscollideRight(false);
        checkCollisionHautBas(p, j1); //Fonction vérifiant collision haut-bas
        checkCollisionDroiteGauche(p, j1);
    }
    private void checkCollisionHautBas(ArrayList<Plateforme> plateformeList, Joueur j1){
        //////////////Bounding box Joueur + points max
        ImageView jIV = j1.getIV();
        double WidthJ =  jIV.getImage().getWidth();
        double HeightJ = jIV.getImage().getHeight();
        BoundingBox joueurBound = new BoundingBox(jIV.getX(), jIV.getY(), WidthJ, HeightJ);//BoundingBox Joueur
        double BasJ = joueurBound.getMaxY();
        double HautJ = joueurBound.getMinY();
        double GaucheJ = joueurBound.getMinX();
        double DroiteJ = joueurBound.getMaxX();
        //System.out.println("Gauche J : " + GaucheJ + " Droite J : " + DroiteJ);
        //System.out.println("Haut J : " + HautJ + " Bas J : " + BasJ);
        //////////////

        //////////////Bounding box plateforme + verification collisions avec chaque plateformes
        for(Plateforme p : plateformeList){
            ImageView pIV = p.getIV();
            double WidthP =  pIV.getImage().getWidth();
            double HeightP = pIV.getImage().getHeight();
            BoundingBox platformBound = new BoundingBox(pIV.getX(), pIV.getY(), WidthP, HeightP);//BoundingBox Platform
            double BasP = platformBound.getMaxY();
            double HautP = platformBound.getMinY();
            double GaucheP = platformBound.getMinX();
            double DroiteP = platformBound.getMaxX();
            //System.out.println("Gauche P : " + GaucheP + "Droite P : " + DroiteP);
            //System.out.println("Haut P : " + HautP + "Bas P : " + BasP);
            //////////////
            //COLLISION TETE Y
            if(HautP >= BasJ && HautJ >= BasP && GaucheJ <= DroiteP && DroiteJ >= GaucheP){
                j1.setiscollideUp(true);
                j1.setCanJump(false);
                System.out.println("collision tete");
            }

            //COLLISION SOL
            if(BasJ >= HautP && BasP >= HautJ && GaucheJ <= DroiteP && DroiteJ >= GaucheP){
                j1.setiscollideDown(true);
                j1.setCanJump(true);
                System.out.println("collision sol");
            }
        }
    }

    private void checkCollisionDroiteGauche(ArrayList<Plateforme> plateformeList, Joueur j1){
        //////////////Bounding box Joueur + points max
        ImageView jIV = j1.getIV();
        double WidthJ =  jIV.getImage().getWidth();
        double HeightJ = jIV.getImage().getHeight();
        BoundingBox joueurBound = new BoundingBox(jIV.getX(), jIV.getY(), WidthJ, HeightJ);//BoundingBox Joueur
        double BasJ = joueurBound.getMaxY();
        double HautJ = joueurBound.getMinY();
        double GaucheJ = joueurBound.getMinX();
        double DroiteJ = joueurBound.getMaxX();
        //System.out.println("Gauche J : " + GaucheJ + " Droite J : " + DroiteJ);
        //System.out.println("Haut J : " + HautJ + " Bas J : " + BasJ);
        //////////////

        //////////////Bounding box plateforme + verification collisions avec chaque plateformes
        for(Plateforme p : plateformeList){
            ImageView pIV = p.getIV();
            double WidthP =  pIV.getImage().getWidth();
            double HeightP = pIV.getImage().getHeight();
            BoundingBox platformBound = new BoundingBox(pIV.getX(), pIV.getY(), WidthP, HeightP);//BoundingBox Platform
            double BasP = platformBound.getMaxY();
            double HautP = platformBound.getMinY();
            double GaucheP = platformBound.getMinX();
            double DroiteP = platformBound.getMaxX();
            //System.out.println("Gauche P : " + GaucheP + "Droite P : " + DroiteP);
            //System.out.println("Haut P : " + HautP + "Bas P : " + BasP);
            //////////////
            // COLLISION PAR LA GAUCHE DU JOUEUR X
            //if(GaucheJ <= DroiteP && HautP <= HautJ && BasP >= BasJ){
            if(GaucheJ <= DroiteP && BasJ >= BasP && HautJ <= HautP){
                j1.setiscollideLeft(true);
                System.out.println("collision gauche");
            }

            //COLLISION PAR LA DROITE DU JOUEUR X
            //if(DroiteJ >= GaucheP && HautJ <= HautP && BasJ >= BasP){
            if(DroiteJ >= GaucheP && BasJ >= BasP && HautJ <= HautP){
                j1.setiscollideRight(true);
                //System.out.println("Gauche J : " + GaucheJ + " Droite J : " + DroiteJ);
                //System.out.println("Haut J : " + HautJ + " Bas J : " + BasJ);
                //System.out.println("Gauche P : " + GaucheP + "Droite P : " + DroiteP);
                //System.out.println("Haut P : " + HautP + "Bas P : " + BasP);
                System.out.println("collision droite");
            }
        }

    }
}
