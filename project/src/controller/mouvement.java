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

// Classe stockant une liste de touche pour les mouvements a finir ??

public class mouvement {
    private ArrayList<String> input;

    public mouvement() {
        input = new ArrayList<String>();
    }

    public ArrayList<String> getInput() {
        return input;
    }
    public void addInput(String s) {
        input.add(s);
    }

    public void removeInput(String s) {

        input.remove(s);
    }
    public void clearInput(){
        for (String in: input) {
            input.remove(in);
        }

    }

    public Boolean ActionLectureListe (mouvement mouvementJoueur, Joueur j1, Stage stage, ArrayList<Entite> entites){

        if (mouvementJoueur.getInput().contains("LEFT")) {
            j1.mouvementarriereX();
            //System.out.println("left");

            //joueurIV.setX(joueurIV.getX()-5);//méthode bourrin

            //return true;

        }
        if (mouvementJoueur.getInput().contains("RIGHT")) {
            j1.mouvementavantX();
            //System.out.println("right");
            //joueurIV.setX(joueurIV.getX()+5);

            //return true;
        }

        if (mouvementJoueur.getInput().contains("UP")) {
            j1.saut();
            j1.setInJump(true);

            //return true;
        }
        if (mouvementJoueur.getInput().contains("ESCAPE")) {
            //sauvegarde auto
            //lance nouveau menu avec comme option : recommencer le jeu et quitter
            System.out.println("quitter");
            stage.close();
            Parent root = null;
            try {
                root = (Parent) FXMLLoader.load(getClass().getClassLoader().getResource("fxml/accueil.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root, 900, 520);
            stage.setScene(scene);
            //mouvementJoueur.clearInput();
            //stage.show();
            return false;
        }
        j1.arretmouvement();
        return true;
    }


    public Boolean CheckCollision (Joueur j, ArrayList<Plateforme> plateformeArrayList) {
        //System.out.println(J.getX());
        int WidthJ = (int) j.getImage().getWidth();
        int HeightJ = (int) j.getImage().getHeight();
        BoundingBox joueurBound = new BoundingBox(j.getX(), j.getY(), WidthJ, HeightJ);

        //pour toutes les plateformes dans la liste
        for (Plateforme p : plateformeArrayList){
            int WidthP = (int) p.getImage().getWidth();
            int HeightP = (int) p.getImage().getHeight();
            BoundingBox platformBound = new BoundingBox(p.getX(), p.getY(), WidthP, HeightP);

            if( platformBound.intersects(joueurBound) ) {
                System.out.println("Collision");
                return true;
            }


        }
        return false;
    }//Y hauteur // X largeur

}
