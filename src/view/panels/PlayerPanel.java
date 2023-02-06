package view.panels;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import structures.Player;
import view.DefaultViewSettings;

public class PlayerPanel extends JPanel implements ComponentListener {
    Player owner;
    JLabel name;
    JLabel playerColor;
    JLabel tokenCount;

    public PlayerPanel(Player owner) {
        this.owner = owner;
        setBackground(DefaultViewSettings.BG_COLOR);
        this.name = new JLabel("Jano");
        this.playerColor = new JLabel();
        this.tokenCount = new JLabel("0");
        add(this.name);
        add(this.playerColor);
        add(tokenCount);
        setValues();
        setFont();
        addComponentListener(this);
    }

    public void setValues() {    
        setFont();
        this.name.setText(owner.getName());
        tokenCount.setText(Integer.toString(owner.getTokenCount()));
    }

    public void setFont() {
        int fontSize = Math.min(getHeight(), getWidth()) /2;
        Font font = new Font(DefaultViewSettings.FONT_NAME, Font.BOLD, fontSize);
        this.name.setForeground(DefaultViewSettings.FONT_COLOR);
        this.tokenCount.setForeground(DefaultViewSettings.FONT_COLOR);
        this.name.setFont(font);
        this.tokenCount.setFont(font);
    }

    public void componentResized(ComponentEvent e) { setFont(); }
    public void componentMoved(ComponentEvent e) {}
    public void componentShown(ComponentEvent e) {}
    public void componentHidden(ComponentEvent e) {}
}
