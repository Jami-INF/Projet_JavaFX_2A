package model;
import controller.mouvement;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.control.Skin;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Joueur extends Entite {

    private int vie;
    private String pseudo;
    private double velociteY;
    private double velociteX;
    private boolean inJump;
    private boolean canJump;
    private boolean isMouvementAvant;
    private boolean isMouvementArriere;
    private double jumpHauteur = 150;
    private double gravite = 5;
    private double size;
    private Image skin;
    private double imageSize;
    private boolean isCollideUp = false;
    private boolean isCollideDown = false;
    private boolean isCollideLeft = false;
    private boolean isCollideRight = false;
    private int dureesauttmp = 0;//variable temporaire pour savoir depuis combien de temps le joueur est en train de sauter


    /**
     * Constructeur de Joueur
     * @param Skin
     * @param VelociteX
     * @param VelociteY
     * @param Size
     * @param SpawnX
     * @param SpawnY
     * @param Pseudo
     */
    public Joueur(Image Skin, double VelociteX, double VelociteY, double Size, double SpawnX, double SpawnY, String Pseudo) {
        super(Skin, VelociteX, VelociteY, Size, SpawnX, SpawnY);
        vie=10;//A modifier peut etre ?
        Pseudo = pseudo;
        isMouvementArriere=false;
        isMouvementAvant = false;
        velociteX = VelociteX;
        velociteY = VelociteY;
        size = Size;
        skin = Skin;
        imageSize = size;
        setFitWidth(imageSize);
        setFitHeight(imageSize);

    }

    /**
     * Methode qui permet de connaitre la vie du joueur
     * @return vie du joueur en int
     */
    public int getVie()
    {
        return vie;
    }

    /**
     * Methode qui permet de seter la vie du joueur
     * @param pv
     */
    public void setVie(int pv)
    {
        vie=pv;
    }

    /**
     * Methode qui permet de récuperer le pseudo du joueur
     * @return pseudo du joueur en String
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * Methode qui permet de seter le pseudo du joueur
     * @param pseudo
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * Methode qui permet de savoir si le joueur est en train de sauter
     * @return inJump en boolean
     */
    public Boolean isInJump () {
        return inJump;
    }

    /**
     * Methode qui permet de setter le fait que le joueur soit en train de sauter
     * @param b
     */
    public void setInJump (Boolean b) {
        inJump = b;
    }

    /**
     * Methode qui permet de savoir si le joueur est en collision avec le plafond
     * @return isCollideUp en boolean
     */
    public Boolean getiscollideUp() {
        return isCollideUp;
    }

    /**
     * Methode qui permet de setter si le joueur est en collision avec le plafond
     * @param b
     */
    public void setiscollideUp(Boolean b) {
        isCollideUp = b;
    }

    /**
     * Methode qui permet de savoir si le joueur est en collision avec le sol
     * @return isCollideDown en boolean
     */
    public Boolean getiscollideDown() {
        return isCollideDown;
    }

    /**
     * Methode qui permet de setter si le joueur est en collision avec le sol
     * @param b
     */
    public void setiscollideDown(Boolean b) {
        isCollideDown = b;
    }

    /**
     * Methode qui permet de savoir si le joueur est en collision sur la gauche
     * @return isCollideLeft en boolean
     */
    public Boolean getiscollideLeft() {
        return isCollideLeft;
    }

    /**
     * Methode qui permet de setter si le joueur est en collision sur la gauche
     * @param b
     */
    public void setiscollideLeft(Boolean b) {
        isCollideLeft = b;
    }

    /**
     * Methode qui permet de savoir si le joueur est en collision sur la droite
     * @return isCollideRight en boolean
     */
    public Boolean getiscollideRight() {
        return isCollideRight;
    }

    /**
     * Methode qui permet de setter si le joueur est en collision sur la droite
     * @param b
     */
    public void setiscollideRight(Boolean b) {
        isCollideRight = b;
    }

    /**
     * Methode qui permet de setter la velocitéX du joueur
     * @param velociteX
     */
    public void setVelociteX(double velociteX) {
        this.velociteX = velociteX;
    }

    /**
     * Methode qui permet de setter la velocitéY du joueur
     * @param velociteY
     */
    public void setVelociteY(double velociteY) {
        this.velociteY = velociteY;
    }

    /**
     * Methode qui permet de recupérer la velocitéX du joueur
     * @return velociteX en double
     */
    public double getVelociteX() {
        return velociteX;
    }

    /**
     * Methode qui permet de recupérer la velocitéY du joueur
     * @return velociteY en double
     */
    public double getVelociteY() {
        return velociteY;
    }



    /**
     * Methode qui permet de seter la gravité pour le joueur
     * @param gravite
     */
    public void setGravite(double gravite) {
        this.gravite = gravite;
    }

    /**
     * Methode qui permet de recupérer la gravité du joueur
     * @return gravite en double
     */
    public double getGravite() {
        return gravite;
    }

    /**
     * Methode qui permet de seter la taille du joueur
     * @param size
     */
    public void setSize(double size) {
        this.size = size;
    }

    /**
     * Methode qui permet de recupérer la taille du joueur
     * @return
     */
    public double getSize() {
        return size;
    }

    /**
     * Methode qui permet de seter le skin du joueur
     * @param skin
     */
    public void setSkin(Image skin) {
        this.skin = skin;
    }

    /**
     * Methode qui permet de recupérer le skin du joueur
     * @return
     */
    public Image getSkin() {
        return skin;
    }

    /**
     * Methode qui permet de seter l'image du skin du joueur
     * @param imageSize
     */
    public void setImageSize(double imageSize) {
        this.imageSize = imageSize;
    }

    /**
     * Methode qui permet de recupérer l'image du skin du joueur
     * @return
     */
    public double getImageSize() {
        return imageSize;
    }

    /**
     * Methode qui permet de récuperer la durée du saut en cours du joueur
     * @return
     */
    public int getDureesauttmp() {
        return dureesauttmp;
    }

    /**
     * Methode qui permet de seter la durée du saut en cours du joueur
     * @param dureesauttmp
     */
    public void setDureesauttmp(int dureesauttmp) {
        this.dureesauttmp = dureesauttmp;
    }

    /**
     * Methode qui permet de seter la possibiliter de sauter pour le joueur
     * @param canJump
     */
    public void setCanJump(boolean canJump) {
        this.canJump = canJump;
    }
    /**
     * Methode qui permet de savoir si le joueur peut sauter
     * @return canJump en boolean
     */
    public boolean getCanJump() {
        return canJump;
    }

    /**
     * Methode qui permet de setter les booleens de mouvement du joueur si il avance
     */
    public void mouvementavantX() {
        isMouvementAvant = true;
        isMouvementArriere = false;
        isCollideLeft = false;
        //IV.setX(IV.getX()+5);
    }

    /**
     * Methode qui permet de setter les booleens de mouvement du joueur si il recule
     */
    public void mouvementarriereX() {
        isMouvementArriere = true;
        isMouvementAvant = false;
        isCollideRight = false;
    }

    /**
     * Methode qui permet de setter les booleens de mouvement du joueur si il arrete de bouger
     */
    public void arretmouvement(){
        isMouvementArriere = false;
        isMouvementAvant = false;
        isCollideLeft = false;
        isCollideRight = false;
    }

    /**
     * Methode qui permet de récuperer les booleens de mouvement du joueur si il recule
     * @return isMouvementArriere en boolean
     */
    public boolean getisMouvementArriere(){
        return isMouvementArriere;
    }

    /**
     * Methode qui permet de récuperer les booleens de mouvement du joueur si il avance
     * @return isMouvementAvant en boolean
     */
    public boolean getisMouvementAvant(){
        return isMouvementAvant;
    }

    /**
     * Methode qui permet de faire sauter le joueur si il est en collision avec le sol
     */
    public void saut() {

        if (canJump && isCollideDown) {
            dureesauttmp = 0;
            inJump = true;
            canJump = false;
            //System.out.println("mouvement saut");
        }

    }

}