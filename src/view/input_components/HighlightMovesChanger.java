package view.input_components;

import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

import interfaces.HighlightMovesListener;
import interfaces.ReversiViewInterface;
import view.DefaultViewSettings;


public class HighlightMovesChanger extends JCheckBox implements ActionListener {
    
    ArrayList<HighlightMovesListener> listeners = new ArrayList<>();

    public HighlightMovesChanger(ReversiViewInterface view) {
        super("Highlight moves", view.areMovesHighlighted());
        addActionListener(this);
        setBackground(DefaultViewSettings.BG_COLOR);
    }

    public void actionPerformed(ActionEvent e) {
        boolean bool = isSelected();
        for (HighlightMovesListener it : listeners) {
            it.setHighlightMoves(bool);
        }
    }

    public void addListener(HighlightMovesListener listener) {
        listeners.add(listener);
    }
}
