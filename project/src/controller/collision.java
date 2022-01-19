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
import model.checkPoint;

public class collision{

    public boolean verify(ArrayList<Entite> entites, Joueur j1){
        boolean finPartie, finPartie2;
        j1.setiscollideUp(false);
        j1.setiscollideDown(false);
        j1.setiscollideLeft(false);
        j1.setiscollideRight(false);
        finPartie = checkCollisionDroiteGauche(entites, j1);//verification collision droite gauche
        finPartie2 = checkCollisionHautBas(entites, j1); //Fonction vérifiant collision haut-bas
        if(finPartie || finPartie2){
            System.out.println("collision avec l'arrivé");
            return true;
        }
        return finPartie;
    }
    private boolean checkCollisionHautBas(ArrayList<Entite> entites, Joueur j1){
        //////////////Bounding box Joueur + points max
        ImageView jIV = j1.getIV();
        double WidthJ =  jIV.getImage().getWidth();
        double HeightJ = jIV.getImage().getHeight();
        BoundingBox joueurBound = new BoundingBox(jIV.getX(), jIV.getY(), WidthJ, HeightJ);//BoundingBox Joueur
        double BasJ = joueurBound.getMaxY();
        double HautJ = joueurBound.getMinY();
        double GaucheJ = joueurBound.getMinX()+5;//Permet de résoudre le problème de collision avec les plateformes
        double DroiteJ = joueurBound.getMaxX()-5;//Quand le joueur et dans l'air et qu'il touche une plateforme sur le coté


        //////////////Bounding box plateforme + verification collisions avec chaque plateformes
        for(Entite p : entites){
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
            if(HautJ <= BasP && GaucheJ <= DroiteP && DroiteJ >= GaucheP && BasP < BasJ){
                j1.setiscollideUp(true);
                j1.setCanJump(false);
                //System.out.println("collision haut");

            }

            //COLLISION SOL
            if(BasJ >= HautP && GaucheJ <= DroiteP && DroiteJ >= GaucheP && HautP > HautJ){
                j1.setiscollideDown(true);
                j1.setCanJump(true);
                //System.out.println("collision bas");
                if(p.getClass().toString().equals("class model.checkPoint")){
                    System.out.println("Il y a un checkpoint en bas");
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkCollisionDroiteGauche(ArrayList<Entite> entites, Joueur j1){
        //////////////Bounding box Joueur + points max
        ImageView jIV = j1.getIV();
        double WidthJ =  jIV.getImage().getWidth();
        double HeightJ = jIV.getImage().getHeight();
        BoundingBox joueurBound = new BoundingBox(jIV.getX(), jIV.getY(), WidthJ, HeightJ);//BoundingBox Joueur
        double BasJ = joueurBound.getMaxY();
        double HautJ = joueurBound.getMinY();
        double GaucheJ = joueurBound.getMinX();
        double DroiteJ = joueurBound.getMaxX();


        //////////////Bounding box plateforme + verification collisions avec chaque plateformes
        for(Entite p : entites){
            ImageView pIV = p.getIV();
            double WidthP =  pIV.getImage().getWidth();
            double HeightP = pIV.getImage().getHeight();
            BoundingBox platformBound = new BoundingBox(pIV.getX(), pIV.getY(), WidthP, HeightP);//BoundingBox Platform
            double BasP = platformBound.getMaxY();
            double HautP = platformBound.getMinY();
            double GaucheP = platformBound.getMinX();
            double DroiteP = platformBound.getMaxX();
            //////////////
            // COLLISION PAR LA GAUCHE DU JOUEUR X
            if(GaucheJ <= DroiteP && BasJ >= BasP && HautJ <= HautP && GaucheJ > GaucheP){
                //System.out.println("collision gauche");
                j1.setiscollideLeft(true);

            }

            //COLLISION PAR LA DROITE DU JOUEUR X
            //if(DroiteJ >= GaucheP && HautJ <= HautP && BasJ >= BasP){
            if(DroiteJ >= GaucheP && BasJ >= BasP && HautJ <= HautP && DroiteJ < DroiteP){
                //System.out.println("collision droite");
                j1.setiscollideRight(true);

            }

        }
        return false;

    }
}
