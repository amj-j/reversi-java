package view.input_components;

import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

import interfaces.NewGameListener;

public class NewGameButton extends JButton implements ActionListener {
    ArrayList<NewGameListener> listeners = new ArrayList<>();

    public NewGameButton() {
        super("New Game");
        addActionListener(this);
    }

    public void addListener(NewGameListener listener) {
        listeners.add(listener);
    }

    public void actionPerformed(ActionEvent e) {
        for (NewGameListener it : listeners) {
            it.startNewGame();
        }
    }
}
