package model;

public class Plateforme extends ElementCarte{
    boolean visible;

    public Plateforme(int cordx, int cordy, int hitbox, boolean visible) {
        super(cordx, cordy, hitbox);
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
