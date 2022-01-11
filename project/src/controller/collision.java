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

    public void verify(ArrayList<Plateforme> p){
        updateMouvementX(p);
        updateMouvementY(p);
    }

    private void updateMouvementX(ArrayList<Plateforme> plateformeList){
        for(Plateforme p : plateformeList){
            ImageView pIV = p.getIV();
            double WidthP =  p.getIV().getImage().getWidth();
            double HeightP = p.getIV().getImage().getHeight();
            BoundingBox platformBound = new BoundingBox(p.IV.getX(), p.IV.getY(), WidthP, HeightP);
        }
    }

    private void updateMouvementY(){

    }
}
