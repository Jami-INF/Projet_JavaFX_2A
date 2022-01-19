package model;
import model.persistance.IPersistanceTemps;

import java.util.List;

public class manager {
    private IPersistanceTemps persT;
    private scoresParties scoresParties;

    public manager(IPersistanceTemps iT){
        persT = iT;
    }

    public List chargerTemps(){
        return persT.chargerTemps();
    }
    public void sauvegarderResultat(List<score> listeScores) {
        persT.sauverTemps(listeScores);
    }
    public void ajouterScore(String pseudo, int score) {
        scoresParties.ajouterScore(pseudo, score);
    }
    public List<score> getScoresParties() {
        return scoresParties.getListeScores();
    }

}
