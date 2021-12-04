package controller;
import java.util.ArrayList;
import model.Joueur;
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

    public void removeInput(String s)
    {
        input.remove(s);
    }

}
