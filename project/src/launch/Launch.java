package launch;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.Parent;
import java.io.IOException;
import view.game;
public class Launch extends Application {

    public void start(Stage stage) throws IOException {
        //view image fxml

        Parent root = (Parent) FXMLLoader.load(getClass().getClassLoader().getResource("fxml/accueil.fxml"));
        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().addAll(getClass().getClassLoader().getResource("css/style.css").toExternalForm());

        //scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());


        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}