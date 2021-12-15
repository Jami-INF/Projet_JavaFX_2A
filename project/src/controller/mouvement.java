package controller;
import java.util.ArrayList;
import model.Joueur;
import model.Plateforme;

// Classe stockant une liste de touche pour les mouvements a finir ??

public class mouvement {
    private ArrayList<String> input;

    public mouvement()
    {

        input = new ArrayList<String>();
    }

    public ArrayList<String> getInput()
    {

        return input;
    }
    public void addInput(String s)
    {

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

    public void CheckCollision (Joueur j, ArrayList<Plateforme> plateformeArrayList) {
        //System.out.println(J.getX());
        int widthJ = (int) j.getImage().getWidth();
        int HeightJ = (int) j.getImage().getHeight();

        for (Plateforme p : plateformeArrayList){//pour toutes les plateformes dans la liste
            int WidthP = (int) p.getImage().getWidth();
            int HeightP = (int) p.getImage().getHeight();

            //System.out.println(p.getX());
            //if (j.getX() <= p.getX()  && j.getY() >= p.getY()) {
            if (j.getX() == p.getX() + WidthP && j.getY() == p.getY() + HeightP || j.getX() == p.getX() + WidthP && j.getY() == p.getY() + HeightP || j.getX() + WidthP == p.getX() && j.getY() + HeightP == p.getY() || j.getY() + WidthP == p.getY() && j.getX() + HeightP == p.getX()) {
                System.out.println("Collision");
            }
            System.out.println(j.getX());
            System.out.println(j.getY());
            System.out.println(p.getX());
            System.out.println(p.getY());
        }
    }//Y hauteur // X largeur

}
