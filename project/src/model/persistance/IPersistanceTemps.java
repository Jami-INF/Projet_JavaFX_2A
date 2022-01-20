package model.persistance;

import model.score;

import java.util.List;

public interface IPersistanceTemps {

    List chargerTemps();
    void sauverTemps(List<score> listeScores);//List <Temps> temps ??
}
