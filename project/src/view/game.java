//class de test ou il y aura le perso qui bouge j'espere
package view;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import java.awt.event.ActionEvent;

public class game {
    @FXML
    Label labelAfficher;
    @FXML
    private void cliqueSurBouton(){
        labelAfficher.setVisible(true);
        labelAfficher.setText("RIEN");
    }

}