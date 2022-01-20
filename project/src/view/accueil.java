package view;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.manager;
import model.persistance.IPersistanceTemps;
import model.persistance.ISauvegardeTxt;
import view.game;
import java.io.IOException;

public class accueil {
    @FXML
    private javafx.scene.control.Button Jouer;
    private Label labelAfficher;
    private model.manager manager;

    @FXML
    private void cliqueSurBoutonNewGame(){
        manager m = new manager(new ISauvegardeTxt());
        Stage stage = (Stage) Jouer.getScene().getWindow();
        stage.close();
        game g = new game();
        g.startgame(stage, m);
    }

    @FXML
    private javafx.scene.control.Button Quit;
    @FXML
    private void cliqueSurBoutonQuitter(){
        Stage stage = (Stage) Quit.getScene().getWindow();
        //Sauvegarde
        labelAfficher.setText("Aurevoir!");
        stage.close();
    }

    @FXML
    private javafx.scene.control.Button Charger;

    @FXML
    private void cliqueSurBoutonCharger(){
        Stage stage = (Stage) Charger.getScene().getWindow();
        stage.close();
        saves s = new saves();
        s.sauvegardes(stage);
    }
}
