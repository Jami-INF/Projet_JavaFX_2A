package model;
import javafx.scene.image.Image;

public class Joueur extends Entite {
    private int vie;
    private String pseudo;
    private boolean inJump;


    public Joueur(Image Skin, double VelociteX, double VelociteY, double Size, String Pseudo) {
        super(Skin, VelociteX, VelociteY, Size);
        vie=10;//A modifier peut etre ?
        Pseudo = pseudo;

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
