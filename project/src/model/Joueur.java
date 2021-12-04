package model;
import javafx.scene.image.Image;

public class Joueur extends Entite {
    private int vie;
    private char pseudo;


    public Joueur(int SpawnX, int SpawnY, Image Skin, int XHitBox, int YHitBox, char Pseudo) {
        super(SpawnX, SpawnY,  Skin, XHitBox, YHitBox);
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

    public char getPseudo() {
        return pseudo;
    }

    public void setPseudo(char pseudo) {
        this.pseudo = pseudo;
    }
}
