package view;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.BoundingBox;
import javafx.scene.image.ImageView;
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
    Boolean isCollide;
    int DureeSaut = 10;//surée saut en tick
    int tmpDureeSaut;

    public void startgame(Stage stage) {
        //System.out.println("fdfzfzdfzf");
        Group g = new Group();
        s = new Scene(g);
        stage.setScene(s);
        mouvement mouvementJoueur = new mouvement();
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        g.getChildren().add(canvas);
        ActionMouvement(mouvementJoueur);
        ImageView bcg = new ImageView(getClass().getClassLoader().getResource("image/background.jpg").toExternalForm());



        graphicsContext = canvas.getGraphicsContext2D();
        Image Skin = new Image(getClass().getClassLoader().getResource("image/testpers.png").toExternalForm());
        Joueur j1 = new Joueur(50, 200, Skin, 50, 50,10,10, "Joueur1", false);

        //Image bg = new Image(getClass().getClassLoader().getResource("image/background.png").toExternalForm());

        s.setFill(Color.grayRgb(35));
        ArrayList<Plateforme> plateformeArrayList = new ArrayList<Plateforme>();
        ArrayList<Entite> entites = new ArrayList<Entite>();

        Image platform = new Image(getClass().getClassLoader().getResource("image/platform.png").toExternalForm());
        Plateforme p1 = new Plateforme(100, 600, platform, 100, 100, 10,10,true);
        Plateforme p2 = new Plateforme(300, 600, platform, 100, 100,10,10, true);
        Plateforme p3 = new Plateforme(600, 600, platform, 100, 100,10,10, true);
        Plateforme p4 = new Plateforme(800, 600, platform, 100, 100,10,10, true);
        Plateforme p5 = new Plateforme(900, 100, platform, 100, 100,10,10, true);


        plateformeArrayList.add(p1);
        plateformeArrayList.add(p2);
        plateformeArrayList.add(p3);
        plateformeArrayList.add(p4);
        plateformeArrayList.add(p5);

        entites.add(p1);
        entites.add(p2);
        entites.add(p3);
        entites.add(p4);
        entites.add(p5);
        entites.add(j1);

        for (Plateforme p : plateformeArrayList) {
            graphicsContext.drawImage(platform, p.getX(), p.getY());
        }

        /*Thread t = new Thread(() -> {
            while(true){
                try{
                    Thread.sleep(10);
                    Platform.runLater(() -> {
                        //joueur.getPlayer().setX(joueur.getPlayer().getX() + 0.1d);
                    });
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        t.start();
        stage.show();*/

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                Boolean exit = true;
                timetmp++;
                timejeu = timetmp/60;
                //long startTime = System.nanoTime();
                if(exit=false){

                }

                AffichTimeHautEcran(timejeu.toString(), canvas);

                isCollide = mouvementJoueur.CheckCollision(j1, plateformeArrayList);
                ActionLectureListe(mouvementJoueur, j1, stage, canvas, entites);
                if (isCollide== false){
                    //exit = ActionLectureListe(mouvementJoueur, j1, stage, canvas, entites);
                        canvas.getGraphicsContext2D().clearRect(j1.getX(), j1.getY(), j1.getImage().getWidth(), j1.getImage().getHeight());
                        j1.gravite();
                        canvas.getGraphicsContext2D().drawImage( j1.getImage(), j1.getX(), j1.getY());



                }


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
        GraphicsContext gc = canvas.getGraphicsContext2D();


        if (mouvementJoueur.getInput().contains("LEFT")) {
            graphicsContext.clearRect(j1.getX(), j1.getY(), j1.getImage().getWidth(), j1.getImage().getHeight());
            j1.mouvementarriereX();
            for(Entite e : entites)
            {
                gc.drawImage( e.getImage(), e.getX(), e.getY());
            }
            //return true;

        }
        if (mouvementJoueur.getInput().contains("RIGHT")) {
            graphicsContext.clearRect(j1.getX(), j1.getY(), j1.getImage().getWidth(), j1.getImage().getHeight());
            j1.mouvementavantX();
            for(Entite e : entites)
            {
                gc.drawImage( e.getImage(), e.getX(), e.getY());
            }
            //return true;
        }

        if (mouvementJoueur.getInput().contains("UP")) {
            //graphicsContext.clearRect(j1.getX(), j1.getY(), j1.getImage().getWidth(), j1.getImage().getHeight());
            //j1.mouvementhaut();
            j1.setInJump(true);



            //for(Entite e : entites)
            //{
            //    gc.drawImage( e.getImage(), e.getX(), e.getY());
            //}
            //return true;
        }
        /* Mouvement vers le bas inutile
        if (mouvementJoueur.getInput().contains("DOWN")) {
            graphicsContext.clearRect(j1.getX(), j1.getY(), j1.getImage().getWidth(), j1.getImage().getHeight());
            j1.mouvementbas();
            for(Entite e : entites)
            {
                gc.drawImage( e.getImage(), e.getX(), e.getY());
            }
            return true;
        }
        $/
         */
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
            //stage.show();
            return false;
        }
        return true;
    }

}
