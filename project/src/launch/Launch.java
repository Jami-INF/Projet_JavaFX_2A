package launch;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.Parent;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.io.IOException;

public class Launch extends Application {

    public void start(Stage stage) throws IOException {
        Parent root = (Parent) FXMLLoader.load(getClass().getClassLoader().getResource("fxml/accueil.fxml"));
        stage.setTitle("Mutltitarget Points Plot");
        stage.setScene(new Scene(root, 883.0, 558.0));
        stage.show();
        //Parent root = (Parent) FXMLLoader.load(getClass().getClassLoader().getResource("fxml/accueil.fxml"));
        //Scene scene = new Scene(root, 900, 520);
        //stage.setScene(scene);
        //stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}