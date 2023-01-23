package model;

public class Tile {
    private Player owner = null;
    private boolean playable = false;

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public void setPlayable(boolean bool) {
        this.playable = bool;
    }

    public Player getOwner() {
        return this.owner;
    }

    public boolean isPlayable() {
        return this.playable;
    }
}
