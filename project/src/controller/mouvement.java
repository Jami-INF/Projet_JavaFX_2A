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
        for (Plateforme p : plateformeArrayList){                    //pour toutes les plateformes dans la liste
            //System.out.println(p.getX());
            if (j.getX() <= p.getX()  && j.getY() >= p.getY()) {
                System.out.println("Collision");
            }
        }
    }

}
