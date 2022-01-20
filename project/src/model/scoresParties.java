package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Permet de gérer la liste des temps et de leurs pseudos associées
 */
public class scoresParties {
    private List<score> listeScores;

    /**
     * Constructeur de la classe scoresParties
     * @param listeScores
     */
    public scoresParties(List<score> listeScores) {
        this.listeScores = listeScores;
    }

    /**
     * Retourne la liste des scores
     * @return
     */
    public List<score> getListeScores() {
        List<score> listeScores = new ArrayList<score>();
        listeScores.add(new score("Joueur1", 10));
        return listeScores;
        //return listeScores;
    }

    /**
     * modifie la liste actuelle des scores
     * @param listeScores
     */
    public void setListeScores(List<score> listeScores) {
        this.listeScores = listeScores;
    }

    /**
     * Ajoute un score à la liste des scores
     * @param pseudo
     * @param temps
     */
    public void ajouterScore(String pseudo, int temps){
        listeScores.add(new score(pseudo, temps));
    }

}
