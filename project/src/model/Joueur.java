package model;
import javafx.scene.image.Image;

public class Joueur extends Entite {
    private int vie;
    private String pseudo;
    private boolean inJump;


    public Joueur(int SpawnX, int SpawnY, Image skin, int XHitBox, int YHitBox, int velociteX, int velociteY, String Pseudo, boolean InJump) {
        super(SpawnX, SpawnY,  skin, XHitBox, YHitBox, velociteX, velociteY);
        vie=10;//A modifier peut etre ?
        Pseudo = pseudo;
        boolean inJump = InJump;

    }

    public int getVie()
    {
        return vie;
    }

    public void setVie(int pv)
    {
        vie=pv;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Boolean isInJump () {
        return inJump;
    }
    public void inversInJump () {
        if(inJump == true)
            inJump = false;
        else
            inJump = true;
    }
    public void setInJump (Boolean b) {
        if(b == true)
            inJump = true;
        else
            inJump = false;
    }
}
