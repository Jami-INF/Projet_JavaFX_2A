package view;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.manager;
import model.persistance.IPersistanceTemps;
import model.persistance.ISauvegardeTxt;
import model.score;
import view.game;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class accueil {
    @FXML
    private javafx.scene.control.Button Jouer;
    private Label labelAfficher;
    private model.manager manager;
    //private TableView<score> lc;
    private ObservableList<score> lc = FXCollections.observableArrayList();
    private manager m = new manager(new ISauvegardeTxt());
    //private List<score> lc = new ArrayList<score>();
    @FXML
    private javafx.scene.control.TextField Pseudo;
    /**
     * Fonction qui nous permet de lancer une scene depuis un bouton sur une vue
     */
    @FXML
    private void cliqueSurBoutonNewGame(){
        String pseudo = Pseudo.getText();
        //System.out.println(pseudo);

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
        stage.close();
    }
    @FXML
    private javafx.scene.control.TableColumn tablePseudo;
    @FXML
    private javafx.scene.control.TableColumn tableTemps;
    @FXML
    private javafx.scene.control.TableView tableScore;
    @FXML
    private void initialize() {
        lc = FXCollections.observableArrayList(m.getScoresParties());

        tablePseudo.setCellValueFactory(new PropertyValueFactory<score, String>("Pseudo"));
        tableTemps.setCellValueFactory(new PropertyValueFactory<score, String>("Temps"));
        tableScore.setItems(lc);
        //tableTemps.setCellValueFactory(cellData -> "qdzdqzdqs");
    }
}
