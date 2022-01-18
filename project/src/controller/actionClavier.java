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

public class actionClavier {

    private ArrayList<String> input;

    public actionClavier() {
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

    public void clearInput() {
        for (String in : input) {
            input.remove(in);
        }

    }

    /**
     * Fonction qui permet de gerer les actions du clavier
     * @param action
     * @param j1
     * @param stage
     * @param entites
     * @return
     */
    public Boolean ActionLectureListe(actionClavier action, Joueur j1, Stage stage, ArrayList<Entite> entites) {
        if (action.getInput().contains("LEFT")) {
            j1.mouvementarriereX();

        } else if (action.getInput().contains("RIGHT")) {
            j1.mouvementavantX();
            System.out.println("mouvement avant");

        } else if (action.getInput().contains("UP")) {
            j1.saut();

        } else if (action.getInput().contains("ESCAPE")) {
            stage.close();
            Parent root = null;
            try {
                root = (Parent) FXMLLoader.load(getClass().getClassLoader().getResource("fxml/accueil.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root, 900, 520);
            stage.setScene(scene);

            return false;
        } else
            j1.arretmouvement();

        return true;
    }
}
