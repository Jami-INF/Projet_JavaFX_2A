package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Permet de gérer la liste des temps et de leurs pseudos associées
 */
public class scoresParties {
    private List<score> listeScores;

    public scoresParties(List<score> listeScores) {
        this.listeScores = listeScores;
    }
    public List<score> getListeScores() {
        List<score> listeScores = new ArrayList<score>();
        listeScores.add(new score("Joueur1", 10));
        return listeScores;
        //return listeScores;
    }

    public void setListeScores(List<score> listeScores) {
        this.listeScores = listeScores;
    }
    public void ajouterScore(String pseudo, int temps){
        listeScores.add(new score(pseudo, temps));
    }

}
