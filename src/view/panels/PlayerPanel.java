package view.panels;

import java.awt.*;
import javax.swing.*;

import structures.Player;
import view.DefaultViewSettings;

public class PlayerPanel extends JPanel {
    Player owner;
    JLabel name;
    JLabel color;
    JLabel tokenCount;

    public PlayerPanel(Player owner) {
        this.owner = owner;
        //setBackground(new Color(50, 50, 50));
        setBackground(DefaultViewSettings.BG_COLOR);
        this.name = new JLabel("Jano");
        this.color = new JLabel();
        this.tokenCount = new JLabel("0");
        setValues();
        add(this.name);
        add(this.color);
        add(tokenCount);
    }

    @Override
    protected void paintComponent(Graphics g) {
        setValues();
        super.paintComponent(g);
    }

    private void setValues() {
        int fontSize = Math.min(getHeight(), getWidth()) /3;
        Font font = new Font(DefaultViewSettings.FONT_NAME, Font.BOLD, fontSize);
        this.name.setFont(font);
        this.tokenCount.setFont(font);
        this.name.setText(owner.getName());
        tokenCount.setText(Integer.toString(owner.getTokenCount()));

    }
}
