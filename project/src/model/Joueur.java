package model;
import javafx.scene.image.Image;

public class Joueur extends Entite {

    private int vie;
    private String pseudo;
    private boolean inJump;
    private boolean isMouvementAvant;
    private boolean isMouvementArriere;
    private double yAcceleration;
    private double jumpHauteur = 10;
    private double velociteX;
    private double velociteY;
    private double gravite = 5;


    public Joueur(Image Skin, double VelociteX, double VelociteY, double Size, String Pseudo) {
        super(Skin, VelociteX, VelociteY, Size);
        vie=10;//A modifier peut etre ?
        Pseudo = pseudo;
        isMouvementArriere=false;
        isMouvementAvant = false;


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
    public void setInJump (Boolean b) {
        inJump =b;
    }
    public void mouvementavantX() {
        isMouvementAvant = true;
        isMouvementArriere = false;
        IV.setX(IV.getX()+5);
        System.out.println("zefzfezfe");
    }
    public void mouvementarriereX() {
        isMouvementArriere = true;
        isMouvementAvant = false;
    }
    public void arretmouvement(){
        isMouvementArriere = false;
        isMouvementAvant = false;
    }

    public boolean getisMouvementArriere(){
        return isMouvementArriere;
    }
    public boolean getisMouvementAvant(){
        return isMouvementAvant;
    }

    public void saut() {
        velociteY = velociteY-jumpHauteur;
    }
    public void update() {
        System.out.println(getisMouvementAvant());
        updateMouvementX();// obstacle coté
        updateMouvementY();//gravité + plateforme bas
    }
    public void updateMouvementX(){
        if (isMouvementAvant == true) {
            IV.setX(getX() + velociteX);
        }
        if (isMouvementArriere == true) {
            IV.setX(getX() - velociteX);
        }

    }
    void updateMouvementY() {//ArrayList<Plateforme> plateformeArrayList
        velociteY += gravite;
        IV.setY(getY() + velociteY);
    }
}
