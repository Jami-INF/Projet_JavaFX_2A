package model;

import javax.management.AttributeList;

public class score {
    private int temps;
    private String pseudo;

    public score(String Pseudo, int Temps) {
        this.pseudo = Pseudo;
        this.temps = Temps;
    }


    public String getPseudo() {
        return this.pseudo;
    }
    public int getTemps() {
        return this.temps;
    }
    public void setPseudo(String Pseudo) {
        this.pseudo = Pseudo;
    }
    public void setTemps(int Temps) {
        this.temps = Temps;
    }
}
