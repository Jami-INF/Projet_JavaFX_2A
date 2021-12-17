package controller;
import java.util.ArrayList;

import javafx.geometry.BoundingBox;
import model.Joueur;
import model.Plateforme;

// Classe stockant une liste de touche pour les mouvements a finir ??

public class mouvement {
    private ArrayList<String> input;

    public mouvement()
    {

        input = new ArrayList<String>();
    }

    public ArrayList<String> getInput() {
        return input;
    }
    public void addInput(String s) {
        input.add(s);
    }

    public void removeInput(String s) {

        input.remove(s);
    }
    public void clearInput(){
        for (String in: input) {
            input.remove(in);
        }

    }

    public void actionClavier(Joueur p) {
        if (input.contains("UP"))
            p.saut(20);
        if (input.contains("RIGHT"))
            p.mouvementavantX();
        else if (input.contains("LEFT"))
            p.mouvementarriereX();
    }

    public Boolean CheckCollision (Joueur j, ArrayList<Plateforme> plateformeArrayList) {
        //System.out.println(J.getX());
        int WidthJ = (int) j.getImage().getWidth();
        int HeightJ = (int) j.getImage().getHeight();
        BoundingBox joueurBound = new BoundingBox(j.getX(), j.getY(), WidthJ, HeightJ);

        //pour toutes les plateformes dans la liste
        for (Plateforme p : plateformeArrayList){
            int WidthP = (int) p.getImage().getWidth();
            int HeightP = (int) p.getImage().getHeight();
            BoundingBox platformBound = new BoundingBox(p.getX(), p.getY(), WidthP, HeightP);

            //if( (p.getX() >= j.getX()) && (p.getY() >= j.getY()) && ( ( (p.getX()+WidthP) <= j.getX()+WidthJ) && (p.getY()+HeightP) <= j.getY()+HeightJ) ) {
            if( platformBound.intersects(joueurBound) ) {
            //if(p.intersect(j.getX(),j.getY()))
                System.out.println("Collision");
                return true;
            }


        }
        return false;
    }//Y hauteur // X largeur

}
