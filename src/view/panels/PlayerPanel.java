package view.panels;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import structures.Player;
import view.DefaultViewSettings;

public class PlayerPanel extends JPanel {
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
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) { setFont(); }
        });
    }

    public void setValues() {    
        setFont();
        this.name.setText(owner.getName());
        tokenCount.setText(Integer.toString(owner.getTokenCount()));
    }

    public void setFont() {
        int fontSize = Math.min(getHeight(), getWidth()) /2;
        Font font = new Font(DefaultViewSettings.FONT_NAME, Font.BOLD, fontSize);
        this.name.setForeground(owner.getColor());
        this.tokenCount.setForeground(owner.getColor());
        this.name.setFont(font);
        this.tokenCount.setFont(font);
    }
}
