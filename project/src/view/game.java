package view;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.Parent;
import java.io.IOException;
import java.util.ArrayList;
import controller.mouvement;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import model.Joueur;
import model.*;
import javafx.animation.AnimationTimer;

public class game {
    static Scene s;
    static GraphicsContext graphicsContext;
    static int WIDTH = 1280;
    static int HEIGHT = 720;
    long timegame = 0;
    private Integer timejeu = 0;
    private Integer timetmp = 0;

    public void startgame(Stage stage) {
        //System.out.println("fdfzfzdfzf");
        Group g = new Group();
        s = new Scene(g);
        stage.setScene(s);
        mouvement mouvementJoueur = new mouvement();
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        g.getChildren().add(canvas);
        ActionMouvement(mouvementJoueur);

        graphicsContext = canvas.getGraphicsContext2D();
        Image Skin = new Image(getClass().getClassLoader().getResource("image/testpers.png").toExternalForm());
        Joueur j1 = new Joueur(500, 500, Skin, 50, 50, 0,0,"Joueur1");

        //Image bg = new Image(getClass().getClassLoader().getResource("image/background.png").toExternalForm());

        s.setFill(Color.grayRgb(35));
        ArrayList<Plateforme> plateformeArrayList = new ArrayList<Plateforme>();
        ArrayList<Entite> entites = new ArrayList<Entite>();

        Image platform = new Image(getClass().getClassLoader().getResource("image/platform.png").toExternalForm());
        Plateforme p1 = new Plateforme(50, 600, platform, 100, 100,0,0, true);
        Plateforme p2 = new Plateforme(550, 600, platform, 100, 100, 0,0,true);
        plateformeArrayList.add(p1);
        plateformeArrayList.add(p2);

        entites.add(p1);
        entites.add(p2);
        entites.add(j1);

        graphicsContext.drawImage(platform, p1.getX(), p1.getY());
        graphicsContext.drawImage(platform, p2.getX(), p2.getY());



        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                Boolean exit = true;
                timetmp++;
                timejeu = timetmp/60;
                //long startTime = System.nanoTime();
                if(exit=false){
                    stop();
                }
                exit = ActionLectureListe(mouvementJoueur, j1, stage, canvas, entites);
                //System.out.println(exit);
                AffichTimeHautEcran(timejeu.toString(), canvas);

                mouvementJoueur.CheckCollision(j1, plateformeArrayList);
            }
        }.start();
        stage.show();

    //Long.toString(System.currentTimeMillis()-currentNanoTime)
    }

    private void AffichTimeHautEcran(String time, Canvas canvas){
        graphicsContext.clearRect(20, 20, canvas.getWidth(),30);
        graphicsContext.setTextAlign(TextAlignment.CENTER);
        graphicsContext.setTextBaseline(VPos.CENTER);
        graphicsContext.setFont(new Font(30));
        graphicsContext.fillText(time, Math.round(canvas.getWidth()  / 2), 30);
        graphicsContext.setFill(Color.WHITESMOKE);
    }

    private static void ActionMouvement (mouvement mouvementJoueur) {
        s.setOnKeyPressed(
                new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent e) {
                        String in = e.getCode().toString();
                        if ( !mouvementJoueur.getInput().contains(in) )
                            mouvementJoueur.addInput( in );
                    }
                });
        s.setOnKeyReleased(

                new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent e) {
                        String in = e.getCode().toString();
                        mouvementJoueur.removeInput( in );
                    }
                });
    }

    Boolean ActionLectureListe (mouvement mouvementJoueur, Joueur j1, Stage stage, Canvas canvas, ArrayList<Entite> entites){
        GraphicsContext gc;

        if (mouvementJoueur.getInput().contains("LEFT")) {
            graphicsContext.clearRect(j1.getX(), j1.getY(), j1.getImage().getWidth(), j1.getImage().getHeight());
            j1.mouvementarriereX();
            gc = canvas.getGraphicsContext2D();
            for(Entite e : entites)
            {
                gc.drawImage( e.getImage(), e.getX(), e.getY());
            }
            return true;

        }
        if (mouvementJoueur.getInput().contains("RIGHT")) {
            graphicsContext.clearRect(j1.getX(), j1.getY(), j1.getImage().getWidth(), j1.getImage().getHeight());
            j1.mouvementavantX();
            gc = canvas.getGraphicsContext2D();
            for(Entite e : entites)
            {
                gc.drawImage( e.getImage(), e.getX(), e.getY());
            }            return true;
        }
        if (mouvementJoueur.getInput().contains("UP")) {
            graphicsContext.clearRect(j1.getX(), j1.getY(), j1.getImage().getWidth(), j1.getImage().getHeight());
            j1.mouvementhaut();
            gc = canvas.getGraphicsContext2D();
            for(Entite e : entites)
            {
                gc.drawImage( e.getImage(), e.getX(), e.getY());
            }            return true;
        }
        if (mouvementJoueur.getInput().contains("DOWN")) {
            graphicsContext.clearRect(j1.getX(), j1.getY(), j1.getImage().getWidth(), j1.getImage().getHeight());
            j1.mouvementbas();
            gc = canvas.getGraphicsContext2D();
            for(Entite e : entites)
            {
                gc.drawImage( e.getImage(), e.getX(), e.getY());
            }            return true;
        }
        if (mouvementJoueur.getInput().contains("ESCAPE")) {
            //sauvegarde auto
            //lance nouveau menu avec comme option : recommencer le jeu et quitter
            System.out.println("quitter");
            stage.close();
            Parent root = null;
            try {
                root = (Parent) FXMLLoader.load(getClass().getClassLoader().getResource("fxml/accueil.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root, 900, 520);
            stage.setScene(scene);
            //mouvementJoueur.clearInput();

            stage.show();
            return false;
        }
        return true;
    }

}