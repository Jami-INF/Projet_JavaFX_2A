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

    public void CheckCollision (Joueur j, ArrayList<Plateforme> plateformeArrayList) {
        //System.out.println(J.getX());
        int WidthJ = (int) j.getImage().getWidth();
        int HeightJ = (int) j.getImage().getHeight();

        //pour toutes les plateformes dans la liste
        for (Plateforme p : plateformeArrayList){
            int WidthP = (int) p.getImage().getWidth();
            int HeightP = (int) p.getImage().getHeight();

            if( (p.getX() >= j.getX()) && (p.getY() >= j.getY()) && ( ( (p.getX()+WidthP) <= j.getX()+WidthJ) && (p.getY()+HeightP) <= j.getY()+HeightJ) ) {
            //if(p.intersect(j.getX(),j.getY()))
                System.out.println("Collision");
            }

        }
    }//Y hauteur // X largeur

}
