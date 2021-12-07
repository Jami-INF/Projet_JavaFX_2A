package model;
import javafx.scene.image.Image;

public abstract class Entite {
    private int spawnX;
    private int spawnY;
    private int x;
    private int y;
    private Image skin;
    private int xHitBox;
    private int yHitBox;

    public Entite(int SpawnX, int SpawnY, Image Skin, int XHitBox, int YHitBox){
        spawnX = SpawnX;
        spawnY = SpawnY;
        skin = Skin;
        x = SpawnX;
        y = SpawnY;
        xHitBox = XHitBox;
        yHitBox = YHitBox;
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
        x = (x + 10);
    }

    public void mouvementarriereX() {
        x = (x - 10);
    }

    public void mouvementY() {
        y = (y + 10);
    }
    public void saut(int Y) {
        y = (y + Y);
    }
}

