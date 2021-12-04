package view;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class accueil {
    @FXML
    private Label labelAfficher;
    @FXML
    private void cliqueSurBoutonNewGame(){
        labelAfficher.setVisible(true);
        String text = "Bienvenue sur le jeu";
        if(labelAfficher.getText() != text)
            labelAfficher.setText("Bienvenue sur le jeu");
        else
            labelAfficher.setText("BYE BYE");
    }
    @FXML
    private javafx.scene.control.Button Quit;
    @FXML
    private void cliqueSurBoutonQuitter(){
        Stage stage = (Stage) Quit.getScene().getWindow();
        //Sauvegarde ou temps d'arret
        labelAfficher.setText("Aurevoir!");
        stage.close();
    }
    @FXML
    private javafx.scene.control.Button Charger;
    @FXML
    private void cliqueSurBoutonCharger(){
        //
        //Changer d'affichage
        //Scene scene = new Scene();
    }
}