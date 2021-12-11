//class de test ou on aura un ensemble de bouton qui seront les sauvegardes
package view;

import model.Joueur;
import model.*;
import controller.mouvement;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class saves {

    static Scene newScene;

    public void sauvegardes(Stage stage) {
        Group g = new Group();
        newScene = new Scene(g);
        stage.setScene(newScene);
    }

    @FXML
    Label labelAfficher;
    @FXML
    private void cliqueSurBouton(){
        labelAfficher.setVisible(true);
        labelAfficher.setText("RIEN");
    }
}
