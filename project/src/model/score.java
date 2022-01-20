package model;

import javax.management.AttributeList;

public class score {
    private int temps;
    private String pseudo;

    /**
     * Constructeur de la classe score
     * @param Pseudo
     * @param Temps
     */
    public score(String Pseudo, int Temps) {
        this.pseudo = Pseudo;
        this.temps = Temps;
    }

    /**
     * récupération du pseudo du joueur
     * @return Retourne le pseudo du joueur
     */
    public String getPseudo() {
        return this.pseudo;
    }

    /**
     * Récupération du temps du joueur
     * @return Retourne le temps du joueur
     */
    public int getTemps() {
        return this.temps;
    }

    /**
     * Modifier le pseudo du joueur
     * @param Pseudo
     */
    public void setPseudo(String Pseudo) {
        this.pseudo = Pseudo;
    }

    /**
     * Modifier le temps du joueur
     * @param Temps
     */
    public void setTemps(int Temps) {
        this.temps = Temps;
    }
}
