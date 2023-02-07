package view.input_components;

import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

import interfaces.SingleplayerListener;
import interfaces.ReversiViewInterface;
import view.DefaultViewSettings;


public class SingleplayerChanger extends JCheckBox implements ActionListener {
    ReversiViewInterface view;
    ArrayList<SingleplayerListener> listeners = new ArrayList<>();

    public SingleplayerChanger(ReversiViewInterface view) {
        super("Singleplayer", view.isSingleplayer());
        this.view = view;
        addActionListener(this);
        setBackground(DefaultViewSettings.BG_COLOR);
    }

    public void reset() {
        setSelected(view.isSingleplayer());
        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        boolean bool = isSelected();
        for (SingleplayerListener it : listeners) {
            it.setSingleplayer(bool);
        }
    }

    public void addListener(SingleplayerListener listener) {
        listeners.add(listener);
    }

}
