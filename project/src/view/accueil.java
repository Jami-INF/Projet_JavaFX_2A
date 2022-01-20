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
    private javafx.scene.control.TextField Pseudo;
    /**
     * Fonction qui nous permet de lancer une scene depuis un bouton sur une vue
     */
    @FXML
    private void cliqueSurBoutonNewGame(){
        String pseudo = Pseudo.getText();
        //System.out.println(pseudo);
        manager m = new manager(new ISauvegardeTxt());
        Stage stage = (Stage) Jouer.getScene().getWindow();
        stage.close();
        game g = new game();
        g.startgame(stage, pseudo, m);
    }

    /**
     * Fonction qui nous permet de fermer une scene depuis un bouton sur une vue
     */
    @FXML
    private javafx.scene.control.Button Quit;
    @FXML
    private void cliqueSurBoutonQuitter(){
        Stage stage = (Stage) Quit.getScene().getWindow();
        labelAfficher.setText("Aurevoir!");
        stage.close();
    }
}
