package model;
import javafx.scene.image.Image;

public abstract class Entite{
    private int spawnX;
    private int spawnY;
    private int x;
    private int y;
    private Image skin;
    private int xHitBox;
    private int yHitBox;
    private int velociteX; //😊
    private int velociteY;

    public Entite(int SpawnX, int SpawnY, Image Skin, int XHitBox, int YHitBox, int velocitex, int velociteY){
        spawnX = SpawnX;
        spawnY = SpawnY;
        skin = Skin;
        x = SpawnX;
        y = SpawnY;
        xHitBox = XHitBox;
        yHitBox = YHitBox;
        velocitex = 0;
        velociteY = 0;
    }

    public int getSpawnX() {
        return spawnX;
    }
    public int getSpawnY() {
        return spawnY;
    }

    public void setSpawnX(int spawnX) {
        this.spawnX = spawnX;
    }

    public void setSpawnY(int spawnY) {
        this.spawnY = spawnY;
    }

    public Image getSkin() {
        return skin;
    }

    public void setSkin(Image skin) {
        this.skin = skin;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getxHitBox() {
        return xHitBox;
    }

    public void setxHitBox(int xHitBox) {
        this.xHitBox = xHitBox;
    }

    public int getyHitBox() {
        return yHitBox;
    }

    public void setyHitBox(int yHitBox) {
        this.yHitBox = yHitBox;
    }

    public void setX(int x) {
        x = x;
    }

    public void setY(int y) {
        y = y;
    }

    public void mouvementavantX() {
        x = (x + 5);
    }

    public void mouvementarriereX() {
        x = (x - 5);
    }

    public void mouvementY() {
        y = (y + 5);
    }
    public void saut(int Y) {
        y = (y + Y);
    }
    public void mouvementbas(){
        y = (y + 5);
    }

    public void mouvementhaut(){
        y = (y - 5);
    }
    public void gravite(){
        y = (y + 1);
    }
    public void collision(){
        y = (y - 1);
    }
    public Image getImage(){
        return skin;
    }
    public int getVelociteX() {
        return velociteX;
    }

    public int getVelociteY() {
        return velociteY;
    }

    public void setVelociteX(int velociteX) {
        this.velociteX = velociteX;
    }

    public void setVelociteY(int velociteY) {
        this.velociteY = velociteY;
    }
}
