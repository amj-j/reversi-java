package structures;

import java.awt.*;

public class Player {
    private Owner owner;
    private String name;
    private Color color;
    private int tokenCount;

    public Player(Owner owner, String name, Color color) {
        this.owner = owner;
        this.name = name;
        this.color = color;
        this.tokenCount = 0;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void changeColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public void setTokenCount(int tokenCount) {
        this.tokenCount = tokenCount;
    }

    public int getTokenCount() {
        return this.tokenCount;
    }
}
