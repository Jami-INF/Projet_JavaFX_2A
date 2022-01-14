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
            //////////////
            // COLLISION PAR LA GAUCHE X
            if(GaucheJ >= DroiteP && HautP <= HautJ && BasP >= BasJ){
                j1.setiscollideLeft(true);
                System.out.println("collision gauche");
            }

            //COLLISION PAR LA DROITE X
            if(DroiteJ >= GaucheP && HautJ <= HautP && BasJ >= BasP){
                j1.setiscollideDown(true);
                System.out.println("collision droite");
            }
        }

    }
}
