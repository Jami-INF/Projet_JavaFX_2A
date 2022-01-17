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

// Classe stockant une liste de touche pour les mouvements a finir ??

public class mouvement {

    public void UpdateJoueur(Joueur j1){
        if(!j1.getiscollideDown()){
            j1.setVelociteY(j1.getVelociteY()+j1.getGravite());
            j1.getIV().setY(j1.getIV().getY() + j1.getVelociteY());
        }
        if(!j1.getiscollideUp()){
            j1.setVelociteY(0);
        }
        if((!j1.getiscollideLeft()) && j1.getisMouvementArriere()){//mouvement arrière
            //j1.setVelociteX(j1.getVelociteX()-j1.getVitesse());
            j1.getIV().setX(j1.getIV().getX() - j1.getVelociteX());
            System.out.println("mouvement arriere");
        }
        if((!j1.getiscollideRight()) && j1.getisMouvementAvant()){//mouvement avant
            j1.getIV().setX(j1.getIV().getX() + j1.getVelociteX());
            System.out.println("mouvement avant");

        }



    }

}