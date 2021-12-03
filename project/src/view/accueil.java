package view;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import java.awt.event.ActionEvent;

public class accueil {
    @FXML
    Label labelAfficher;
    @FXML
    private void cliqueSurBoutonJouer(){
        labelAfficher.setVisible(true);
        String text = "Bienvenue sur le jeu";
        if(labelAfficher.getText() != text)
            labelAfficher.setText("Bienvenue sur le jeu");
        else
            labelAfficher.setText("BYE BYE");

    }

}