package model;

public abstract class ElementCarte {
    int cordx;
    int cordy;
    int hitbox;

    public ElementCarte(int cordx, int cordy, int hitbox) {
        this.cordx = cordx;
        this.cordy = cordy;
        this.hitbox = hitbox;
    }

}
