package controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javafx.fxml.FXMLLoader;
import javafx.geometry.BoundingBox;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Entite;
import model.Joueur;
import model.Plateforme;

public class mouvement {
    /**
     * Fonction qui permet de gérer les mouvements du joueur
     * @param j1
     */
    public void UpdateJoueur(Joueur j1){
        //Gestion collision sol
        if(!j1.getiscollideDown() || j1.getiscollideDown() && j1.isInJump() && !j1.getiscollideUp()){
            j1.setVelociteY(j1.getGravite());//ajoute la gravité au joueur
            j1.getIV().setY(j1.getIV().getY() + j1.getVelociteY());//modifie emplacement IV
        }
        //Gestion collision tete
        if(j1.getiscollideUp()){
            j1.setVelociteY(j1.getGravite());
            //j1.setVelociteY(0);//remet la vélocité à 0
        }
        //Gestion collision gauche
        if((!j1.getiscollideLeft()) && j1.getisMouvementArriere()){//mouvement arrière
            //j1.setVelociteX(j1.getVelociteX()-j1.getVitesse());
            j1.getIV().setX(j1.getIV().getX() - j1.getVelociteX());//modifie emplacement IV
            //System.out.println("mouvement arriere");
        }
        //Gestion collision droite
        if((!j1.getiscollideRight()) && j1.getisMouvementAvant()){//mouvement avant
            j1.getIV().setX(j1.getIV().getX() + j1.getVelociteX());//modifie emplacement IV
            //System.out.println("mouvement avant");
        }
        gestionSaut(j1);//appel de la fonction de gestion des sauts
    }
    /**
     * Fonction qui permet de gérer les sauts du joueur en inversant la gravité
     * @param j1 le joueur
     */
    public void gestionSaut(Joueur j1){

        //Vérifie si le joueur souhaite sauter et si il n'est pas en collision au dessu avec un objet ce qui empecherais de monter le saut
        if(j1.isInJump() && (!j1.getiscollideUp())){
            j1.setGravite(-15);//inverse la gravité
            j1.setDureesauttmp(j1.getDureesauttmp()+1);//incrémente la durée du saut
        }//else gravité normal

        //si la durée du saut est écoulée, le joueur est en l'air et la gravité est réinitialisée
        if(j1.getDureesauttmp()>20){
            j1.setInJump(false);//le joueur n'est plus en saut
            j1.setDureesauttmp(0);//réinitialise la durée du saut
            j1.setGravite(5);//réinitialise la gravité
        }

    }

}