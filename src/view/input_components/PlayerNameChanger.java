package view.input_components;

import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

import structures.*;
import view.DefaultViewSettings;
import interfaces.PlayerNameListener;

public class PlayerNameChanger extends JPanel implements ActionListener {
    Player player;
    JTextField playerName;
    JButton playerSaveButton;
    ArrayList<PlayerNameListener> listeners = new ArrayList<>();

    public PlayerNameChanger(Player player) {
        this.player = player;
        this.playerName = new JTextField(player.getName());
        this.playerSaveButton = new JButton("Save");
        add(this.playerName);
        add(this.playerSaveButton);
        playerSaveButton.addActionListener(this);
        setBackground(DefaultViewSettings.BG_COLOR);
    }

    public void reset(String name) {
        playerName.setText(name);
        repaint();
    }
    
    public void actionPerformed(ActionEvent e) {
        for (PlayerNameListener it : listeners) {
            it.nameChanged(playerName.getText(), player);
        }
    }

    public void addListener(PlayerNameListener listener) {
        listeners.add(listener);
    }
}
