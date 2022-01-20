package view;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.When;
import javafx.fxml.FXMLLoader;
import javafx.geometry.BoundingBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.Parent;
import java.io.*;
import java.awt.*;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import controller.mouvement;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import controller.*;
import launch.Launch;
import model.Joueur;
import model.*;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class game{
    static Scene s;
    manager m;

    long timegame = 0;
    private Integer timejeu = 0;
    private Integer timetmp = 0;
    private boolean finPartie = false;
    private boolean threadEnCours = true;

    /**
     * Fonction gérant les différents appels de nos controller
     * @param stage
     * @param manager
     */
    public void startgame(Stage stage, String pseudo, manager manager) {
        System.out.println(pseudo);
        Group g = new Group();
        s = new Scene(g,1280,720);
        stage.setScene(s);
        this.m = manager;
        collision collisionController = new collision();
        actionClavier action = new actionClavier();
        mouvement mouvementJoueur = new mouvement();


        ////Chargement des scores :
        List<score> listeScores;
        listeScores = m.getScoresParties();
        System.out.println("voici la liste des scores : ");

        for(score sc : listeScores){
            System.out.println(sc.getPseudo() + " : " + sc.getTemps());
        }


        ////BACKGROUND
        ImageView backgroundIV = new ImageView (getClass().getClassLoader().getResource("image/background.jpg").toExternalForm());
        g.getChildren().add(backgroundIV);
        ////////////

        ////JOUEUR
        Image Skin = new Image(getClass().getClassLoader().getResource("image/testpers.png").toExternalForm());

        if(pseudo.equals("")){
            pseudo = "Invité";
        }

        Joueur j1 = new Joueur(Skin, 10, 10, 0.8, 50, 300, pseudo);

        ////CHECKPOINT
        Image ckpt = new Image(getClass().getClassLoader().getResource("image/checkpoint.png").toExternalForm());
        checkPoint checkpoint = new checkPoint(ckpt, 10, 10, 0.8, 50, 200,0);



        ArrayList<Entite> entites = new ArrayList<Entite>();

        Image Platform = new Image(getClass().getClassLoader().getResource("image/platform.png").toExternalForm());
        Plateforme p1 = new Plateforme(Platform, 100, 600, 0.8, 50, 600, true);
        Plateforme p2 = new Plateforme(Platform, 100, 600, 0.8,180, 500,true);//1 plateforme = 130
        Plateforme p3 = new Plateforme(Platform, 100, 600, 0.8, 310, 400,true);
        Plateforme p4 = new Plateforme(Platform, 100, 600, 0.8, 440, 600,true);
        Plateforme p7 = new Plateforme(Platform, 100, 600, 0.8, 830, 600,true);
        Plateforme p8 = new Plateforme(Platform, 100, 600, 0.8, 960, 600,true);
        Plateforme p9 = new Plateforme(Platform, 100, 600, 0.8, 1090, 400,true);

        Plateforme p10 = new Plateforme(Platform, 100, 600, 0.8, 200, 200,true);
        Plateforme p11 = new Plateforme(Platform, 100, 600, 0.8, 330, 200,true);
        Plateforme p12 = new Plateforme(Platform, 100, 600, 0.8, 460, 200,true);
        Plateforme p13 = new Plateforme(Platform, 100, 600, 0.8, 590, 200,true);
        Plateforme p16 = new Plateforme(Platform, 100, 600, 0.8, 980, 200,true);



        /*
        ArrayList<Plateforme> plateformeArrayList = new ArrayList<Plateforme>();
        plateformeArrayList.add(p1);
        plateformeArrayList.add(p2);
        plateformeArrayList.add(p3);
        plateformeArrayList.add(p4);
        plateformeArrayList.add(p5);
        plateformeArrayList.add(p6);
        plateformeArrayList.add(p7);*/

        entites.add(j1);
        entites.add(p1);
        entites.add(p2);
        entites.add(p3);
        entites.add(p4);
        //entites.add(p5);
        //entites.add(p6);
        entites.add(p7);
        entites.add(p8);
        entites.add(p9);
        entites.add(p10);
        entites.add(p11);
        entites.add(p12);
        entites.add(p13);
        //entites.add(p14);
        //entites.add(p15);
        entites.add(p16);
        entites.add(checkpoint);


        for (Entite enti : entites) {
            g.getChildren().add(enti.getIV());
        }
        Text timerBind = new Text("0");
        timerBind.setFill(Color.WHITE);
        timerBind.setFont(Font.font(40));
        timerBind.setTranslateX(600);
        timerBind.setTranslateY(40);
        g.getChildren().add(timerBind);



        Timer timer = new java.util.Timer();

        Thread t = new Thread(() -> {
            while(threadEnCours){
                Boolean exit = true;
                timetmp++;
                timejeu = timetmp/60;
                if(finPartie){
                    System.out.println("FIN");
                    m.ajouterScore(j1.getPseudo(), timejeu);
                    m.sauvegarderResultat(listeScores);
                    threadEnCours = false;

                }




                javafx.application.Platform.runLater(() -> {
                    timer.schedule(new TimerTask(){
                        public void run(){
                            timerBind.setText(timejeu.toString());
                        }
                    }, 1000);
                    ActionJoueur(action);
                    action.ActionLectureListe(action, j1, stage, entites);
                    finPartie = collisionController.verify(entites, j1);
                    mouvementJoueur.UpdateJoueur(j1);
                    if(finPartie){
                        stage.close();
                        Launch l = new Launch();
                        try {
                            l.start(stage);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }


                });

                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.setDaemon(true);
        t.start();
        stage.show();

        /*int time;
        File fichier = new File(getClass().getClassLoader().getResource("persistance/BestTime.xml").getPath());
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier));
        time = (Integer)ois.readObject();
        ois.writeObject(time);*/
    }

    /**
     * Fonction qui permet de gérer l'ajout ou la suppression d'inputs dans une liste passée en parametre
     * @param action : liste d'actions
     */
    private static void ActionJoueur (actionClavier action) {
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
