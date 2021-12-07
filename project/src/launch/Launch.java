package launch;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.*;
import javafx.event.EventHandler;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyEvent;
import controller.*;

public class Launch extends Application {

    static Scene s;
    static GraphicsContext graphicsContext;
    static int WIDTH = 1280;
    static int HEIGHT = 720;

    @Override
    public void start(Stage stage)
    {
        Group g = new Group();
        s = new Scene(g);
        stage.setScene(s);
        mouvement mouvementJoueur = new mouvement();
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        g.getChildren().add(canvas);
        ActionMouvement(mouvementJoueur);

        graphicsContext = canvas.getGraphicsContext2D();

        Image Skin = new Image( "testpers.png" );
        Joueur j1 = new Joueur(50, 50, Skin, 50, 50, "Joueur1");

        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                ActionLectureListe(mouvementJoueur, j1, stage, canvas);
            }
        }.start();

        stage.show();
        //Parent root = (Parent) FXMLLoader.load(getClass().getClassLoader().getResource("fxml/accueil.fxml"));
        //stage.setTitle("Mutltitarget Points Plot");
        //stage.setScene(new Scene(root, 883.0, 558.0));
        //stage.show();
        //Parent root = (Parent) FXMLLoader.load(getClass().getClassLoader().getResource("fxml/accueil.fxml"));
        //Scene scene = new Scene(root, 900, 520);
        //stage.setScene(scene);
        //.show();
    }

    private static void ActionMouvement (mouvement mouvementJoueur)
    {
        s.setOnKeyPressed(
                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e)
                    {
                        String in = e.getCode().toString();
                        if ( !mouvementJoueur.getInput().contains(in) )
                            mouvementJoueur.addInput( in );
                    }
                });
        s.setOnKeyReleased(

                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e)
                    {
                        String in = e.getCode().toString();
                        mouvementJoueur.removeInput( in );
                    }
                });
    }

    void ActionLectureListe (mouvement mouvementJoueur, Joueur j1, Stage stage, Canvas canvas){
        GraphicsContext gc;
        Image image;

        if (mouvementJoueur.getInput().contains("LEFT"))
        {
            graphicsContext.clearRect(0, 0, WIDTH, HEIGHT);
            j1.mouvementarriereX();
            gc = canvas.getGraphicsContext2D();
            stage.setTitle( "Bienvenue sur le jeu" );
            //stage.setScene(s);
            image = new Image("testpers.png");
            gc.drawImage(image, j1.getX(), j1.getY());
        }

        if (mouvementJoueur.getInput().contains("RIGHT"))
        {
            graphicsContext.clearRect(0, 0, WIDTH, HEIGHT);
            j1.mouvementavantX();
            gc = canvas.getGraphicsContext2D();
            stage.setTitle( "Bienvenue sur le jeu" );
            //stage.setScene(s);
            image = new Image("testpers.png");
            gc.drawImage(image, j1.getX(), j1.getY());
        }
        if (mouvementJoueur.getInput().contains("UP"))
        {
            graphicsContext.clearRect(0, 0, WIDTH, HEIGHT);
            j1.saut();
            gc = canvas.getGraphicsContext2D();
            stage.setTitle( "Bienvenue sur le jeu" );
            //stage.setScene(s);
            image = new Image("testpers.png");
            gc.drawImage(image, j1.getX(), j1.getY());
        }

    }
    public static void main(String[] args)
    {
        launch(args);
    }
}