package model;

public class Player {
    private int tokenCount;

    public Player() {
        this.tokenCount = 0;
    }

    public int getTokenCount() {
        return this.tokenCount;
    }

    public void changeTokenCount(int amount) {
        this.tokenCount += amount;
    }
}
