package view.panels.game_menu;

import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

import interfaces.*;

public class NewGameButton extends JButton implements ActionListener {

    ArrayList<NewGameListener> listeners = new ArrayList<>();

    public NewGameButton() {
        super("New Game");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        for (NewGameListener it : listeners) {
            it.startNewGame();
        }
    }

    public void addListener(NewGameListener listener) {
        listeners.add(listener);
    }
}
