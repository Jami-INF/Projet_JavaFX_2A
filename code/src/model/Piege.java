package model;

public class Piege extends ElementCarte{
    int degats;
    boolean active;
    boolean visible;

    public Piege(int cordx, int cordy, int hitbox, int degats, boolean active, boolean visible) {
        super(cordx, cordy, hitbox);
        this.degats = degats;
        this.active = active;
        this.visible = visible;
    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
