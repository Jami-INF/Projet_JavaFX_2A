package view;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.When;
import javafx.fxml.FXMLLoader;
import javafx.geometry.BoundingBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.Parent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import controller.mouvement;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import controller.*;
import model.Joueur;
import model.*;
import javafx.animation.AnimationTimer;

public class game {
    static Scene s;

    long timegame = 0;
    private Integer timejeu = 0;
    private Integer timetmp = 0;
    Boolean isCollide;
    int DureeSaut = 10;//surée saut en tick
    int tmpDureeSaut;

    public void startgame(Stage stage) {
        //System.out.println("fdfzfzdfzf");
        Group g = new Group();
        s = new Scene(g,1280,720);
        stage.setScene(s);
        collision collisionController = new collision();
        actionClavier action = new actionClavier();
        mouvement mouvementJoueur = new mouvement();

        //ActionMouvement(mouvementJoueur);
        ////BACKGROUND
        Image background = new Image (getClass().getClassLoader().getResource("image/background.jpg").toExternalForm());
        ImageView backgroundIV = new ImageView (getClass().getClassLoader().getResource("image/background.jpg").toExternalForm());
        g.getChildren().add(backgroundIV);
        ////////////

        ////JOUEUR
        Image Skin = new Image(getClass().getClassLoader().getResource("image/testpers.png").toExternalForm());
        Joueur j1 = new Joueur(Skin, 20, 20, 10, 0, 0,"Joueur1");


        //ImageView joueurIV = new ImageView(getClass().getClassLoader().getResource("image/testpers.png").toExternalForm());
        ////////////

        //Image bg = new Image(getClass().getClassLoader().getResource("image/background.png").toExternalForm());

        //s.setFill(Color.grayRgb(35));
        ArrayList<Plateforme> plateformeArrayList = new ArrayList<Plateforme>();
        ArrayList<Entite> entites = new ArrayList<Entite>();

        Image Platform = new Image(getClass().getClassLoader().getResource("image/platform.png").toExternalForm());
        Plateforme p1 = new Plateforme(Platform, 100, 600, 100, 100, 200, true);
        Plateforme p2 = new Plateforme(Platform, 100, 600, 100,300, 500,true);
        Plateforme p3 = new Plateforme(Platform, 100, 600, 100, 500, 500,true);
        Plateforme p4 = new Plateforme(Platform, 100, 600, 100, 700, 500,true);
        Plateforme p5 = new Plateforme(Platform, 100, 600, 100, 900, 500,true);
        Plateforme p6 = new Plateforme(Platform, 100, 600, 100, 800, 400,true);
        Plateforme p7 = new Plateforme(Platform, 100, 600, 100, 700, 300,true);




        plateformeArrayList.add(p1);
        plateformeArrayList.add(p2);
        plateformeArrayList.add(p3);
        plateformeArrayList.add(p4);
        plateformeArrayList.add(p5);
        plateformeArrayList.add(p6);
        plateformeArrayList.add(p7);

        entites.add(j1);
        entites.add(p1);
        entites.add(p2);
        entites.add(p3);
        entites.add(p4);
        entites.add(p5);
        entites.add(p6);
        entites.add(p7);


        for (Entite enti : entites) {
            g.getChildren().add(enti.getIV());
        }

        Timer timer = new java.util.Timer();

        Thread t = new Thread(() -> {
            while(true){
                Boolean exit = true;
                timetmp++;
                timejeu = timetmp/60;



                //AffichTimeHautEcran(timejeu.toString(), canvas);

                javafx.application.Platform.runLater(() -> {
                    timer.schedule(new TimerTask(){
                        public void run(){
                            AffichTime(timetmp);
                        }
                    }, 1000);
                    ActionMouvement(action);
                    action.ActionLectureListe(action, j1, stage, entites);
                    collisionController.verify(plateformeArrayList, j1);
                    mouvementJoueur.UpdateJoueur(j1);

                });

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.setDaemon(true);
        t.start();
        stage.show();

    }
/*
    private void AffichTimeHautEcran(String time, Canvas canvas){
        graphicsContext.clearRect(20, 20, canvas.getWidth(),30);
        graphicsContext.setTextAlign(TextAlignment.CENTER);
        graphicsContext.setTextBaseline(VPos.CENTER);
        graphicsContext.setFont(new Font(30));
        graphicsContext.fillText(time, Math.round(canvas.getWidth()  / 2), 30);
        graphicsContext.setFill(Color.WHITESMOKE);
    }
*/

    private static void AffichTime(double i){
        System.out.println(i);
        //affichage dans le jeu
    }

    private static void ActionMouvement (actionClavier action) {
        s.setOnKeyPressed(
                new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent e) {
                        String in = e.getCode().toString();
                        if ( !action.getInput().contains(in) )
                            action.addInput( in );
                    }
                });
        s.setOnKeyReleased(

                new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent e) {
                        String in = e.getCode().toString();
                        action.removeInput( in );
                    }
                });
    }



}
