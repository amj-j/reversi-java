package view.input_components;

import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

import interfaces.HighlightMovesListener;
import interfaces.ReversiViewInterface;
import view.DefaultViewSettings;


public class HighlightMovesChanger extends JCheckBox implements ActionListener {
    ReversiViewInterface view;
    ArrayList<HighlightMovesListener> listeners = new ArrayList<>();

    public HighlightMovesChanger(ReversiViewInterface view) {
        super("Highlight moves", view.areMovesHighlighted());
        this.view = view;
        addActionListener(this);
        setBackground(DefaultViewSettings.BG_COLOR);
    }

    public void reset() {
        setSelected(view.areMovesHighlighted());
        repaint();
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
