package logic;

public class Player {
    private String name;
    private int tokenNum;

    public Player(String name) {
        this.name = name;
        tokenNum = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getTokenNum() {
        return this.tokenNum;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void changeTokenNum(int amount) {
        this.tokenNum += amount;
    }
}
