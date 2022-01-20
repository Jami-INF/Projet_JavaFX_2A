package model;
import model.persistance.IPersistanceTemps;

import java.util.ArrayList;
import java.util.List;

public class manager {
    public IPersistanceTemps persT;
    public scoresParties scoresPartie;
    public List<score> sc;

    /**
     * Constructeur du manager
     * @param iT
     */
    public manager(IPersistanceTemps iT){
        persT = iT;
        sc = chargerTemps();
        scoresPartie = new scoresParties(sc);
    }

    /**
     * Charge les scores depuis la persistance
     * @return
     */
    public List chargerTemps(){

        return persT.chargerTemps();
    }

    /**
     * Sauvegarde les scores dans la persistance
     * @param sc
     */
    public void sauvegarderResultat(List<score> sc) {
        persT.sauverTemps(sc);
    }

    /**
     * Ajoute un score dans la liste des scores
     * @param pseudo
     * @param score
     */
    public void ajouterScore(String pseudo, int score) {
        scoresPartie.ajouterScore(pseudo, score);
    }

    /**
     * Retourne la liste des scores
     * @return
     */
    public List<score> getScoresParties() {
        return this.sc;
        //return scoresPartie.getListeScores();
    }

}
