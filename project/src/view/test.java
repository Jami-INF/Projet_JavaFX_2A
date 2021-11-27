package view;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import java.awt.event.ActionEvent;

public class test {
    @FXML
    Label labelAfficher;
    @FXML
    private void cliqueSurBouton(){
        labelAfficher.setVisible(true);
        labelAfficher.setText("RIEN");
    }
}
