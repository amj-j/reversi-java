package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import structures.Owner;

public class Player {
    private Owner player;
    private String name;
    private Color color;
    private int tokenCount;

    public Player( Owner player, String name, Color color) {
        this.player = player;
        this.name = name;
        this.color = color;
        this.tokenCount = tokenCount;
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
