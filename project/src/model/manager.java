package model;
import model.persistance.IPersistanceTemps;

import java.util.ArrayList;
import java.util.List;

public class manager {
    public IPersistanceTemps persT;
    public scoresParties scoresPartie;
    public List<score> sc;

    public manager(IPersistanceTemps iT){
        persT = iT;
        sc = chargerTemps();
        scoresPartie = new scoresParties(sc);
    }

    public List chargerTemps(){

        return persT.chargerTemps();
    }
    public void sauvegarderResultat() {
        persT.sauverTemps(scoresPartie.getListeScores());
    }
    public void ajouterScore(String pseudo, int score) {
        scoresPartie.ajouterScore(pseudo, score);
    }
    public List<score> getScoresParties() {
        return this.sc;
        //return scoresPartie.getListeScores();
    }

}
