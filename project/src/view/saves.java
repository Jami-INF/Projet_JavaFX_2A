//class de test ou on aura un ensemble de bouton qui seront les sauvegardes
package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class saves {
    @FXML
    Label labelAfficher;
    @FXML
    private void cliqueSurBouton(){
        labelAfficher.setVisible(true);
        labelAfficher.setText("RIEN");
    }
}
